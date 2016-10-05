package com.padc.travelling.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.HotelAdapter;
import com.padc.travelling.data.agents.retrofit.RetrofitDataAgent;
import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.data.model.HotelsModel;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.HotelsVO;
import com.padc.travelling.utils.TravellingConstants;
import com.padc.travelling.view.HotelViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;


public class HotelFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    @BindView(R.id.rv_hotel)
    RecyclerView rvHotel;

    @BindView(R.id.swipe_refresh_layout_hotel)
    SwipeRefreshLayout refreshHotel;

    private List<HotelsVO> hotelVOList = new ArrayList<>();
    private HotelAdapter hotelAdapter;
    private HotelViewHolder.ControllerHotel mControllerHotel;

    public HotelFragment() {
        // Required empty public constructor
    }

    private BroadcastReceiver mDataLoadedBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //TODO instructions when the new data is ready.
            String extra = intent.getStringExtra("key-for-extra");
            Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

            List<HotelsVO> newHotelList = HotelsModel.getInstance().getHotelsList();
            hotelAdapter.setNewData(newHotelList);
        }
    };

    public static HotelFragment newInstance() {
        HotelFragment fragment = new HotelFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hotel, container, false);
        ButterKnife.bind(this, rootView);

        //prepareData();

        hotelVOList = HotelsModel.getInstance().getHotelsVOList();
        hotelAdapter = new HotelAdapter(hotelVOList, mControllerHotel);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvHotel.setLayoutManager(layoutManager);
        rvHotel.setAdapter(hotelAdapter);

        refreshHotel.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                RetrofitDataAgent.getInstance().loadHotels();
            }
        });

        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerHotel = (HotelViewHolder.ControllerHotel) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getSupportLoaderManager().initLoader(TravellingConstants.HOTEL_LIST_LOADER, null, this);
    }


    @Override
    public void onStart() {
        super.onStart();

        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mDataLoadedBroadcastReceiver,
                new IntentFilter(HotelsModel.BROADCAST_DATA_LOADED));
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus eventBus = EventBus.getDefault();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(mDataLoadedBroadcastReceiver);
        if (!eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }

    public void onEventMainThread(DataEvent.HotelsDataLoadedEvent event) {
        refreshHotel.setRefreshing(false);
        String extra = event.getExtraMessage();
//        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        Log.e("HotelFragment", "finish loading");
        List<HotelsVO> newHotelsList = event.getHotelsList();
        hotelAdapter.setNewData(newHotelsList);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                TravelMyanmarContract.HotelEntry.CONTENT_URI,
                null,
                null,
                null,
                TravelMyanmarContract.HotelEntry.COLUMN_NAME + " ASC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        List<HotelsVO> hotelList = new ArrayList<>();
        if (data != null && data.moveToFirst()) {
            do {
                HotelsVO hotel = HotelsVO.parseFromCursor(data);
                hotel.setPhotos(HotelsVO.loadHotelPhotoByTitle(hotel.getHotel_name()));
                hotelList.add(hotel);
            } while (data.moveToNext());
        }

        Log.d(TravellingApp.TAG, "Retrieved attractions ASC - GridView : " + hotelList.size());
        hotelAdapter.setNewData(hotelList);

        HotelsModel.getInstance().setStoredData(hotelList);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

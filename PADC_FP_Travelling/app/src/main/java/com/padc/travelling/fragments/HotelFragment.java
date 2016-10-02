package com.padc.travelling.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.adapters.HotelAdapter;
import com.padc.travelling.data.vos.HotelsVO;
import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.data.model.HotelsModel;
import com.padc.travelling.view.HotelViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;


public class HotelFragment extends Fragment {

    @BindView(R.id.rv_hotel)
    RecyclerView rvHotel;

    @BindView(R.id.swipe_refresh_layout_hotel)
    SwipeRefreshLayout layout;

    private List<HotelsVO> hotelVOList = new ArrayList<>();
    private HotelAdapter hotelAdapter;
    private HotelViewHolder.ControllerHotel mControllerHotel;

    public HotelFragment() {
        // Required empty public constructor
    }

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

        return rootView;
    }

    private void prepareData() {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerHotel = (HotelViewHolder.ControllerHotel) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }

    public void onEventMainThread(DataEvent.HotelsDataLoadedEvent event) {
        layout.setRefreshing(false);
        String extra = event.getExtraMessage();
//        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        Log.e("HotelFragment", "finish loading");
        List<HotelsVO> newHotelsList = event.getHotelsList();
        hotelAdapter.setNewData(newHotelsList);
    }
}

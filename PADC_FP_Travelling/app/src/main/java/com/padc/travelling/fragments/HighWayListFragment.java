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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.HighWayListAdapter;
import com.padc.travelling.components.SpacesItemDecoration;
import com.padc.travelling.data.agents.retrofit.RetrofitDataAgent;
import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.data.model.BusComponiesModel;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.BusComponiesVO;
import com.padc.travelling.data.vos.RoutesVO;
import com.padc.travelling.utils.NetworkUtils;
import com.padc.travelling.utils.TravellingConstants;
import com.padc.travelling.view.HighWayListViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by dellpc on 11-Sep-16.
 */
public class HighWayListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    @BindView(R.id.rv_highwaylist)
    RecyclerView rvHighWayList;

    @BindView(R.id.swipe_refresh_layout_highway)
    SwipeRefreshLayout swipeRefreshLayout;

    private List<BusComponiesVO> highwayCompanyVOList = new ArrayList<>();
    private List<RoutesVO> routeVOList = new ArrayList<>();
    private HighWayListAdapter highWayListAdapter;
    private HighWayListViewHolder.ControllerHighWayList mControllerHighWayList;

    private BroadcastReceiver mDataLoadedBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //TODO instructions when the new data is ready.
            String extra = intent.getStringExtra("key-for-extra");
            Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

            List<BusComponiesVO> newBusCompanyList = BusComponiesModel.getInstance().getBusComponiesVOList();
            highWayListAdapter.setNewData(newBusCompanyList);
        }
    };

    public static HighWayListFragment newInstance() {
        HighWayListFragment fragment = new HighWayListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_high_way_list, container, false);
        ButterKnife.bind(this, rootView);

        //prepareData();

        highwayCompanyVOList = BusComponiesModel.getInstance().getBusComponiesVOList();
        highWayListAdapter = new HighWayListAdapter(highwayCompanyVOList, mControllerHighWayList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        rvHighWayList.setLayoutManager(layoutManager);
        rvHighWayList.setAdapter(highWayListAdapter);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        rvHighWayList.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(NetworkUtils.isOnline(TravellingApp.getContext())) {
                    RetrofitDataAgent.getInstance().loadBusComponies();
                    swipeRefreshLayout.setRefreshing(false);
                }
                else {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });


        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerHighWayList = (HighWayListViewHolder.ControllerHighWayList) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getSupportLoaderManager().initLoader(TravellingConstants.BUSCOMPANY_LIST_LOADER, null, this);
    }

    @Override
    public void onStart() {
        super.onStart();

        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mDataLoadedBroadcastReceiver,
                new IntentFilter(BusComponiesModel.BROADCAST_DATA_LOADED));

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(mDataLoadedBroadcastReceiver);

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }

    public void onEventMainThread(DataEvent.BusComponiesDataLoadedEvent event) {
        swipeRefreshLayout.setRefreshing(false);
        String extra = event.getExtraMessage();
//        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        Log.e("HighwayFragment", "finish loading");
        List<BusComponiesVO> newBusComponiesList = event.getBusComponiesVOsList();
        highWayListAdapter.setNewData(newBusComponiesList);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                TravelMyanmarContract.HighwayBusEntry.CONTENT_URI,
                null,
                null,
                null,
                TravelMyanmarContract.HighwayBusEntry.COLUMN_NAME + " ASC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        List<BusComponiesVO> buscompanyList = new ArrayList<>();
        if (data != null && data.moveToFirst()) {
            do {
                BusComponiesVO buscompany = BusComponiesVO.parseFromCursor(data);
                buscompany.setPhotos(BusComponiesVO.loadBusCompanyPhotosByName(buscompany.getName()));
                buscompanyList.add(buscompany);
            } while (data.moveToNext());
        }

        Log.d(TravellingApp.TAG, "Retrieved attractions ASC - GridView : " + buscompanyList.size());
        highWayListAdapter.setNewData(buscompanyList);

        BusComponiesModel.getInstance().setStoredData(buscompanyList);
        BusComponiesModel.getInstance().setStoredDataRoute(routeVOList);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

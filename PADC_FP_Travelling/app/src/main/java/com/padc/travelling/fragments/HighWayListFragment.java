package com.padc.travelling.fragments;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;

import com.padc.travelling.adapters.HighWayListAdapter;
import com.padc.travelling.components.SpacesItemDecoration;
import com.padc.travelling.data.vos.BusComponiesVO;
import com.padc.travelling.data.agents.retrofit.RetrofitDataAgent;
import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.data.model.BusComponiesModel;
import com.padc.travelling.view.HighWayListViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by dellpc on 11-Sep-16.
 */
public class HighWayListFragment extends Fragment {

    @BindView(R.id.rv_highwaylist)
    RecyclerView rvHighWayList;

    @BindView(R.id.swipe_refresh_layout_highway)
    SwipeRefreshLayout swipeRefreshLayout;

    private List<BusComponiesVO> highwayCompanyVOList = new ArrayList<>();
    private HighWayListAdapter highWayListAdapter;
    private HighWayListViewHolder.ControllerHighWayList mControllerHighWayList;

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
                RetrofitDataAgent.getInstance().loadBusComponies();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
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

    public void onEventMainThread(DataEvent.BusComponiesDataLoadedEvent event) {
        //layout.setRefreshing(false);
        String extra = event.getExtraMessage();
//        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        Log.e("HighwayFragment", "finish loading");
        List<BusComponiesVO> newBusComponiesList = event.getBusComponiesVOsList();
        highWayListAdapter.setNewData(newBusComponiesList);
    }
}

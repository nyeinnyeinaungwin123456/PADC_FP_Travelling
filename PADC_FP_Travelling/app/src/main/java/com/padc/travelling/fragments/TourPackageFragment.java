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
import com.padc.travelling.adapters.TourPackageAdapter;
import com.padc.travelling.data.vos.tourpackageVOs.TourPackage;
import com.padc.travelling.data.vos.agents.retrofit.RetrofitDataAgent;
import com.padc.travelling.data.vos.events.DataEvent;
import com.padc.travelling.data.vos.model.TourPackageModel;
import com.padc.travelling.data.vos.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.tourpackageVOs.TourPackage;
import com.padc.travelling.utils.TravellingConstants;
import com.padc.travelling.view.TourPackageViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

//import org.greenrobot.eventbus.EventBus;

//import com.padc.travelling.view.holders.TourPackageViewHolder;

/**
 * Created by Nyein Nyein on 9/11/2016.
 */
public class TourPackageFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    @BindView(R.id.recycler_tourpackage)
    RecyclerView recyclerTourPackage;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private TourPackageAdapter tourpackageAdapter;
    private TourPackageViewHolder.ControllerTourPackage mControllerTourPackage;

    private BroadcastReceiver mDataLoadedBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //TODO instructions when the new data is ready.
            String extra = intent.getStringExtra("key-for-extra");
            Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

            List<TourPackage> newTourpackageList = TourPackageModel.getInstance().getTourPackageList();
            tourpackageAdapter.setNewData(newTourpackageList);
        }
    };

    //static factory method
    public static TourPackageFragment newInstance(){
        TourPackageFragment fragment =  new TourPackageFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerTourPackage = (TourPackageViewHolder.ControllerTourPackage) context;
    }

    public TourPackageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tourpackage, container, false);
        ButterKnife.bind(this,view);

        List<TourPackage> tourpackageList = TourPackageModel.getInstance().getTourPackageList();
        tourpackageAdapter = new TourPackageAdapter(tourpackageList, mControllerTourPackage);

        recyclerTourPackage.setAdapter(tourpackageAdapter);
        recyclerTourPackage.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                RetrofitDataAgent.getInstance().loadTourPackage();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getSupportLoaderManager().initLoader(TravellingConstants.TOURPACKAGE_LIST_LOADER, null, this);
    }

    @Override
    public void onStart() {
        super.onStart();

        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mDataLoadedBroadcastReceiver,
                new IntentFilter(TourPackageModel.BROADCAST_DATA_LOADED));

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


    public void onEventMainThread(DataEvent.TourPackageDataLoadedEvent event) {
        swipeRefreshLayout.setRefreshing(false);
        String extra = event.getExtraMessage();
//        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        Log.e("TOURPACKAGEFRAGMENT", "finish loading");
        List<TourPackage> newTourPackageList = event.getTourPackageList();
        tourpackageAdapter.setNewData(newTourPackageList);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                TravelMyanmarContract.TourpackageEntry.CONTENT_URI,
                null,
                null,
                null,
                TravelMyanmarContract.TourpackageEntry.COLUMN_NAME + " ASC");
    }


    //TODO START
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        List<TourPackage> tourpackageList = new ArrayList<>();
        if (data != null && data.moveToFirst()) {
            do {
                TourPackage tourpackage = TourPackage.parseFromCursor(data);
                tourpackage.setPhotos(TourPackage.loadTourPackagePhotobyName(tourpackage.getPackageName()));
                tourpackageList.add(tourpackage);
            } while (data.moveToNext());
        }

        Log.d(TravellingApp.TAG, "Retrieved attractions ASC - GridView : " + tourpackageList.size());
        tourpackageAdapter.setNewData(tourpackageList);

        TourPackageModel.getInstance().setStoredData(tourpackageList);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

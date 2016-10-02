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
import com.padc.travelling.adapters.AttractionPlacesAdapter;
import com.padc.travelling.data.agents.retrofit.RetrofitDataAgent;
import com.padc.travelling.data.vos.attractionplaces.AttractionPlaces;
import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.data.model.AttractionsModel;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.utils.TravellingConstants;
import com.padc.travelling.view.AttractionPlacesViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

//import com.padc.travelling.data.vos.AttractionPlacesVO;

/**
 * A placeholder fragment containing a simple view.
 */
public class AttractionPlacesFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    @BindView(R.id.recycler_attraction)
    RecyclerView recyclerAttraction;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout refreshAttraction;

//    private List<AttractionPlaces> attractionPlacesVOList = new ArrayList<>();
//    private RecyclerView recyclerView;
    private AttractionPlacesAdapter attractionPlacesAdapter;
    private AttractionPlacesViewHolder.ControllerAttractionPlaces mControllerAttracionPlaces;

    public static final String IE_ATTRACTIONLIST = "attractionlist";

    private BroadcastReceiver mDataLoadedBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //TODO instructions when the new data is ready.
            String extra = intent.getStringExtra("key-for-extra");
            Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

            List<AttractionPlaces> newAttractionList = AttractionsModel.getInstance().getAttractionPLacesList();
            attractionPlacesAdapter.setNewData(newAttractionList);
        }
    };

    //static factory method
    public static AttractionPlacesFragment newInstance(){
        AttractionPlacesFragment fragment =  new AttractionPlacesFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerAttracionPlaces = (AttractionPlacesViewHolder.ControllerAttractionPlaces)context;
    }

    public AttractionPlacesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attractionplaces, container, false);
        ButterKnife.bind(this,view);

        List<AttractionPlaces> attractionplacesList = AttractionsModel.getInstance().getAttractionPLacesList();
        attractionPlacesAdapter = new AttractionPlacesAdapter(attractionplacesList, mControllerAttracionPlaces);

        recyclerAttraction.setAdapter(attractionPlacesAdapter);
        recyclerAttraction.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        refreshAttraction.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                RetrofitDataAgent.getInstance().loadAttraction();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getSupportLoaderManager().initLoader(TravellingConstants.ATTRACTION_LIST_LOADER, null, this);
    }

    @Override
    public void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mDataLoadedBroadcastReceiver,
                new IntentFilter(AttractionsModel.BROADCAST_DATA_LOADED));

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


    public void onEventMainThread(DataEvent.AttractionPlacesDataLoadedEvent event) {
        refreshAttraction.setRefreshing(false);
        String extra = event.getExtraMessage();
//        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        Log.e("TOURPACKAGEFRAGMENT", "finish loading");
        List<AttractionPlaces> newAttractionPlacesList = event.getAttractionPlacesList();
        attractionPlacesAdapter.setNewData(newAttractionPlacesList);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                TravelMyanmarContract.AttractionEntry.CONTENT_URI,
                null,
                null,
                null,
                TravelMyanmarContract.AttractionEntry.COLUMN_TITLE + " ASC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        List<AttractionPlaces> attractionList = new ArrayList<>();
        if (data != null && data.moveToFirst()) {
            do {
                AttractionPlaces attraction = AttractionPlaces.parseFromCursor(data);
                attraction.setPlaceImage(AttractionPlaces.loadAttractionImagesByTitle(attraction.getPlaceTitle()));
                attractionList.add(attraction);
            } while (data.moveToNext());
        }

        Log.d(TravellingApp.TAG, "Retrieved attractions ASC - GridView : " + attractionList.size());
        attractionPlacesAdapter.setNewData(attractionList);

        AttractionsModel.getInstance().setStoredData(attractionList);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

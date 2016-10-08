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
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.RestaurantAdapter;
import com.padc.travelling.data.agents.retrofit.RetrofitDataAgent;
import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.data.model.RestaurantsModel;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.RestaurantsVO;
import com.padc.travelling.utils.NetworkUtils;
import com.padc.travelling.utils.TravellingConstants;
import com.padc.travelling.view.RestaurnatViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by Nyein Nyein on 9/16/2016.
 */
public class RestaurantFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    @BindView(R.id.rv_restaurant)
    RecyclerView recyclerView;

    @BindView(R.id.swipe_refresh_layout_restaurant)
    SwipeRefreshLayout refreshRestaurant;

    private List<RestaurantsVO> restaurantVOList = new ArrayList<>();
    private RestaurantAdapter restaurantAdapter;
    private RestaurnatViewHolder.ControllerRestaurant mControllerRestaurant;

    private BroadcastReceiver mDataLoadedBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //TODO instructions when the new data is ready.
            String extra = intent.getStringExtra("key-for-extra");
            Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

            List<RestaurantsVO> newRestaurantList = RestaurantsModel.getInstance().getRestaurantsVOList();
            restaurantAdapter.setNewData(newRestaurantList);
        }
    };

    //static factory method
    public static RestaurantFragment newInstance(){
        RestaurantFragment fragment =  new RestaurantFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerRestaurant = (RestaurnatViewHolder.ControllerRestaurant)context;
    }

    public RestaurantFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        ButterKnife.bind(this, view);

        //prepareRestaurantData();

        restaurantVOList = RestaurantsModel.getInstance().getRestaurantsVOList();

        restaurantAdapter = new RestaurantAdapter(restaurantVOList, mControllerRestaurant);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(restaurantAdapter);

        refreshRestaurant.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                if(NetworkUtils.isOnline(TravellingApp.getContext())) {
                    RetrofitDataAgent.getInstance().loadRestaurants();
                    refreshRestaurant.setRefreshing(false);
                }
                else {
                    refreshRestaurant.setRefreshing(false);
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getSupportLoaderManager().initLoader(TravellingConstants.RESTAURANT_LIST_LOADER, null, this);
    }

    @Override
    public void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mDataLoadedBroadcastReceiver,
                new IntentFilter(RestaurantsModel.BROADCAST_DATA_LOADED));


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

    public void onEventMainThread(DataEvent.RestaurantsDataLoadedEvent event) {
        refreshRestaurant.setRefreshing(false);
        String extra = event.getExtraMessage();
//        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();
        refreshRestaurant.setRefreshing(false);
        Log.e("RestaurantFragment", "finish loading");
        List<RestaurantsVO> newRestaurantsList = event.getRestaurantsList();
        restaurantAdapter.setNewData(newRestaurantsList);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                TravelMyanmarContract.RestaurantEntry.CONTENT_URI,
                null,
                null,
                null,
                TravelMyanmarContract.RestaurantEntry.COLUMN_NAME + " ASC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        List<RestaurantsVO> restaurantList = new ArrayList<>();
        if (data != null && data.moveToFirst()) {
            do {
                RestaurantsVO restaurant = RestaurantsVO.parseFromCursor(data);
                restaurant.setPhotos(RestaurantsVO.loadRestaurantPhotobyName(restaurant.getName()));
                restaurantList.add(restaurant);
            } while (data.moveToNext());
        }

        Log.d(TravellingApp.TAG, "Retrieved attractions ASC - GridView : " + restaurantList.size());
        restaurantAdapter.setNewData(restaurantList);

        RestaurantsModel.getInstance().setStoredData(restaurantList);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

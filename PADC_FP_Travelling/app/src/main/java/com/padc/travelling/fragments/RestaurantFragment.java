package com.padc.travelling.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.adapters.RestaurantAdapter;
import com.padc.travelling.data.vos.RestaurantsVO;
import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.data.model.RestaurantsModel;
import com.padc.travelling.view.RestaurnatViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by Nyein Nyein on 9/16/2016.
 */
public class RestaurantFragment extends Fragment {

    @BindView(R.id.rv_restaurant)
    RecyclerView recyclerView;

    private List<RestaurantsVO> restaurantVOList = new ArrayList<>();
    private RestaurantAdapter restaurantAdapter;
    private RestaurnatViewHolder.ControllerRestaurant mControllerRestaurant;

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

        return view;
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

    public void onEventMainThread(DataEvent.RestaurantsDataLoadedEvent event) {
        String extra = event.getExtraMessage();
//        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        Log.e("RestaurantFragment", "finish loading");
        List<RestaurantsVO> newRestaurantsList = event.getRestaurantsList();
        restaurantAdapter.setNewData(newRestaurantsList);
    }

    public void prepareRestaurantData(){


    }
}

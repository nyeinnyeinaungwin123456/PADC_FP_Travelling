package com.padc.travelling.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.adapters.RestaurantAdapter;
import com.padc.travelling.data.vos.RestaurantVO;
import com.padc.travelling.view.RestaurnatViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nyein Nyein on 9/16/2016.
 */
public class RestaurantFragment extends Fragment {

    private List<RestaurantVO> restaurantVOList = new ArrayList<>();
    private RecyclerView recyclerView;
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

        prepareRestaurantData();

        recyclerView = (RecyclerView)view.findViewById(R.id.rv_restaurant);
        restaurantAdapter = new RestaurantAdapter(restaurantVOList, mControllerRestaurant);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(restaurantAdapter);

        return view;
    }

    public void prepareRestaurantData(){

        RestaurantVO restaurantVO;

        for(int i=0; i<20; i++) {
            restaurantVO = new RestaurantVO(R.drawable.heartstream,"YKKO",R.drawable.ic_more_vert_black_24dp);
            restaurantVOList.add(restaurantVO);
        }
    }
}

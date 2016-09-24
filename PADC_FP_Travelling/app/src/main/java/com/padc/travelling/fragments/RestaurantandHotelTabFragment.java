package com.padc.travelling.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.adapters.RestaurantandHotelPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/15/2016.
 */
public class RestaurantandHotelTabFragment extends Fragment {

    @BindView(R.id.tl_restaurant)
    TabLayout tlRestaurnat;

    @BindView(R.id.pager_restaurant)
    ViewPager pagerRestaurant;

    RestaurantandHotelPagerAdapter restaurantandHotelPagerAdapter;

    public static RestaurantandHotelTabFragment newInstance(){
        RestaurantandHotelTabFragment restaurantandHotelTabFragment = new RestaurantandHotelTabFragment();
        return restaurantandHotelTabFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restaurantandHotelPagerAdapter = new RestaurantandHotelPagerAdapter(getActivity().getSupportFragmentManager());
        restaurantandHotelPagerAdapter.addTab(RestaurantFragment.newInstance(),getString(R.string.restaurant));
        restaurantandHotelPagerAdapter.addTab(HotelFragment.newInstance(),getString(R.string.hotel));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_restaurant_hotel, container, false);
        ButterKnife.bind(this,view);

        pagerRestaurant.setAdapter(restaurantandHotelPagerAdapter);
        pagerRestaurant.setOffscreenPageLimit(restaurantandHotelPagerAdapter.getCount());
        tlRestaurnat.setupWithViewPager(pagerRestaurant);

        return view;
    }

}

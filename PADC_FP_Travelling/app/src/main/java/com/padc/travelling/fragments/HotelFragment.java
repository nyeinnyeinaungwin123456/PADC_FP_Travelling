package com.padc.travelling.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.adapters.HotelAdapter;
import com.padc.travelling.data.vos.HotelVO;
import com.padc.travelling.view.HotelViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HotelFragment extends Fragment {

    @BindView(R.id.rv_hotel)
    RecyclerView rvHotel;

    private List<HotelVO> hotelVOList = new ArrayList<>();
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

        prepareData();

        hotelAdapter = new HotelAdapter(hotelVOList, mControllerHotel);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvHotel.setLayoutManager(layoutManager);
        rvHotel.setAdapter(hotelAdapter);

        return rootView;
    }

    private void prepareData() {

        HotelVO hotelVO;

        for(int i=0; i<8; i++) {
            hotelVO = new HotelVO("Sedona Hotel Yangon",R.drawable.sedona_hotel_mandalay,"Kabar Aye Pagoda Rd, Yangon","01 860 5377");
            hotelVOList.add(hotelVO);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerHotel = (HotelViewHolder.ControllerHotel) context;
    }
}

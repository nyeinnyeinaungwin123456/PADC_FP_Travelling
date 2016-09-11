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
import com.padc.travelling.adapters.TourPackageAdapter;
import com.padc.travelling.data.vos.TourPackageVO;
import com.padc.travelling.view.holders.TourPackageViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nyein Nyein on 9/11/2016.
 */
public class TourPackageFragment extends Fragment {

    private List<TourPackageVO> tourpackageVOList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TourPackageAdapter tourpackageAdapter;
    private TourPackageViewHolder.ControllerTourPackage mControllerTourPackage;

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

        prepareTourPackageData();

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_tourpackage);
        tourpackageAdapter = new TourPackageAdapter(tourpackageVOList, mControllerTourPackage);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tourpackageAdapter);

        return view;
    }

    public void prepareTourPackageData(){

        TourPackageVO tourPackageVO;

        for(int i=0; i<20; i++) {
            tourPackageVO = new TourPackageVO(R.drawable.yangon_shwedagonpagoda, "ေရႊတိဂံု");
            tourpackageVOList.add(tourPackageVO);
        }
    }
}

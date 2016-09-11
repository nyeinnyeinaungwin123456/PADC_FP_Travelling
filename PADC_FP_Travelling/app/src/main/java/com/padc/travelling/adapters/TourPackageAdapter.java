package com.padc.travelling.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.TourPackageVO;
import com.padc.travelling.view.holders.TourPackageViewHolder;

import java.util.List;

/**
 * Created by Nyein Nyein on 9/11/2016.
 */
public class TourPackageAdapter extends RecyclerView.Adapter<TourPackageViewHolder> {

    private LayoutInflater mInflater;
    private List<TourPackageVO> mTourPackageVOList;
    private TourPackageViewHolder.ControllerTourPackage mControllerTourPackage;

    public TourPackageAdapter(List<TourPackageVO> tourPackageVOList, TourPackageViewHolder.ControllerTourPackage controllerTourPackage) {

        mInflater = LayoutInflater.from(TravellingApp.getContext());
        mTourPackageVOList = tourPackageVOList;
        mControllerTourPackage = controllerTourPackage;
    }

    @Override
    public TourPackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item_tourpackage, parent, false);

        return new TourPackageViewHolder(view, mControllerTourPackage);

    }

    @Override
    public void onBindViewHolder(TourPackageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mTourPackageVOList.size();
    }


}

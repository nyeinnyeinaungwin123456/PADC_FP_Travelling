package com.padc.travelling.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.data.vos.TourPackageVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/11/2016.
 */
public class TourPackageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_tourpackage)
    ImageView ivTourPackage;

    @BindView(R.id.tv_tourpackagetitle)
    TextView tvTourPackageTitle;

        TourPackageVO mTourPackageVO;
        ControllerTourPackage mControllerTourPackage;

    public TourPackageViewHolder(View itemView, ControllerTourPackage controllerTourPackage) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
        mControllerTourPackage = controllerTourPackage;
        }

public void bindData(TourPackageVO tourPackageVO){
    mTourPackageVO = tourPackageVO;

    ivTourPackage.setImageResource(tourPackageVO.getTourpackagephoto());
    tvTourPackageTitle.setText(tourPackageVO.getTourpackagetitle());

        }

@Override
public void onClick(View view) {
    mControllerTourPackage.onTapTourpackage(mTourPackageVO, getPosition());
        }

public interface ControllerTourPackage{
    void onTapTourpackage(TourPackageVO tourPackageVO, int position);
}
}

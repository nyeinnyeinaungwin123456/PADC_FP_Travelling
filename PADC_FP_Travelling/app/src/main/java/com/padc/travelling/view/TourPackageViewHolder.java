package com.padc.travelling.view;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.travelling.R;
import com.padc.travelling.data.vos.tourpackageVOs.TourPackage;

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

    @BindView(R.id.cardview_tourpackage)
    CardView cvTourPackage;

        TourPackage mTourPackage;
        ControllerTourPackage mControllerTourPackage;

    public TourPackageViewHolder(View itemView, ControllerTourPackage controllerTourPackage) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        cvTourPackage.setCardBackgroundColor(Color.TRANSPARENT);

        itemView.setOnClickListener(this);
        mControllerTourPackage = controllerTourPackage;
        }

public void bindData(TourPackage tourPackage){
    mTourPackage = tourPackage;

    tvTourPackageTitle.setText(tourPackage.getPackageName());

    String imageUrl = tourPackage.getPhotos()[0];
    Log.d("Tourpackage Img", " "+imageUrl);

    Glide.with(ivTourPackage.getContext())
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(ivTourPackage);

        }

@Override
public void onClick(View view) {
    mControllerTourPackage.onTapTourpackage(mTourPackage,ivTourPackage);
        }

public interface ControllerTourPackage{
    void onTapTourpackage(TourPackage tourPackage, ImageView ivTourPackage);
}
}

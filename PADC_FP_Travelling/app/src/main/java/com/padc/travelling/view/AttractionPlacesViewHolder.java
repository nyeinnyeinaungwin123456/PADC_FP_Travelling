package com.padc.travelling.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.travelling.R;
import com.padc.travelling.data.vos.attractionplaces.AttractionPlaces;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/7/2016.
 */
public class AttractionPlacesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_attraction)
    ImageView ivAttraction;

    @BindView(R.id.tv_attractiontitle)
    TextView tvAttractionTitle;

    @BindView(R.id.tv_attractiondesc)
    TextView tvAttractionDesc;

    AttractionPlaces mAttractionPlaces;
    ControllerAttractionPlaces mControllerAttractionPlaces;

    public AttractionPlacesViewHolder(View itemView, ControllerAttractionPlaces controllerAttractionPlaces) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
        mControllerAttractionPlaces = controllerAttractionPlaces;
    }


    public void bindData(AttractionPlaces attractionPlaces){
        mAttractionPlaces = attractionPlaces;
//        ivSubAttraction.setImageResource(attractionPlaces.getPlaceImage());
        tvAttractionTitle.setText(attractionPlaces.getPlaceTitle());
        tvAttractionDesc.setText(attractionPlaces.getPlaceDesc());

        String imageUrl = attractionPlaces.getPlaceImage()[0];
        Glide.with(ivAttraction.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivAttraction);


    }

    @Override
    public void onClick(View view) {
        mControllerAttractionPlaces.onTapAttractionPlaces(mAttractionPlaces, ivAttraction);
//        mControllerAttractionPlaces.onTapAttractionPlaces(mAttractionPlacesVO, mAttractionPlacesVO.getFavourite());
    }

    public interface ControllerAttractionPlaces{
        void onTapAttractionPlaces(AttractionPlaces attractionPlaces, ImageView ivAttraction);
//        void onTapFavouriteImage(AttractionPlacesVO attractionPlacesVO, int favourite);
    }
}

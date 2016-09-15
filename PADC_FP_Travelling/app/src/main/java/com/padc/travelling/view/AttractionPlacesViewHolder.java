package com.padc.travelling.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.data.vos.AttractionPlacesVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/7/2016.
 */
public class AttractionPlacesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_subattraction)
    ImageView ivSubAttraction;

    @BindView(R.id.tv_attractionsubtitle)
    TextView tvAttractionSubTitle;

    @BindView(R.id.tv_attractionsubdesc)
    TextView tvAttractionSubDesc;

    AttractionPlacesVO mAttractionPlacesVO;
    ControllerAttractionPlaces mControllerAttractionPlaces;

    public AttractionPlacesViewHolder(View itemView, ControllerAttractionPlaces controllerAttractionPlaces) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
        mControllerAttractionPlaces = controllerAttractionPlaces;
    }

    public void bindData(AttractionPlacesVO attractionPlacesVO){
        mAttractionPlacesVO = attractionPlacesVO;
        ivSubAttraction.setImageResource(attractionPlacesVO.getSubtitle1photo());
        tvAttractionSubTitle.setText(attractionPlacesVO.getSubtitle());
        tvAttractionSubDesc.setText(attractionPlacesVO.getSubtitle1desc());

    }

    @Override
    public void onClick(View view) {
        mControllerAttractionPlaces.onTapAttractionPlaces(mAttractionPlacesVO, getPosition());
//        mControllerAttractionPlaces.onTapAttractionPlaces(mAttractionPlacesVO, mAttractionPlacesVO.getFavourite());
    }

    public interface ControllerAttractionPlaces{
        void onTapAttractionPlaces(AttractionPlacesVO attractionPlacesVO, int position);
//        void onTapFavouriteImage(AttractionPlacesVO attractionPlacesVO, int favourite);
    }
}

package com.padc.travelling.view.holders;

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

   @BindView(R.id.iv_attractionplaces)
    ImageView ivAttractionPlaces;

    @BindView(R.id.tv_attractiontitle)
    TextView tvAttractionTitle;

    @BindView(R.id.tv_attractiondesc)
    TextView tvAttractionDesc;

    @BindView(R.id.iv_subattraction1)
    ImageView ivSubAttraction1;

    @BindView(R.id.tv_attractionsubtitle1)
    TextView tvAttractionSubTitle1;

    @BindView(R.id.tv_attractionsubdesc1)
    TextView tvAttractionSubDesc1;

    @BindView(R.id.iv_subattraction2)
    ImageView ivSubAttraction2;

    @BindView(R.id.tv_attractionsubtitle2)
    TextView tvAttractionSubTitle2;

    @BindView(R.id.tv_attractionsubdesc2)
    TextView tvAttractionSubDesc2;

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
        ivAttractionPlaces.setImageResource(attractionPlacesVO.getTitlephoto());
        ivSubAttraction1.setImageResource(attractionPlacesVO.getSubtitle1photo());
        ivSubAttraction2.setImageResource(attractionPlacesVO.getSubtitle2photo());

        tvAttractionTitle.setText(attractionPlacesVO.getTitle());
        tvAttractionSubTitle1.setText(attractionPlacesVO.getSubtitle1());
        tvAttractionSubTitle2.setText(attractionPlacesVO.getSubtitle2());

        tvAttractionDesc.setText(attractionPlacesVO.getTitledesc());
        tvAttractionSubDesc1.setText(attractionPlacesVO.getSubtitle1desc());
        tvAttractionSubDesc2.setText(attractionPlacesVO.getSubtitle2desc());

    }

    @Override
    public void onClick(View view) {
        mControllerAttractionPlaces.onTapAttractionPlaces(mAttractionPlacesVO, getPosition());
    }

    public interface ControllerAttractionPlaces{
        void onTapAttractionPlaces(AttractionPlacesVO attractionPlacesVO, int position);
    }
}

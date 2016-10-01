package com.padc.travelling.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.data.vos.RoutesVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TY on 9/16/2016.
 */
public class PathsViewHolder extends RecyclerView.ViewHolder  {

    @BindView(R.id.tv_source)
    TextView tvSoruce;

    @BindView(R.id.tv_destination)
    TextView tvDestination;

    @BindView(R.id.tv_depture_time)
    TextView tvDeptureTime;

    @BindView(R.id.tv_arrival_time)
    TextView tvArrivalTime;

    @BindView(R.id.tv_price)
    TextView tvPrice;

    RoutesVO mRoutesVO;

    public PathsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

    }

    public void bindData(RoutesVO routesVO){

        mRoutesVO = routesVO;

        tvSoruce.setText(mRoutesVO.getStartDestinationVO().getDestination_title());
        tvDestination.setText(mRoutesVO.getEndDestinationVO().getDestination_title());
        tvDeptureTime.setText(mRoutesVO.getStartDestinationVO().getTimeMakersVO().getDeparture_time());
        tvArrivalTime.setText(mRoutesVO.getEndDestinationVO().getTimeMakersVO().getArrival_time());
        tvPrice.setText(Integer.toString(mRoutesVO.getPrice()));

    }
}

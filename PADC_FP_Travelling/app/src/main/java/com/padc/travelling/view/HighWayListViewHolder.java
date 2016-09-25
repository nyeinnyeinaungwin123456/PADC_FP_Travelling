package com.padc.travelling.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.data.vos.HighwayCompanyVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dellpc on 11-Sep-16.
 */
public class HighWayListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_bus_company_photo)
    ImageView ivBusCompanyPhoto;

    /*@BindView(R.id.tv_bus_name)
    TextView tvBusName;
*/
    /*@BindView(R.id.tv_bus_company_address)
    TextView tvBusCompanyAddress;

    @BindView(R.id.tv_bus_company_phoneNo)
    TextView tvBusCompanyPhoneNo;*/

    HighwayCompanyVO mHighwayCompanyVO;
    ControllerHighWayList mControllerHighWayList;

    public HighWayListViewHolder(View itemView, ControllerHighWayList controllerHighWayList) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
        mControllerHighWayList = controllerHighWayList;
    }

    public void bindData(HighwayCompanyVO highwayCompanyVO){
        mHighwayCompanyVO = highwayCompanyVO;
        ivBusCompanyPhoto.setImageResource(mHighwayCompanyVO.getCompanyImage());
        //tvBusName.setText(mHighwayCompanyVO.getCompanyTitle());
        /*tvBusCompanyAddress.setText(mHighwayCompanyVO.getAddress());
        tvBusCompanyPhoneNo.setText(mHighwayCompanyVO.getPhoneNo());*/
    }

    @Override
    public void onClick(View view) {
        mControllerHighWayList.onTapHighWayList(mHighwayCompanyVO,getPosition());
    }

    public interface ControllerHighWayList{
        void onTapHighWayList(HighwayCompanyVO highwayCompanyVO, int position);
    }
}

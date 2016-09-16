package com.padc.travelling.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.data.vos.HotelVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TY on 9/14/2016.
 */
public class HotelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_hotel_image)
    ImageView ivHotelImage;

    @BindView(R.id.tv_hotel_name)
    TextView tvHotelName;

    @BindView(R.id.tv_hotel_address)
    TextView tvHotelAddress;

    @BindView(R.id.tv_hotel_phone)
    TextView tvHotelPhone;

    HotelVO mHotelVO;
    ControllerHotel mControllerHotel;



    public HotelViewHolder(View itemView,ControllerHotel controllerHotel) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(this);
        mControllerHotel = controllerHotel;
    }

    public void bindData(HotelVO hotelVO) {
        mHotelVO = hotelVO;
        tvHotelName.setText(mHotelVO.getTvHotelName());
        tvHotelAddress.setText(mHotelVO.getTvHotelAddress());
        tvHotelPhone.setText(mHotelVO.getTvHotelPhone());

        ivHotelImage.setImageResource(mHotelVO.getIvHotelImage());
    }

    @Override
    public void onClick(View v) {
        mControllerHotel.onTapHotel(mHotelVO,getPosition());
    }

    public interface ControllerHotel{
        void onTapHotel(HotelVO hotelVO, int position);
    }
}

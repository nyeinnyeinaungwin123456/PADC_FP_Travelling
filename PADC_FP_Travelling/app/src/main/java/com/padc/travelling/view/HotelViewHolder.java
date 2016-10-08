package com.padc.travelling.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.travelling.R;
import com.padc.travelling.data.vos.HotelsVO;

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

    HotelsVO mHotelVO;
    ControllerHotel mControllerHotel;



    public HotelViewHolder(View itemView,ControllerHotel controllerHotel) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(this);
        mControllerHotel = controllerHotel;
    }

    public void bindData(HotelsVO hotelVO) {
        mHotelVO = hotelVO;
        tvHotelName.setText(mHotelVO.getHotel_name());
//        tvHotelAddress.setText(mHotelVO.getLocationVO().getAddress());
//        tvHotelPhone.setText(mHotelVO.getPhoneNumbers()[0]);

        String imageUrl = mHotelVO.getPhotos()[0];
        Log.d("Img", " " + imageUrl);

        Glide.with(ivHotelImage.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivHotelImage);
    }

    @Override
    public void onClick(View v) {
        mControllerHotel.onTapHotel(mHotelVO,ivHotelImage);
    }

    public interface ControllerHotel{
        void onTapHotel(HotelsVO hotelVO, ImageView ivHotelImage);
    }
}

package com.padc.travelling.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.travelling.R;
import com.padc.travelling.data.vos.RestaurantVO;
import com.padc.travelling.data.vos.RestaurantsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/16/2016.
 */
public class RestaurnatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_restaturant)
    ImageView ivRestaurant;

    @BindView(R.id.tv_restaturantname)
    TextView tvRestaurantName;

    @BindView(R.id.iv_setting)
    ImageView ivSetting;

    RestaurantsVO mRestaurantVO;
    ControllerRestaurant mControllerRestaurant;

    public RestaurnatViewHolder(View itemView, ControllerRestaurant controllerRestaurant) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        ivSetting.setOnClickListener(this);

        itemView.setOnClickListener(this);
        mControllerRestaurant = controllerRestaurant;
    }

    public void bindData(RestaurantsVO restaurantVO){

        mRestaurantVO = restaurantVO;
        tvRestaurantName.setText(restaurantVO.getName());

        String imageUrl = mRestaurantVO.getPhotos()[0];
        Log.d("Img", " " + imageUrl);

        Glide.with(ivRestaurant.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivRestaurant);

        //ivSetting.setImageResource(restaurantVO.getRestaurantImgSetting());

    }

    @Override
    public void onClick(View view) {

        if(view instanceof ImageView){
            mControllerRestaurant.onTapSetting(ivSetting);

            }else {
            mControllerRestaurant.onTapRestaurnat(mRestaurantVO, getPosition());
        }
        }


    public interface ControllerRestaurant{
        void onTapRestaurnat(RestaurantsVO restaurantVO, int position);
        void onTapSetting(ImageView ivsetting);
    }
}

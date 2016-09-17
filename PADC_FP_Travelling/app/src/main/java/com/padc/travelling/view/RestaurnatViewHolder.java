package com.padc.travelling.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.data.vos.RestaurantVO;

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

    RestaurantVO mRestaurantVO;
    ControllerRestaurant mControllerRestaurant;

    public RestaurnatViewHolder(View itemView, ControllerRestaurant controllerRestaurant) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        ivSetting.setOnClickListener(this);

        itemView.setOnClickListener(this);
        mControllerRestaurant = controllerRestaurant;
    }

    public void bindData(RestaurantVO restaurantVO){

        mRestaurantVO = restaurantVO;
        ivRestaurant.setImageResource(restaurantVO.getRestaurantImage());
        tvRestaurantName.setText(restaurantVO.getRestaurantTile());
        ivSetting.setImageResource(restaurantVO.getRestaurantImgSetting());

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
        void onTapRestaurnat(RestaurantVO restaurantVO, int position);
        void onTapSetting(ImageView ivsetting);
    }
}

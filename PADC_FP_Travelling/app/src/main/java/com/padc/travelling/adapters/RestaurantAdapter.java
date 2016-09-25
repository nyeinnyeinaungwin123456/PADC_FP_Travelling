package com.padc.travelling.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.RestaurantVO;
import com.padc.travelling.data.vos.RestaurantsVO;
import com.padc.travelling.view.RestaurnatViewHolder;

import java.util.List;

/**
 * Created by Nyein Nyein on 9/16/2016.
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurnatViewHolder> {

    private LayoutInflater mInflater;
    private List<RestaurantsVO> mRestaurantVOList;
    private RestaurnatViewHolder.ControllerRestaurant mControllerRestaurant;

    public RestaurantAdapter(List<RestaurantsVO> mRestaurantVOList, RestaurnatViewHolder.ControllerRestaurant controllerRestaurant) {
        mInflater = LayoutInflater.from(TravellingApp.getContext());
        this.mRestaurantVOList = mRestaurantVOList;
        this.mControllerRestaurant = controllerRestaurant;
    }

    @Override
    public RestaurnatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item_restaurant, parent, false);
        CardView cardView = (CardView)view.findViewById(R.id.cardview_restaurant);
        cardView.setCardBackgroundColor(Color.TRANSPARENT);

//        RestaurnatViewHolder vh = new RestaurnatViewHolder(view, new RestaurnatViewHolder.ControllerRestaurant() {
//
//            @Override
//            public void onTapRestaurnat(RestaurantVO restaurantVO, int position) {
//                Log.d("RESTAURANT", "is at : "+position);
//            }
//
//            @Override
//            public void onTapSetting(ImageView ivsetting) {
//            Log.d("ImageSetting", "is : "+ivsetting);
//            }
//        });

        return new RestaurnatViewHolder(view, mControllerRestaurant);
    }

    public void setNewData(List<RestaurantsVO> restaurantsVOList){
        mRestaurantVOList.clear();
        mRestaurantVOList = restaurantsVOList;
        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RestaurnatViewHolder holder, int position) {
        holder.bindData(mRestaurantVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestaurantVOList.size();
    }
}

package com.padc.travelling.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.RestaurantsVO;
import com.padc.travelling.view.RestaurnatViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nyein Nyein on 9/16/2016.
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurnatViewHolder> {

    private LayoutInflater mInflater;
    private List<RestaurantsVO> mRestaurantVOList = new ArrayList<>();
    private RestaurnatViewHolder.ControllerRestaurant mControllerRestaurant;

    public RestaurantAdapter(List<RestaurantsVO> restaurantVOList, RestaurnatViewHolder.ControllerRestaurant controllerRestaurant) {
        mInflater = LayoutInflater.from(TravellingApp.getContext());
        mRestaurantVOList = new ArrayList<>();
        mControllerRestaurant = controllerRestaurant;
    }

    @Override
    public RestaurnatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item_restaurant, parent, false);
        CardView cardView = (CardView)view.findViewById(R.id.cardview_restaurant);
        cardView.setCardBackgroundColor(Color.TRANSPARENT);

//

        return new RestaurnatViewHolder(view, mControllerRestaurant);
    }

    public void setNewData(List<RestaurantsVO> restaurantsVOList){
        mRestaurantVOList.clear();
//        mRestaurantVOList = restaurantsVOList;
        mRestaurantVOList.addAll(restaurantsVOList);
        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RestaurnatViewHolder holder, int position) {
        holder.bindData(mRestaurantVOList.get(position));
    }

    @Override
    public int getItemCount() {

        if (mRestaurantVOList == null) {
            return 0;
        }
        return mRestaurantVOList.size();
    }
}

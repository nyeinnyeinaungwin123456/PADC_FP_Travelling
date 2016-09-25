package com.padc.travelling.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.HotelVO;
import com.padc.travelling.data.vos.HotelsVO;
import com.padc.travelling.view.HotelViewHolder;

import java.util.List;

/**
 * Created by TY on 9/14/2016.
 */
public class HotelAdapter extends RecyclerView.Adapter<HotelViewHolder> {

    private LayoutInflater mInflater;
    private List<HotelsVO> mHotelVOList;
    private HotelViewHolder.ControllerHotel mControllerHotel;

    public HotelAdapter(List<HotelsVO> mHotelVOList, HotelViewHolder.ControllerHotel mControllerHotel) {
        this.mInflater = LayoutInflater.from(TravellingApp.getContext());
        this.mHotelVOList = mHotelVOList;
        this.mControllerHotel = mControllerHotel;
    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_hotel, parent, false);

        return new HotelViewHolder(view, mControllerHotel);
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {
        holder.bindData(mHotelVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return mHotelVOList.size();
    }

    public void setNewData(List<HotelsVO> hotelsVOList){
        mHotelVOList.clear();
        mHotelVOList = hotelsVOList;
        notifyDataSetChanged();

    }

}

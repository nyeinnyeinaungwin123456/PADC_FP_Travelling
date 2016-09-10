package com.padc.travelling.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.AttractionPlacesVO;
import com.padc.travelling.view.AttractionPlacesViewHolder;

import java.util.List;

/**
 * Created by Nyein Nyein on 9/7/2016.
 */
public class AttractionPlacesAdapter extends RecyclerView.Adapter<AttractionPlacesViewHolder> {

    private LayoutInflater mInflater;
    private List<AttractionPlacesVO> mAttractionPlacesVOList;
    private AttractionPlacesViewHolder.ControllerAttractionPlaces mControllerAttractionPlaces;

    public AttractionPlacesAdapter(List<AttractionPlacesVO> attractionPlacesVOList, AttractionPlacesViewHolder.ControllerAttractionPlaces controllerAttractionPlaces) {

        mInflater = LayoutInflater.from(TravellingApp.getContext());
        mAttractionPlacesVOList = attractionPlacesVOList;
        mControllerAttractionPlaces = controllerAttractionPlaces;
    }

    @Override
    public AttractionPlacesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item_attractionplaces, parent, false);
        CardView cardView = (CardView)view.findViewById(R.id.cardview);
        cardView.setCardBackgroundColor(Color.TRANSPARENT);

        return new AttractionPlacesViewHolder(view, mControllerAttractionPlaces);

    }

    @Override
    public void onBindViewHolder(AttractionPlacesViewHolder holder, int position) {

    holder.bindData(mAttractionPlacesVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return mAttractionPlacesVOList.size();
    }

    public void setNewData(List<AttractionPlacesVO> attractionPlacesVOList){
        mAttractionPlacesVOList = attractionPlacesVOList;
        notifyDataSetChanged();

    }
}

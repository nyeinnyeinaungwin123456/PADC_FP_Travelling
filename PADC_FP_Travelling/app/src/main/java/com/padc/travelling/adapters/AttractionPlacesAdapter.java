package com.padc.travelling.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
//import com.padc.travelling.data.vos.AttractionPlacesVO;
import com.padc.travelling.data.vos.attractionplaces.AttractionPlaces;
import com.padc.travelling.view.AttractionPlacesViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nyein Nyein on 9/7/2016.
 */
public class AttractionPlacesAdapter extends RecyclerView.Adapter<AttractionPlacesViewHolder> {

    private LayoutInflater mInflater;
    private List<AttractionPlaces> mAttractionPlacesVOList = new ArrayList<>();
    private AttractionPlacesViewHolder.ControllerAttractionPlaces mControllerAttractionPlaces;
//    View view;

    public AttractionPlacesAdapter(List<AttractionPlaces> attractionPlacesVOList, AttractionPlacesViewHolder.ControllerAttractionPlaces controllerAttractionPlaces) {

        mInflater = LayoutInflater.from(TravellingApp.getContext());
        mAttractionPlacesVOList = new ArrayList<>();
        mControllerAttractionPlaces = controllerAttractionPlaces;
    }

    @Override
    public AttractionPlacesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item_attractionplaces, parent, false);
//        CardView cardView = (CardView)view.findViewById(R.id.cardview);
//        cardView.setCardBackgroundColor(Color.TRANSPARENT);

        return new AttractionPlacesViewHolder(view, mControllerAttractionPlaces);

    }

    @Override
    public void onBindViewHolder(AttractionPlacesViewHolder holder, int position) {

//        if(position == mAttractionPlacesVOList.size()-1){
//            view.setPadding(80,80,80,80);
//        }

    holder.bindData(mAttractionPlacesVOList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mAttractionPlacesVOList == null) {
            return 0;
        }

        return mAttractionPlacesVOList.size();
    }

    public void setNewData(List<AttractionPlaces> attractionPlacesVOList){
        mAttractionPlacesVOList.clear();
        mAttractionPlacesVOList.addAll(attractionPlacesVOList);
//        mAttractionPlacesVOList = attractionPlacesVOList;
        notifyDataSetChanged();

    }
}

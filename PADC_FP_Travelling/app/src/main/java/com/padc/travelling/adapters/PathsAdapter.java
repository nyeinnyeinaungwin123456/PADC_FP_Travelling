package com.padc.travelling.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.RoutesVO;
import com.padc.travelling.view.PathsViewHolder;

import java.util.List;

/**
 * Created by TY on 9/16/2016.
 */
public class PathsAdapter extends RecyclerView.Adapter<PathsViewHolder> {

    private LayoutInflater mInflater;
    private List<RoutesVO> mRoutesVOList;

    public PathsAdapter(List<RoutesVO> mRoutesVOList) {
        this.mInflater = LayoutInflater.from(TravellingApp.getContext());
        this.mRoutesVOList = mRoutesVOList;
    }

    @Override
    public PathsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_paths, parent, false);

        return new PathsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PathsViewHolder holder, int position) {
        holder.bindData(mRoutesVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return mRoutesVOList.size();
    }

    public void setNewData(List<RoutesVO> routeVOList){
        mRoutesVOList.clear();
        mRoutesVOList.addAll(routeVOList);
//        mAttractionPlacesVOList = attractionPlacesVOList;
        notifyDataSetChanged();

    }
}

package com.padc.travelling.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.PathsVO;
import com.padc.travelling.view.PathsViewHolder;

import java.util.List;

/**
 * Created by TY on 9/16/2016.
 */
public class PathsAdapter extends RecyclerView.Adapter<PathsViewHolder> {

    private LayoutInflater mInflater;
    private List<PathsVO> mPathsVOList;

    public PathsAdapter(List<PathsVO> mPathsVOList) {
        this.mInflater = LayoutInflater.from(TravellingApp.getContext());
        this.mPathsVOList = mPathsVOList;
    }

    @Override
    public PathsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_paths, parent, false);

        return new PathsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PathsViewHolder holder, int position) {
        holder.bindData(mPathsVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPathsVOList.size();
    }
}

package com.padc.travelling.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.BusComponiesVO;
import com.padc.travelling.data.vos.HighwayCompanyVO;
import com.padc.travelling.view.HighWayListViewHolder;

import java.util.List;

/**
 * Created by dellpc on 11-Sep-16.
 */
public class HighWayListAdapter extends RecyclerView.Adapter<HighWayListViewHolder> {


    private LayoutInflater mInflater;
    private List<BusComponiesVO> mHighwayCompanyVOList;
    private HighWayListViewHolder.ControllerHighWayList mControllerHighWayList;

    public HighWayListAdapter(List<BusComponiesVO> highwayCompanyVOList, HighWayListViewHolder.ControllerHighWayList controllerHighWayList) {

        mInflater = LayoutInflater.from(TravellingApp.getContext());
        mHighwayCompanyVOList = highwayCompanyVOList;
        mControllerHighWayList = controllerHighWayList;
    }

    @Override
    public HighWayListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_high_way, parent, false);

        return new HighWayListViewHolder(view, mControllerHighWayList);
    }

    @Override
    public void onBindViewHolder(HighWayListViewHolder holder, int position) {
        holder.bindData(mHighwayCompanyVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return mHighwayCompanyVOList.size();
    }

    public void setNewData(List<BusComponiesVO> busComponiesVOList){
        mHighwayCompanyVOList.clear();
        mHighwayCompanyVOList = busComponiesVOList;
        notifyDataSetChanged();

    }
}

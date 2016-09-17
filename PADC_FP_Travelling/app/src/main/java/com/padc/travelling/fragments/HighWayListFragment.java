package com.padc.travelling.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.HighWayListAdapter;
import com.padc.travelling.components.SpacesItemDecoration;
import com.padc.travelling.data.vos.HighwayCompanyVO;
import com.padc.travelling.view.HighWayListViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dellpc on 11-Sep-16.
 */
public class HighWayListFragment extends Fragment {

    @BindView(R.id.rv_highwaylist)
    RecyclerView rvHighWayList;

    private List<HighwayCompanyVO> highwayCompanyVOList = new ArrayList<>();
    private HighWayListAdapter highWayListAdapter;
    private HighWayListViewHolder.ControllerHighWayList mControllerHighWayList;

    public static HighWayListFragment newInstance() {
        HighWayListFragment fragment = new HighWayListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_high_way_list, container, false);
        ButterKnife.bind(this, rootView);

        prepareData();

        highWayListAdapter = new HighWayListAdapter(highwayCompanyVOList, mControllerHighWayList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        rvHighWayList.setLayoutManager(layoutManager);
        rvHighWayList.setAdapter(highWayListAdapter);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        rvHighWayList.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

        return rootView;
    }

    private void prepareData() {
        HighwayCompanyVO highwayCompanyVO;

        for(int i=0; i<8; i++) {
            highwayCompanyVO = new HighwayCompanyVO("ELite","Yangon","09123456",R.drawable.express);
            highwayCompanyVOList.add(highwayCompanyVO);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerHighWayList = (HighWayListViewHolder.ControllerHighWayList) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}

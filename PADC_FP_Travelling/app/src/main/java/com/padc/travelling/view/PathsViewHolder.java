package com.padc.travelling.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.data.vos.PathsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TY on 9/16/2016.
 */
public class PathsViewHolder extends RecyclerView.ViewHolder  {

    @BindView(R.id.tv_paths)
    TextView tvPaths;

    PathsVO mPathsVO;

    public PathsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bindData(PathsVO pathsVO){
        mPathsVO = pathsVO;
        tvPaths.setText(mPathsVO.getTvPahtsDescription());
    }
}

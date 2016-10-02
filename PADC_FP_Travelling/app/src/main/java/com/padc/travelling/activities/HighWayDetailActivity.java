package com.padc.travelling.activities;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.PathsAdapter;
import com.padc.travelling.data.vos.BusComponiesVO;
import com.padc.travelling.data.vos.HighwayCompanyVO;
import com.padc.travelling.data.vos.RoutesVO;
import com.padc.travelling.data.vos.TicketingOutletsVO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HighWayDetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_highway_image_detail)
    ImageView ivHighwayImageDetail;

    @BindView(R.id.tv_highway_name)
    TextView tvHighwayName;

    @BindView(R.id.tv_highway_address)
    TextView tvHighwayAddress;

    @BindView(R.id.tv_hotel_detail_phone)
    TextView tvHotelDetailPhone;



    @BindView(R.id.rv_paths)
    RecyclerView rvPaths;

    @BindView(R.id.toolbar_highway)
    Toolbar toolbar;

    private static BusComponiesVO mBusComponiesVO;
    private ShareActionProvider mShareActionProvider;

    private List<RoutesVO> routesVOList = new ArrayList<>();
    private PathsAdapter pathsAdapter;

    public static Intent newIntent(BusComponiesVO busComponiesVO) {
        mBusComponiesVO = busComponiesVO;
        Intent intent = new Intent(TravellingApp.getContext(), HighWayDetailActivity.class);
        return intent;
    }

    public void bindData(){
        String imageUrl = mBusComponiesVO.getPhotos()[0];
        Log.d("Img", " " + imageUrl);

        Glide.with(ivHighwayImageDetail.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivHighwayImageDetail);

        tvHighwayName.setText(mBusComponiesVO.getName());
        tvHotelDetailPhone.setText(mBusComponiesVO.getTicketingOutletsVOs()[0].getPhone_numbers()[0].toString());

        //routesVOList =  mBusComponiesVO.getRoutesVOs();

        RoutesVO[] data = mBusComponiesVO.getRoutesVOs();
        for(int i=0;i<data.length;i++){
            routesVOList.add(data[i]);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_way_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        bindData();

        pathsAdapter = new PathsAdapter(routesVOList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TravellingApp.getContext());
        rvPaths.setLayoutManager(layoutManager);
        rvPaths.setAdapter(pathsAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_highway_fav);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
*/
                Toast.makeText(TravellingApp.getContext(),"Add to favourite list",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_attraction_detail, menu);

        MenuItem shareItem = menu.findItem(R.id.action_share);

        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(createShareIntent());
        }

        return true;
    }

    private static Intent createShareIntent(){
        Intent myShareIntent = new Intent(Intent.ACTION_SEND);
        myShareIntent.setType("text*//*");
        myShareIntent.putExtra(Intent.EXTRA_TEXT, "Hello Share Action Provider!");
        return myShareIntent;
    }

    //back button action
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

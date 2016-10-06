package com.padc.travelling.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
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
import com.padc.travelling.data.model.BusComponiesModel;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.BusComponiesVO;
import com.padc.travelling.data.vos.RoutesVO;
import com.padc.travelling.utils.TravellingConstants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HighWayDetailActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

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

    @BindView(R.id.tv_available_paths)
    TextView tvAvailablePath;

    @BindView(R.id.collapsing_toolbar_highway)
    CollapsingToolbarLayout mCollapsing;

    private ShareActionProvider mShareActionProvider;
    private String mHighwayTitle;
    private BusComponiesVO mBusCompany;

    private List<RoutesVO> routesVOList = new ArrayList<>();
    private PathsAdapter pathsAdapter;

    private static BusComponiesModel busComponiesModel;
    private  static final String IE_HIGHWAYBUS_TITLE = "bustitle";

    public static Intent newIntent(String bustitle) {
        Intent intent = new Intent(TravellingApp.getContext(), HighWayDetailActivity.class);
        intent.putExtra(IE_HIGHWAYBUS_TITLE, bustitle);
        return intent;
    }

//<<<<<<< 68f48b21a7de47676c57ccec9aa9ecf15faa032f
//    public void bindData(){
//        String imageUrl = mBusComponiesVO.getPhotos()[0];
//=======
    public void bindData(BusComponiesVO buscompanyVO){

        String imageUrl = buscompanyVO.getPhotos()[0];

        Log.d("Img", " " + imageUrl);

        Glide.with(ivHighwayImageDetail.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivHighwayImageDetail);

        tvHighwayName.setText(buscompanyVO.getName());
//        tvHotelDetailPhone.setText(buscompanyVO.getTicketingOutletsVOs()[0].getPhone_numbers()[0].toString());

//        routesVOList =  mBusComponiesVO.getRoutesVOs();

//        Intent intent = getIntent();
//        RoutesVO route = (RoutesVO) intent.getSerializableExtra("routeVO");
//        List<BusComponiesVO> buscompanyList = BusComponiesModel.getInstance().getBusComponiesVOList();

//        BusComponiesModel.getInstance().notifyBusComponiesLoaded(busComponiesModel.notifyBusComponiesLoadedForDetail(buscompanyList));
//
//        PathsAdapter pathsAdapter = new PathsAdapter(BusComponiesModel.getInstance().getRoutesVOList());
//        List<RoutesVO> routeList = BusComponiesModel.getInstance().getRoutesVOList();
//        pathsAdapter.setNewData(routeList);
//
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
//        rvPaths.setLayoutManager(layoutManager);
//        rvPaths.setAdapter(pathsAdapter);

//        RoutesVO[] data = buscompanyVO.getRoutesVOs();
//        for(int i=0;i<data.length;i++){
//            routesVOList.add(data[i]);
//        }
//
//        PathsAdapter pathsAdapter = new PathsAdapter(routesVOList);
//        pathsAdapter.setNewData(routesVOList);
//
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
//        rvPaths.setLayoutManager(layoutManager);
//        rvPaths.setAdapter(pathsAdapter);

        mCollapsing.setTitle(mHighwayTitle);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_way_detail);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mHighwayTitle = getIntent().getStringExtra(IE_HIGHWAYBUS_TITLE);
        getSupportLoaderManager().initLoader(TravellingConstants.BUSCOMPANY_DETAIL_LOADER, null, this);

//        bindData();

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
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,
                TravelMyanmarContract.HighwayBusEntry.buildHighwayUriWithName(mHighwayTitle),
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            mBusCompany = BusComponiesVO.parseFromCursor(data);
            mBusCompany.setPhotos(BusComponiesVO.loadBusCompanyPhotosByName(mBusCompany.getName()));

            bindData(mBusCompany);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

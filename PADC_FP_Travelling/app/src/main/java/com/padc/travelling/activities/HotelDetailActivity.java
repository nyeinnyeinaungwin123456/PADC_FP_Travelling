package com.padc.travelling.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.ImageAdapter;
import com.padc.travelling.components.PageIndicatorView;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.HotelsVO;
import com.padc.travelling.utils.TravellingConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotelDetailActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    /*@BindView(R.id.pager_hotel_images)
    ViewPager pagerHotelImages;*/

    @BindView(R.id.tv_hotel_title)
    TextView tvHotelTitle;

    @BindView(R.id.tv_hotel_name_deatil)
    TextView tvHotelNameDetail;

    @BindView(R.id.tv_hotel_detail_address)
    TextView tvHotelDetailAddress;

    @BindView(R.id.tv_hotel_detail_phone)
    TextView tvHotelDetailPhone;

    @BindView(R.id.tv_hotel_desc)
    TextView tvHotelDesc;

    @BindView(R.id.toolbar_hotel)
    Toolbar toolbar;

    @BindView(R.id.appbar_hotel)
    AppBarLayout appbarHotel;

    @BindView(R.id.pager_hotel_images)
    ViewPager pagerHotel;

    @BindView(R.id.pi_hotel_image_slider)
    PageIndicatorView piHotel;

    @BindView(R.id.collapsing_toolbar_hotel)
    CollapsingToolbarLayout collapsingToolbar;

    private static HotelsVO mHotelVO;
    private ShareActionProvider mShareActionProvider;
    private String mHotelTitle;

    public static final String IE_HOTEL_TITLE = "hotel_title";

    public static Intent newIntent(String hotelsTitle) {
        Intent intent = new Intent(TravellingApp.getContext(),HotelDetailActivity.class);
        intent.putExtra(IE_HOTEL_TITLE, hotelsTitle);
        return intent;
    }

    public void bindData(HotelsVO hotelVO) {
//        tvHotelNameDetail.setText(hotelVO.getHotel_name());
//        tvHotelDetailAddress.setText(mHotelVO.getLocationVO().getAddress());
//        tvHotelDetailPhone.setText(mHotelVO.getPhoneNumbers()[0]);
        tvHotelDesc.setText(hotelVO.getDescription());

//        String imageUrl = mHotelVO.getPhotos()[0];
//        Log.d("Img", " " + imageUrl);

        piHotel.setNumPage(hotelVO.getPhotos().length);

        ImageAdapter pagerAdapter = new ImageAdapter(hotelVO.getPhotos());
        pagerHotel.setAdapter(pagerAdapter);
        pagerHotel.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                GAUtils.getInstance().sendAppAction(GAUtils.ACTION_SWIPE_IMAGE_VIEW_PAGER,
//                        mAttractionTitle);

                piHotel.setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        collapsingToolbar.setTitle(mHotelTitle);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        appbarHotel.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
//                    tvHotelTitle.setText(mHotelVO.getHotel_name());
                    Toast.makeText(TravellingApp.getContext(),"collapsed",Toast.LENGTH_SHORT).show();
                }else if(verticalOffset == 0){
                    Toast.makeText(TravellingApp.getContext(),"expand",Toast.LENGTH_SHORT).show();
                }
            }
        });

//        bindData();

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mHotelTitle = getIntent().getStringExtra(IE_HOTEL_TITLE);
        getSupportLoaderManager().initLoader(TravellingConstants.HOTEL_DETAIL_LOADER, null, this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_hotel_search);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Toast.makeText(TravellingApp.getContext(),"Add to favourite list",Toast.LENGTH_SHORT).show();
            }
        });
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,
                TravelMyanmarContract.HotelEntry.buildHotelUriWithName(mHotelTitle),
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            mHotelVO = HotelsVO.parseFromCursor(data);
            mHotelVO.setPhotos(HotelsVO.loadHotelPhotoByTitle(mHotelVO.getHotel_name()));

            bindData(mHotelVO);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

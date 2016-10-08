package com.padc.travelling.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.ImageAdapter;
import com.padc.travelling.components.PageIndicatorView;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.RestaurantsVO;
import com.padc.travelling.utils.TravellingConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
//import mm.technomation.mmtext.mmtext;

/**
 * Created by Nyein Nyein on 9/13/2016.
 */
public class RestaurantPagerDetailActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @BindView(R.id.toolbar_restaurant)
    Toolbar toolbarRestaurant;

    @BindView(R.id.tv_restaurant_title)
    TextView tvTourPackageTitle;

    @BindView(R.id.tv_price_restaurantdetail)
    TextView tvPrice;

    @BindView(R.id.tv_places_restaurantdetail)
    TextView tvPlaces;

    @BindView(R.id.tv_address_restaurantdetail)
    TextView tvAddress;

    @BindView(R.id.tv_time_restaurantdetail)
    TextView tvTime;

    @BindView(R.id.tv_restaurantname)
    TextView tvRestaurantName;

    @BindView(R.id.pi_restaurant_image_slider)
    PageIndicatorView piRestaurant;

    @BindView(R.id.collapsing_toolbar_restaurant)
    CollapsingToolbarLayout mCollapsingToolbar;

    @BindView(R.id.pager_restaurant_images)
    ViewPager pagerRestaurant;

    @BindView(R.id.appbar_restaurant)
    AppBarLayout appBarRestaurant;

    private String mRestaurantName;
    private RestaurantsVO mRestaurant;

//    public static String temp = tvTourPackageTitle.getText().toString();

    public static final String IE_RESTAURANT_TITLE = "restauranttitle";
    public static final String PUT_IE_TOURPACKAGE_TITLE = "puttourpackagetitle";

    public static Intent newIntent(String restauranttitle)
    {
//        String temp = tv
        Intent intent = new Intent(TravellingApp.getContext(), RestaurantPagerDetailActivity.class);
        intent.putExtra(IE_RESTAURANT_TITLE,restauranttitle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailrestaurant);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbarRestaurant);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        mRestaurantName = getIntent().getStringExtra(IE_RESTAURANT_TITLE);
        getSupportLoaderManager().initLoader(TravellingConstants.RESTAURANT_DETAIL_LOADER, null, this);
        if(!getSupportLoaderManager().getLoader(TravellingConstants.RESTAURANT_DETAIL_LOADER).isReset()) {
            getSupportLoaderManager().restartLoader(TravellingConstants.RESTAURANT_DETAIL_LOADER, null, this);
        }

        appBarRestaurant.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (mCollapsingToolbar.getHeight() + verticalOffset < 2 * ViewCompat.getMinimumHeight(mCollapsingToolbar)) {
                    //toolbar is collapsed here
                    //write your code here
                    //mToolbar.setTitle("Mandalay");
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,
                TravelMyanmarContract.RestaurantEntry.buildRestaurantUriWithName(mRestaurantName),
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            mRestaurant = RestaurantsVO.parseFromCursor(data);
            mRestaurant.setPhotos(RestaurantsVO.loadRestaurantPhotobyName(mRestaurant.getName()));

            bindData(mRestaurant);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void bindData(RestaurantsVO restaurant) {

        tvRestaurantName.setText(restaurant.getName());
//        tvPrice.setText(restaurant.g());

        piRestaurant.setNumPage(restaurant.getPhotos().length);

        ImageAdapter pagerAdapter = new ImageAdapter(restaurant.getPhotos());
        pagerRestaurant.setAdapter(pagerAdapter);
        pagerRestaurant.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                GAUtils.getInstance().sendAppAction(GAUtils.ACTION_SWIPE_IMAGE_VIEW_PAGER,
//                        mAttractionTitle);

                piRestaurant.setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mCollapsingToolbar.setTitle(mRestaurantName);
    }
}

package com.padc.travelling.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.RestaurantsVO;
import com.padc.travelling.utils.TravellingConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import mm.technomation.mmtext.mmtext;

/**
 * Created by Nyein Nyein on 9/13/2016.
 */
public class RestaurantPagerDetailActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @BindView(R.id.toolbar_restaurantdetail)
    Toolbar toolbarRestaurant;

    @BindView(R.id.tv_restaurant_title)
    TextView tvTourPackageTitle;

    @BindView(R.id.tv_price)
    TextView tvPrice;

    @BindView(R.id.tv_places)
    TextView tvPlaces;

    @BindView(R.id.tv_address)
    TextView tvAddress;

    @BindView(R.id.tv_time)
    TextView tvTime;

    @BindView(R.id.iv_tourpackagedetail)
    ImageView ivTourpackageDetail;

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
//        intent.putExtra(PUT_IE_TOURPACKAGE_TITLE,temp);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailrestaurant);
        ButterKnife.bind(this,this);

        mmtext.isTextZawGyiProbably(String.valueOf(R.string.addtoplan));
        mmtext.isTextZawGyiProbably(String.valueOf(R.string.favourites));
        mmtext.isTextZawGyiProbably(String.valueOf(R.string.share));
        mmtext.isTextZawGyiProbably(String.valueOf(R.string.call));

        mmtext.prepareView(TravellingApp.getContext(),tvPrice,mmtext.TEXT_UNICODE,true,true);
        mmtext.prepareView(TravellingApp.getContext(),tvPlaces,mmtext.TEXT_UNICODE,true,true);
        mmtext.prepareView(TravellingApp.getContext(),tvAddress,mmtext.TEXT_UNICODE,true,true);
        mmtext.prepareView(TravellingApp.getContext(),tvTime,mmtext.TEXT_UNICODE,true,true);

        setSupportActionBar(toolbarRestaurant);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null) {
            String tourpackagetitle = (String)bundle.getString(HomeActivity.IE_RESTAURANT_TITLE);
            tvTourPackageTitle.setText(tourpackagetitle);
        }

        mRestaurantName = getIntent().getStringExtra(IE_RESTAURANT_TITLE);
        mmtext.isTextZawGyiProbably(mRestaurantName);
        getSupportLoaderManager().initLoader(TravellingConstants.RESTAURANT_DETAIL_LOADER, null, this);

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

//        tvPrice.setText(restaurant.g());

        String imageUrl = TravellingConstants.IMAGE_ROOT_RESTAURANT + restaurant.getPhotos()[0];
        Glide.with(ivTourpackageDetail.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivTourpackageDetail);

//        collapsingToolbar.setTitle(mAttractionTitle);
    }
}

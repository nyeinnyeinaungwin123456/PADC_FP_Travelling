package com.padc.travelling.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.ImageAdapter;
import com.padc.travelling.components.PageIndicatorView;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.tourpackageVOs.TourPackage;
import com.padc.travelling.utils.TravellingConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
//import mm.technomation.mmtext.mmtext;

//import com.padc.travelling.utils.GAUtils;

/**
 * Created by Nyein Nyein on 9/13/2016.
 */
public class TourPackagePagerDetailActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @BindView(R.id.toolbar)
    Toolbar toolbarPackage;

    @BindView(R.id.tv_toolbar_tourpackage)
    TextView tvTourPackageTitle;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.tv_price)
    TextView tvPrice;

    @BindView(R.id.tv_totaldays)
    TextView tvTotalDays;

    @BindView(R.id.tv_places)
    TextView tvPlaces;

//    @BindView(R.id.tv_address)
//    TextView tvAddress;

    @BindView(R.id.pi_tourpackage_image_slider)
    PageIndicatorView piTourpackageImgSlider;

    @BindView(R.id.pager_tourpackae_images)
    ViewPager pagerTourpackageImg;

    @BindView(R.id.tv_tourpackagedesc)
    TextView tvTourpackageDesc;

    @BindView(R.id.btn_call)
    Button btnCall;

    ArrayAdapter<String> adpPhone ;
    private String mTourpackageName;
    private TourPackage mTourpackage;

//    public static String temp = tvTourPackageTitle.getText().toString();

    public static final String IE_TOURPACKAGE_TITLE = "tourpackagetitle";
    public static final String PUT_IE_TOURPACKAGE_TITLE = "puttourpackagetitle";

    public static Intent newIntent(String tourpackagetitle)
    {
//        String temp = tv
        Intent intent = new Intent(TravellingApp.getContext(), TourPackagePagerDetailActivity.class);
        intent.putExtra(IE_TOURPACKAGE_TITLE,tourpackagetitle);
//        intent.putExtra(PUT_IE_TOURPACKAGE_TITLE,temp);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_tourpackage);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbarPackage);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mTourpackageName = getIntent().getStringExtra(IE_TOURPACKAGE_TITLE);

        getSupportLoaderManager().initLoader(TravellingConstants.TOURPACKAGE_DETAIL_LOADER, null, this);

        String strings [] = {"09799718769", "09449249546", "09973436843"};
        adpPhone = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, strings);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number =null;
                if(view.getId() == R.id.btn_call){
                    AlertDialog.Builder builder = new AlertDialog.Builder(TourPackagePagerDetailActivity.this);
                    builder.setAdapter(adpPhone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+adpPhone.getItem(i)));
                            startActivity(callIntent);
                        }
                    });

                    builder.setTitle("Choose One");
                    builder.show();
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
                TravelMyanmarContract.TourpackageEntry.buildTourpackageUriWithName(mTourpackageName),
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            mTourpackage = TourPackage.parseFromCursor(data);
            mTourpackage.setPhotos(TourPackage.loadTourPackagePhotobyName(mTourpackage.getPackageName()));

            bindData(mTourpackage);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void bindData(TourPackage tourpackage) {

        tvTourpackageDesc.setText(tourpackage.getDescription());
//        tvTourPackageTitle.setText(mTourpackageName);
        tvPrice.setText(String.valueOf(tourpackage.getEstimatePricePerPerson()));
        tvTotalDays.setText(tourpackage.getTotalDays());
        tvPlaces.setText(tourpackage.getPackageName());

        /*
        String imageUrl = MyanmarAttractionsConstants.IMAGE_ROOT_DIR + attraction.getImages()[0];
        Glide.with(ivAttraction.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivAttraction);
                */

        piTourpackageImgSlider.setNumPage(tourpackage.getPhotos().length);

        ImageAdapter pagerAdapter = new ImageAdapter(tourpackage.getPhotos());
        pagerTourpackageImg.setAdapter(pagerAdapter);
        pagerTourpackageImg.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                GAUtils.getInstance().sendAppAction(GAUtils.ACTION_SWIPE_IMAGE_VIEW_PAGER,
//                        mAttractionTitle);

                piTourpackageImgSlider.setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        collapsingToolbar.setTitle(mTourpackageName);
    }
}

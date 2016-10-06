package com.padc.travelling.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.ImageAdapter;
import com.padc.travelling.components.PageIndicatorView;
import com.padc.travelling.data.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.attractionplaces.AttractionPlaces;
import com.padc.travelling.utils.TravellingConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
//import mm.technomation.mmtext.mmtext;

public class AttractionDetailActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tv_toolbar_attraction)
    TextView tvToolbarAttraction;

    @BindView(R.id.appbar)
    AppBarLayout mAppBar;

//    @BindView(R.id.iv_attraction)
//    ImageView ivAttraction;

    @BindView(R.id.pager_attraction_images)
    ViewPager pagerAttraction;

    @BindView(R.id.tv_attraction_desc)
    TextView tvAttractionDesc;

    @BindView(R.id.pi_attraction_image_slider)
    PageIndicatorView piAttraction;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;

    private ShareActionProvider mShareActionProvider;
    private String mAttractionTitle;
    private AttractionPlaces mAttractionPlaces;

    public static final String IE_ATTRACTION_TITLE = "attraction_title";

    //Nyein static factory method
    public static Intent newIntent(String attractionTitle){
        Intent intent = new Intent(TravellingApp.getContext(),AttractionDetailActivity.class);
        intent.putExtra(IE_ATTRACTION_TITLE, attractionTitle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);
        ButterKnife.bind(this,this);
        setSupportActionBar(mToolbar);

//        mmtext.prepareView(TravellingApp.getContext(),tvToolbarAttraction,mmtext.TEXT_UNICODE,true,true);
//        mmtext.prepareView(TravellingApp.getContext(),tvAttractionDesc,mmtext.TEXT_UNICODE,true,true);


        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mAttractionTitle = getIntent().getStringExtra(IE_ATTRACTION_TITLE);
        getSupportLoaderManager().initLoader(TravellingConstants.ATTRACTION_DETAIL_LOADER, null, this);

//        Bundle bundle = getIntent().getExtras();
//        if(bundle !=null) {
//            String attactionplacesname = (String)bundle.getString(HomeActivity.IE_ATTRACTIONPLACES_NAME);
//            tvToolbarAttraction.setText(attactionplacesname);
//        }

        mAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (mCollapsingToolbar.getHeight() + verticalOffset < 2 * ViewCompat.getMinimumHeight(mCollapsingToolbar)) {
                    //toolbar is collapsed here
                    //write your code here
                    //mToolbar.setTitle("Mandalay");
                }
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    //Nyein go back to previous activity

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,
                TravelMyanmarContract.AttractionEntry.buildAttractionUriWithTitle(mAttractionTitle),
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            mAttractionPlaces = AttractionPlaces.parseFromCursor(data);
            mAttractionPlaces.setPlaceImage(AttractionPlaces.loadAttractionImagesByTitle(mAttractionPlaces.getPlaceTitle()));

            bindData(mAttractionPlaces);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void bindData(AttractionPlaces attractionplaces) {

//        tvAttractionTitle.setText(attractionplaces.getPlaceTitle());
        tvAttractionDesc.setText(attractionplaces.getPlaceDesc());
//        tvTotalDays.setText(tourpackage.getTotalDays());
//        tvPlaces.setText(tourpackage.getPackageName());


//        String imageUrl = attractionplaces.getPlaceImage()[0];
//        Log.d("attract image", imageUrl);
//        Glide.with(ivAttraction.getContext())
//                .load(imageUrl)
//                .centerCrop()
//                .placeholder(R.drawable.placeholder)
//                .error(R.drawable.placeholder)
//                .into(ivAttraction);


        piAttraction.setNumPage(attractionplaces.getPlaceImage().length);

        ImageAdapter pagerAdapter = new ImageAdapter(attractionplaces.getPlaceImage());
        pagerAttraction.setAdapter(pagerAdapter);
        pagerAttraction.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                GAUtils.getInstance().sendAppAction(GAUtils.ACTION_SWIPE_IMAGE_VIEW_PAGER,
//                        mAttractionTitle);

                piAttraction.setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mCollapsingToolbar.setTitle(mAttractionTitle);
    }
}

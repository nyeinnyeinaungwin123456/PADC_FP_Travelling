package com.padc.travelling.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import com.padc.travelling.data.vos.HotelsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotelDetailActivity extends AppCompatActivity{

    /*@BindView(R.id.pager_hotel_images)
    ViewPager pagerHotelImages;*/

    @BindView(R.id.tv_hotel_title)
    TextView tvHotelTitle;

    @BindView(R.id.iv_hotel_image_detail)
    ImageView ivHotelImageDetail;

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

    private static HotelsVO mHotelVO;
    private ShareActionProvider mShareActionProvider;

    public static Intent newIntent(HotelsVO hotelsVO) {
        mHotelVO = hotelsVO;
        Intent intent = new Intent(TravellingApp.getContext(), HotelDetailActivity.class);
        return intent;
    }

    public void bindData() {
        tvHotelNameDetail.setText(mHotelVO.getHotel_name());
//        tvHotelDetailAddress.setText(mHotelVO.getLocationVO().getAddress());
//        tvHotelDetailPhone.setText(mHotelVO.getPhoneNumbers()[0]);
        tvHotelDesc.setText(mHotelVO.getDescription());

        String imageUrl = mHotelVO.getPhotos()[0];
        Log.d("Img", " " + imageUrl);

        Glide.with(ivHotelImageDetail.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivHotelImageDetail);


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
                    tvHotelTitle.setText(mHotelVO.getHotel_name());
                    Toast.makeText(TravellingApp.getContext(),"collapsed",Toast.LENGTH_SHORT).show();
                }else if(verticalOffset == 0){
                    Toast.makeText(TravellingApp.getContext(),"expand",Toast.LENGTH_SHORT).show();
                }
            }
        });

        bindData();

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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
}

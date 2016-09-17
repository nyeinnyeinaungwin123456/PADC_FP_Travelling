package com.padc.travelling.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.RestaurantDetailAdapter;
import com.padc.travelling.adapters.TourPackageDetailAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/13/2016.
 */
public class TourPackagePagerDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_restaurantdetail)
    Toolbar toolbarRestaurant;

    @BindView(R.id.tv_restaurant_title)
    TextView tvTourPackageTitle;

//    ArrayAdapter<String> adpPhone ;

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
        setContentView(R.layout.activity_pager_restaurnt);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbarRestaurant);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null) {
            String tourpackagetitle = (String)bundle.getString(HomeActivity.IE_TOURPACKAGE_TITLE);
        tvTourPackageTitle.setText(tourpackagetitle);
        }

        RestaurantDetailAdapter restaurantDetailAdapter = new RestaurantDetailAdapter();
        ViewPager viewPager = (ViewPager)findViewById(R.id.pager_restaurant);
        viewPager.setAdapter(restaurantDetailAdapter);
        viewPager.setCurrentItem(0);

//        String strings [] = {"09799718769", "09449249546", "09973436843"};
//        adpPhone = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, strings);
//
//        btnCall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number =null;
//                if(view.getId() == R.id.btn_call){
//                    AlertDialog.Builder builder = new AlertDialog.Builder(TourPackagePagerDetailActivity.this);
//                    builder.setAdapter(adpPhone, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            Intent callIntent = new Intent(Intent.ACTION_CALL);
//                            callIntent.setData(Uri.parse("tel:"+adpPhone.getItem(i)));
//                            startActivity(callIntent);
//                        }
//                    });
//
//                    builder.setTitle("Choose One");
//                    builder.show();
//                }
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

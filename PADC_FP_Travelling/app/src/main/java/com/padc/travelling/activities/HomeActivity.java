package com.padc.travelling.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.AttractionPlacesVO;
import com.padc.travelling.data.vos.RestaurantVO;
import com.padc.travelling.fragments.AttractionPlacesFragment;
import com.padc.travelling.fragments.RestaurantandHotelTabFragment;
import com.padc.travelling.view.AttractionPlacesViewHolder;
import com.padc.travelling.view.RestaurnatViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        AttractionPlacesViewHolder.ControllerAttractionPlaces, MenuItemCompat.OnActionExpandListener,
        RestaurnatViewHolder.ControllerRestaurant{

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.tv_search_travel)
    TextView tvSearchTravel;

    @BindView(R.id.fl_container)
    FrameLayout flContainer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ShareActionProvider mShareActionProvider;
    ArrayAdapter<String> adpSetting;

    public static String IE_RESTAURANT_TITLE = "restauranttitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this,this);

        String strings[] = {"ေျမပံုလမ္းညႊန္","အေသးစိတ္ၾကည့္ရန္"};
        adpSetting = new ArrayAdapter<String>(HomeActivity.this,
                android.R.layout.simple_list_item_1, strings);

        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
               R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null){

            navigateToAttractionPlaces();
        }

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);

        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        if(searchMenuItem != null){

            MenuItemCompat.setOnActionExpandListener(searchMenuItem, new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    tvSearchTravel.setVisibility(View.VISIBLE);
                    flContainer.setVisibility(View.INVISIBLE);
                    return true;
                }

                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    tvSearchTravel.setVisibility(View.INVISIBLE);
                    flContainer.setVisibility(View.VISIBLE);
                    return true;
                }
            });

        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        drawerLayout.closeDrawer(GravityCompat.START);
        switch(item.getItemId()) {

            case R.id.menu_attractionplaces: {
                navigateToAttractionPlaces();
            } break;

            case R.id.menu_tourpackages: {

            } break;
            case R.id.menu_highway: {

            }break;
            case R.id.menu_hotels:{

            }break;
            case R.id.menu_restaurants:{
            navigateToRestaurant();
            }break;
            case R.id.menu_feedback:{

            }break;
            case R.id.menu_aboutus:{

            }

        }

//        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
//        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        tvSearchTravel.setVisibility(View.VISIBLE);
        flContainer.setVisibility(View.INVISIBLE);

        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        tvSearchTravel.setVisibility(View.INVISIBLE);
        flContainer.setVisibility(View.VISIBLE);

        return true;
    }

    private void navigateToAttractionPlaces(){
    getSupportFragmentManager().
            beginTransaction().
            replace(R.id.fl_container, AttractionPlacesFragment.newInstance()).
            commit();
    }

    public void navigateToRestaurant(){
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fl_container, RestaurantandHotelTabFragment.newInstance()).
                commit();
    }

    @Override
    public void onTapAttractionPlaces(AttractionPlacesVO attractionPlacesVO, int position) {

    }

    @Override
    public void onTapRestaurnat(RestaurantVO restaurantVO, int position) {

//        Testing
        Intent intent = new Intent(TravellingApp.getContext(),TourPackagePagerDetailActivity.class);
        intent.putExtra(IE_RESTAURANT_TITLE,restaurantVO.getRestaurantTile());
        startActivity(intent);
    }

    @Override
    public void onTapSetting(ImageView ivsetting) {

        Log.d("ImageView", "is : "+ivsetting);
       final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
//        builder.setAdapter(adpSetting)
                builder.setAdapter(adpSetting, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("OnClick","OnClick is : "+i);
//                    TODO
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();

        wmlp.gravity = Gravity.TOP | Gravity.RIGHT;
        wmlp.x = 100;   //x position
        wmlp.y = 100;
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }
}

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.PathsAdapter;
import com.padc.travelling.data.vos.PathsVO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HighWayDetailActivity extends AppCompatActivity {

    @BindView(R.id.rv_paths)
    RecyclerView rvPaths;

    @BindView(R.id.toolbar_highway)
    Toolbar toolbar;

    private ShareActionProvider mShareActionProvider;

    private List<PathsVO> pathsVOList = new ArrayList<>();
    private PathsAdapter pathsAdapter;

    public static Intent newIntent() {
        Intent intent = new Intent(TravellingApp.getContext(), HighWayDetailActivity.class);
        return intent;
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

        prepareData();

        pathsAdapter = new PathsAdapter(pathsVOList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TravellingApp.getContext());
        rvPaths.setLayoutManager(layoutManager);
        rvPaths.setAdapter(pathsAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_highway_search);
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

    private void prepareData() {
        PathsVO pathsVO;

        for(int i=0; i<8; i++) {
            pathsVO = new PathsVO("Yangon-Mandalay");
            pathsVOList.add(pathsVO);
        }
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

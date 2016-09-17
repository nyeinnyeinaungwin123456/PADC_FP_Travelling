package com.padc.travelling.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.padc.travelling.R;
import com.padc.travelling.adapters.TourPackageAdapter;
import com.padc.travelling.data.vos.TourPackageVO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/15/2016.
 */
public class CustomSearchActivity extends AppCompatActivity {

    @BindView(R.id.et_search_tourpacakge)
    TextView etSearch;

    @BindView(R.id.toolbar_search)
    Toolbar toolbarSearch;

    @BindView(R.id.btnclearsearch)
    Button btnClear;

    private List<TourPackageVO> mTourPackageVOList = new ArrayList<>();

    TourPackageAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbarSearch);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setText("");
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
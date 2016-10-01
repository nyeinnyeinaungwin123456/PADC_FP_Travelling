package com.padc.travelling.activities;

import android.content.Intent;
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
import com.padc.travelling.TravellingApp;
import com.padc.travelling.adapters.TourPackageAdapter;
import com.padc.travelling.fragments.AttractionPlacesFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/15/2016.
 */
public class CustomSearchActivity extends AppCompatActivity {

    @BindView(R.id.autoCompleteTextView)
    TextView autoCompleteTextView;

    @BindView(R.id.toolbar_search)
    Toolbar toolbarSearch;

    @BindView(R.id.btnclearsearch)
    Button btnClear;

    TourPackageAdapter adapter;
    AttractionPlacesFragment attractFragment = new AttractionPlacesFragment();

    public static Intent newIntent(){
        Intent intentToCustomSearchActivity = new Intent(TravellingApp.getContext(), CustomSearchActivity.class);
        return intentToCustomSearchActivity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbarSearch);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

//        String[] countries = getResources().getStringArray(R.array.list_of_countries);
//        String countries = attractFragment.prepareAttractionPlacesData().toString();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
//        autoCompleteTextView.setAdapter(adapter);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                autoCompleteTextView.setText("");
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
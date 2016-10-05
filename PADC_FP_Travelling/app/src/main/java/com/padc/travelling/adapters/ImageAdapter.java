package com.padc.travelling.adapters;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nyein Nyein on 9/13/2016.
 */
public class ImageAdapter extends PagerAdapter {

    private List<String> mImages;
    private LayoutInflater mInflater;

    public ImageAdapter(String[] images) {
        if (images == null) {
            mImages = new ArrayList<>();
        } else {
            mImages = new ArrayList<>(Arrays.asList(images));
        }
        mInflater = LayoutInflater.from(TravellingApp.getContext());
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView ivTourpackage = (ImageView) mInflater.inflate(R.layout.view_item_tourpackage_image, container, false);

        String imageUrl = mImages.get(position);

        Log.d("tourpackage image",imageUrl);
        Glide.with(ivTourpackage.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivTourpackage);

        ((ViewPager) container).addView(ivTourpackage);

        return ivTourpackage;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}

package com.padc.travelling.adapters;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.padc.travelling.R;
import com.padc.travelling.TravellingApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by TY on 9/15/2016.
 */
public class HotelImagePagerAdapter extends PagerAdapter {


    private List<String> mImages;
    private LayoutInflater mInflater;

    public HotelImagePagerAdapter(String[] images) {
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

        ImageView ivHotelImage = (ImageView) mInflater.inflate(R.layout.view_item_hotel_image, container, false);

        ((ViewPager) container).addView(ivHotelImage);

        return ivHotelImage;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}

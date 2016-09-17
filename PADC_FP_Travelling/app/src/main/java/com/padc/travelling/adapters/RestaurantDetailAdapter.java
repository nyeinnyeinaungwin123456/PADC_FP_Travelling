package com.padc.travelling.adapters;

<<<<<<< d80acb20e2f15149a287273d04fdf49daf68eadf
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.travelling.R;

/**
 * Created by Nyein Nyein on 9/17/2016.
 */
public class RestaurantDetailAdapter extends PagerAdapter {

    @Override
    public int getCount() {
        return 3;
    }

    public Object instantiateItem(View collection, int position){
        LayoutInflater inflater = (LayoutInflater)collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int resId = 0;

        switch (position){
            case 0:
                resId = R.layout.activity_detailrestaurant;
                break;

            case 1:
                resId = R.layout.activity_detailrestaurant2;
                break;

            case 2:
                resId = R.layout.activity_detailrestaurant3;
                break;

        }
        View view = inflater.inflate(resId, null);
        ((ViewPager)collection).addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
=======
/**
 * Created by Nyein Nyein on 9/17/2016.
 */
public class RestaurantDetailAdapter {
>>>>>>> -detail implementation
}

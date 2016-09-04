package com.padc.travelling;

import android.app.Application;
import android.content.Context;

/**
 * Created by Nyein Nyein on 9/4/2016.
 */
public class TravellingApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context= getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}

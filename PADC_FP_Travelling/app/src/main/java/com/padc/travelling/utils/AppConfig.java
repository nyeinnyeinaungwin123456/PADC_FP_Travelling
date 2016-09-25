package com.padc.travelling.utils;


import com.padc.travelling.BuildConfig;

/**
 * Created by aung on 8/19/16.
 */
public class AppConfig {

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    public static boolean isEnableGATracking() {
        //return !isDebug();
        return true;
    }
}

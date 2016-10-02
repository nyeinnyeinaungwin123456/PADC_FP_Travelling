package com.padc.travelling.data.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.data.vos.tourpackageVOs.TourPackage;

import java.util.ArrayList;


/**
 * Created by aung on 7/9/16.
 */
public class TourPackageListResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("tour-packages")
    private ArrayList<TourPackage> tourpackageList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<TourPackage> getTourPackageList() {
        return tourpackageList;
    }
}

package com.padc.travelling.data.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.data.vos.RestaurantsVO;

import java.util.ArrayList;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class RestaurantsListResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("restaurants")
    private ArrayList<RestaurantsVO> restaurantsList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<RestaurantsVO> getRestaurantsList() {
        return restaurantsList;
    }
}

package com.padc.travelling.data.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.data.vos.HotelsVO;

import java.util.ArrayList;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class HotelsListResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("hotels")
    private ArrayList<HotelsVO> hotelsList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<HotelsVO> getHotelsList() {
        return hotelsList;
    }
}

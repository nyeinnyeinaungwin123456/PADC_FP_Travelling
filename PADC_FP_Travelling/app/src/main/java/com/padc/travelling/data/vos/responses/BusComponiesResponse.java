package com.padc.travelling.data.vos.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.data.vos.BusComponiesVO;

import java.util.ArrayList;

/**
 * Created by TY on 9/27/2016.
 */
public class BusComponiesResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("buses")
    private ArrayList<BusComponiesVO> busComponiesList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<BusComponiesVO> getBusComponiesList() {
        return busComponiesList;
    }
}

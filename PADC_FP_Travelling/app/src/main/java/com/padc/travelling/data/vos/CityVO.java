package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 24-Sep-16.
 */
public class CityVO {


    @SerializedName("city-id")
    private int cityId;

    @SerializedName("name")
    private int name;

    @SerializedName("description")
    private int description;

    private static CityVO  objInstance;

    public CityVO() {
    }

    public static CityVO getInstance(){
        if(objInstance == null){
            objInstance = new CityVO();
        }
        return objInstance;
    }

    public int getCityId() {
        return cityId;
    }

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }
}

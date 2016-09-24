package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 24-Sep-16.
 */
public class LocationVO {

    @SerializedName("lat")
    private long lat;

    @SerializedName("lng")
    private long lng;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private CityVO city;

    @SerializedName("state")
    private StateVO state;

    private static LocationVO objInstance;

    public LocationVO() {
    }

    public static LocationVO getObjInstance(){
        if(objInstance==null){
            objInstance = new LocationVO();
        }
        return  objInstance;
    }

    public long getLat() {
        return lat;
    }

    public long getLng() {
        return lng;
    }

    public String getAddress() {
        return address;
    }

    public CityVO getCity() {
        return city;
    }

    public StateVO getState() {
        return state;
    }
}

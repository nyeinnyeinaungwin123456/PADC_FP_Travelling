package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TY on 9/22/2016.
 */
public class LocationVO {

    @SerializedName("lat")
    private double lat;

    @SerializedName("lug")
    private double lug;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private CityVO city;

    @SerializedName("state")
    private StateVO state;


    public LocationVO() {
    }

    public LocationVO(double lat, double lug, String address, CityVO city, StateVO state) {
        this.lat = lat;
        this.lug = lug;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public double getLat() {
        return lat;
    }

    public double getLug() {
        return lug;
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

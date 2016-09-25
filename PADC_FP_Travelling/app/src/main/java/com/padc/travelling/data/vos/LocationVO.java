package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class LocationVO {

    @SerializedName("lat")
    private double lat;

    @SerializedName("lng")
    private double lng;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private CityVO city;

    @SerializedName("state")
    private StateVO state;

    public LocationVO() {
    }

    public LocationVO(long lat, long lng, String address, CityVO city, StateVO state) {
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
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

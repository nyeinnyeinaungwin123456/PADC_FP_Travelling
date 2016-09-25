
package com.padc.travelling.data.vos.attractionplaces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class LocationPlaces {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private CityPlaces city;
    @SerializedName("state")
    @Expose
    private StatePlaces state;

    public LocationPlaces() {
    }

    public LocationPlaces(Double lat, Double lng, String address, CityPlaces city, StatePlaces state) {
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public String getAddress() {
        return address;
    }

    public CityPlaces getCity() {
        return city;
    }

    public StatePlaces getState() {
        return state;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(CityPlaces city) {
        this.city = city;
    }

    public void setState(StatePlaces state) {
        this.state = state;
    }
}

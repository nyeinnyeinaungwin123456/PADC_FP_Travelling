
package com.padc.travelling.data.vos.BusVOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class LocationTicketOutlet {

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
    private CityBus city;
    @SerializedName("state")
    @Expose
    private StateBus state;

    public LocationTicketOutlet() {
    }

    public LocationTicketOutlet(Double lat, Double lng, String address, CityBus city, StateBus state) {
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

    public CityBus getCity() {
        return city;
    }

    public StateBus getState() {
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

    public void setCity(CityBus city) {
        this.city = city;
    }

    public void setState(StateBus state) {
        this.state = state;
    }
}

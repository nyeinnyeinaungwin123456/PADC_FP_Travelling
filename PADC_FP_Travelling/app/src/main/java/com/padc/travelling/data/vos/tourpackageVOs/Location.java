
package com.padc.travelling.data.vos.tourpackageVOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Location {

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
    private CityHotels city;
    @SerializedName("state")
    @Expose
    private StateHotels state;

    /**
     * 
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     * 
     * @param lng
     *     The lng
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * 
     * @return
     *     The city
     */
    public CityHotels getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(CityHotels city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The state
     */
    public StateHotels getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(StateHotels state) {
        this.state = state;
    }

}

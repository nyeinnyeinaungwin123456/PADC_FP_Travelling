package com.padc.travelling.data.vos.hotelVOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class Hotels {

    @SerializedName("hotel-id")
    private Integer hotelId;

    @SerializedName("hotel-name")
    private String hotelName;

    @SerializedName("description")
    private String hotelDescription;

    @SerializedName("photos")
    private String[] hotelPhotos;

    @SerializedName("direction-to-hotel")
    private String hotelDirection;

    @SerializedName("phone-numbers")
    private String[] hotelPhone;

    @SerializedName("location")
    private LocationHotels hotelLoction;

    public Hotels() {
    }

    public Hotels(Integer hotelId, String hotelName, String hotelDescription, String[] hotelPhotos, String hotelDirection, String[] hotelPhone, LocationHotels hotelLoction) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.hotelPhotos = hotelPhotos;
        this.hotelDirection = hotelDirection;
        this.hotelPhone = hotelPhone;
        this.hotelLoction = hotelLoction;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public String[] getHotelPhotos() {
        return hotelPhotos;
    }

    public String getHotelDirection() {
        return hotelDirection;
    }

    public String[] getHotelPhone() {
        return hotelPhone;
    }

    public LocationHotels getHotelLoction() {
        return hotelLoction;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public void setHotelPhotos(String[] hotelPhotos) {
        this.hotelPhotos = hotelPhotos;
    }

    public void setHotelDirection(String hotelDirection) {
        this.hotelDirection = hotelDirection;
    }

    public void setHotelPhone(String[] hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public void setHotelLoction(LocationHotels hotelLoction) {
        this.hotelLoction = hotelLoction;
    }
}

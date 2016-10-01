package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TY on 9/22/2016.
 */
public class HotelsVO {

    @SerializedName("hotel-id")
    private int hotel_id;

    @SerializedName("hotel-name")
    private String hotel_name;

    @SerializedName("description")
    private String description;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("direction-to-hotel")
    private String direction_to_hotel;

    @SerializedName("phone-numbers")
    private String[] phoneNumbers;

    @SerializedName("location")
    private LocationVO locationVO;

    public HotelsVO() {
    }

    public HotelsVO(int hotel_id, String hotel_name, String description, String[] photos, String direction_to_hotel, String[] phoneNumbers, LocationVO locationVO) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.description = description;
        this.photos = photos;
        this.direction_to_hotel = direction_to_hotel;
        this.phoneNumbers = phoneNumbers;
        this.locationVO = locationVO;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getPhotos() {
        return photos;
    }

    public String getDirection_to_hotel() {
        return direction_to_hotel;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public LocationVO getLocationVO() {
        return locationVO;
    }
}

package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class HotelsVO {

    @SerializedName("hotel-id")
    private long hotelId;

    @SerializedName("hotel-name")
    private String hotelName;

    @SerializedName("description")
    private String description;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("direction-to-hotel")
    private String directionToHotel;

    @SerializedName("phone-numbers")
    private String[] phoneNumbers;

    @SerializedName("location")
    private LocationVO location;

    public HotelsVO() {
    }

    public HotelsVO(long hotelId, String hotelName, String description, String[] photos, String directionToHotel, String[] phoneNumbers, LocationVO location) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.description = description;
        this.photos = photos;
        this.directionToHotel = directionToHotel;
        this.phoneNumbers = phoneNumbers;
        this.location = location;
    }

    public long getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getDescription() {
        return description;
    }

    public String[] getPhotos() {
        return photos;
    }

    public String getDirectionToHotel() {
        return directionToHotel;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public LocationVO getLocation() {
        return location;
    }
}

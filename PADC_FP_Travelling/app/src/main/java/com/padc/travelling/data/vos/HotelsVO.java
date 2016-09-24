package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 24-Sep-16.
 */
public class HotelsVO {

    @SerializedName("hotel-id")
    private int hotelId;

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

    private static HotelsVO objInstance;

    public HotelsVO() {
    }

    public static HotelsVO getObjInstance(){
        if(objInstance==null){
            objInstance = new HotelsVO();
        }
        return objInstance;
    }

    public int getHotelId() {
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

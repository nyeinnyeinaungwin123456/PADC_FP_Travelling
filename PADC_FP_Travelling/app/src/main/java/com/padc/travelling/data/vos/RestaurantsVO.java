package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class RestaurantsVO {

    @SerializedName("restaurant-id")
    private long restaurantId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("note-to-visitor")
    private String noteToVisitor;

    @SerializedName("location")
    private LocationVO location;

    @SerializedName("operating-time")
    private OperatingTimeVO operatingTime;

    public RestaurantsVO() {
    }

    public RestaurantsVO(long restaurantId, String name, String description, String[] photos, String noteToVisitor, LocationVO location, OperatingTimeVO operatingTime) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.noteToVisitor = noteToVisitor;
        this.location = location;
        this.operatingTime = operatingTime;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getPhotos() {
        return photos;
    }

    public String getNoteToVisitor() {
        return noteToVisitor;
    }

    public LocationVO getLocation() {
        return location;
    }

    public OperatingTimeVO getOperatingTime() {
        return operatingTime;
    }
}

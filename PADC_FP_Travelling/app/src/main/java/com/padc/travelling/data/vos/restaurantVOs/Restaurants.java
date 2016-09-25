package com.padc.travelling.data.vos.restaurantVOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class Restaurants {

    @SerializedName("restaurant-id")
    private Long restaurantId;

    @SerializedName("name")
    private String restaurantName;

    @SerializedName("description")
    private String restaurantDescription;

    @SerializedName("photos")
    private String[] restaurantPhotos;

    @SerializedName("note-to-visitor")
    private String restaurantNote;

    @SerializedName("location")
    private Location restaurantLocation;

    @SerializedName("operating-time")
    private OperationTime restaurantOpTime;

    public Restaurants() {
    }

    public Restaurants(Long restaurantId, String restaurantName, String restaurantDescription, String[] restaurantPhotos, String restaurantNote, Location restaurantLocation, OperationTime restaurantOpTime) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantDescription = restaurantDescription;
        this.restaurantPhotos = restaurantPhotos;
        this.restaurantNote = restaurantNote;
        this.restaurantLocation = restaurantLocation;
        this.restaurantOpTime = restaurantOpTime;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantDescription() {
        return restaurantDescription;
    }

    public String[] getRestaurantPhotos() {
        return restaurantPhotos;
    }

    public String getRestaurantNote() {
        return restaurantNote;
    }

    public Location getRestaurantLocation() {
        return restaurantLocation;
    }

    public OperationTime getRestaurantOpTime() {
        return restaurantOpTime;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setRestaurantDescription(String restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }

    public void setRestaurantPhotos(String[] restaurantPhotos) {
        this.restaurantPhotos = restaurantPhotos;
    }

    public void setRestaurantNote(String restaurantNote) {
        this.restaurantNote = restaurantNote;
    }

    public void setRestaurantLocation(Location restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public void setRestaurantOpTime(OperationTime restaurantOpTime) {
        this.restaurantOpTime = restaurantOpTime;
    }
}

package com.padc.travelling.data.vos.attractionplaces;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nyein Nyein on 9/25/2016.
 */
public class AttractionPlaces {

    @SerializedName("place-id")
    private Long placeId;

    @SerializedName("title")
    private String placeTitle;

    @SerializedName("image")
    private String[] placeImage;

    @SerializedName("description")
    private String placeDesc;

    @SerializedName("note-to-visitor")
    private String placeNote;

    @SerializedName("location")
    private LocationPlaces placeLocation;

    @SerializedName("tags")
    private List<Tags> placeTags;

    @SerializedName("operating-time")
    private OperationTimePlaces placeOpTime;

    @SerializedName("place-category")
    private PlaceCategories placeCat;

    public AttractionPlaces() {
    }

    public AttractionPlaces(Long placeId, String placeTitle, String[] placeImage, String placeDesc, String placeNote, LocationPlaces placeLocation, List<Tags> placeTags, OperationTimePlaces placeOpTime, PlaceCategories placeCat) {
        this.placeId = placeId;
        this.placeTitle = placeTitle;
        this.placeImage = placeImage;
        this.placeDesc = placeDesc;
        this.placeNote = placeNote;
        this.placeLocation = placeLocation;
        this.placeTags = placeTags;
        this.placeOpTime = placeOpTime;
        this.placeCat = placeCat;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public String getPlaceTitle() {
        return placeTitle;
    }

    public String[] getPlaceImage() {
        return placeImage;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public String getPlaceNote() {
        return placeNote;
    }

    public LocationPlaces getPlaceLocation() {
        return placeLocation;
    }

    public List<Tags> getPlaceTags() {
        return placeTags;
    }

    public OperationTimePlaces getPlaceOpTime() {
        return placeOpTime;
    }

    public PlaceCategories getPlaceCat() {
        return placeCat;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public void setPlaceTitle(String placeTitle) {
        this.placeTitle = placeTitle;
    }

    public void setPlaceImage(String[] placeImage) {
        this.placeImage = placeImage;
    }

    public void setPlaceDesc(String placeDesc) {
        this.placeDesc = placeDesc;
    }

    public void setPlaceNote(String placeNote) {
        this.placeNote = placeNote;
    }

    public void setPlaceLocation(LocationPlaces placeLocation) {
        this.placeLocation = placeLocation;
    }

    public void setPlaceTags(List<Tags> placeTags) {
        this.placeTags = placeTags;
    }

    public void setPlaceOpTime(OperationTimePlaces placeOpTime) {
        this.placeOpTime = placeOpTime;
    }

    public void setPlaceCat(PlaceCategories placeCat) {
        this.placeCat = placeCat;
    }
}

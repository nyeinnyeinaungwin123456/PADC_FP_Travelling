package com.padc.travelling.data.vos.BusVOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class StartDestination {

    @SerializedName("destination-id")
    private Integer destinationId;

    @SerializedName("destination-title")
    private String destinationTitle;

    @SerializedName("destination-photos")
    private Integer destinationPhotos;

    @SerializedName("time-markers")
    private TimeMakerStart timeMakerStart;

    public StartDestination() {
    }

    public StartDestination(Integer destinationId, String destinationTitle, Integer destinationPhotos, TimeMakerStart timeMakerStart) {
        this.destinationId = destinationId;
        this.destinationTitle = destinationTitle;
        this.destinationPhotos = destinationPhotos;
        this.timeMakerStart = timeMakerStart;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public String getDestinationTitle() {
        return destinationTitle;
    }

    public Integer getDestinationPhotos() {
        return destinationPhotos;
    }

    public TimeMakerStart getTimeMakerStart() {
        return timeMakerStart;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public void setDestinationTitle(String destinationTitle) {
        this.destinationTitle = destinationTitle;
    }

    public void setDestinationPhotos(Integer destinationPhotos) {
        this.destinationPhotos = destinationPhotos;
    }

    public void setTimeMakerStart(TimeMakerStart timeMakerStart) {
        this.timeMakerStart = timeMakerStart;
    }
}

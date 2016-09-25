package com.padc.travelling.data.vos.BusVOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class MidPoint {

    @SerializedName("destination-id")
    private Integer destinationId;

    @SerializedName("destination-title")
    private String destinationTitle;

    @SerializedName("destination-photos")
    private Integer destinationPhotos;

    @SerializedName("time-markers")
    private TimeMakerMid timeMakerMid;

    public MidPoint() {
    }

    public MidPoint(Integer destinationId, String destinationTitle, Integer destinationPhotos, TimeMakerMid timeMakerMid) {
        this.destinationId = destinationId;
        this.destinationTitle = destinationTitle;
        this.destinationPhotos = destinationPhotos;
        this.timeMakerMid = timeMakerMid;
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

    public TimeMakerMid getTimeMakerMid() {
        return timeMakerMid;
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

    public void setTimeMakerMid(TimeMakerMid timeMakerMid) {
        this.timeMakerMid = timeMakerMid;
    }
}

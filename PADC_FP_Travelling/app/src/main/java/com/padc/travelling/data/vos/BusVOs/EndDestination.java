package com.padc.travelling.data.vos.BusVOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class EndDestination {

    @SerializedName("destination-id")
    private Integer destinationId;

    @SerializedName("destination-title")
    private String destinationTitle;

    @SerializedName("destination-photos")
    private Integer destinationPhotos;

    @SerializedName("time-markers")
    private TimeMakerEnd timeMakerEnd;

    public EndDestination() {
    }

    public EndDestination(Integer destinationId, String destinationTitle, Integer destinationPhotos, TimeMakerEnd timeMakerEnd) {
        this.destinationId = destinationId;
        this.destinationTitle = destinationTitle;
        this.destinationPhotos = destinationPhotos;
        this.timeMakerEnd = timeMakerEnd;
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

    public TimeMakerEnd getTimeMakerEnd() {
        return timeMakerEnd;
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

    public void setTimeMakerEnd(TimeMakerEnd timeMakerEnd) {
        this.timeMakerEnd = timeMakerEnd;
    }
}

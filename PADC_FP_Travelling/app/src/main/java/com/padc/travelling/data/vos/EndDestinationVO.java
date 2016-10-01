package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TY on 9/22/2016.
 */
public class EndDestinationVO {

    @SerializedName("destination-id")
    private int destination_id;

    @SerializedName("destination-title")
    private String destination_title;

    @SerializedName("destination-photos")
    private String[] destination_photos;

    @SerializedName("time-markers")
    private TimeMakersVO timeMakersVO;

    public EndDestinationVO() {
    }

    public EndDestinationVO(int destination_id, String destination_title, String[] destination_photos, TimeMakersVO timeMakersVO) {
        this.destination_id = destination_id;
        this.destination_title = destination_title;
        this.destination_photos = destination_photos;
        this.timeMakersVO = timeMakersVO;
    }

    public int getDestination_id() {
        return destination_id;
    }

    public String getDestination_title() {
        return destination_title;
    }

    public String[] getDestination_photos() {
        return destination_photos;
    }

    public TimeMakersVO getTimeMakersVO() {
        return timeMakersVO;
    }
}

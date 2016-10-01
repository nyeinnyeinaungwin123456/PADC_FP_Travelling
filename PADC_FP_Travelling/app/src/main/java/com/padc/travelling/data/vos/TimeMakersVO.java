package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TY on 9/22/2016.
 */
public class TimeMakersVO {

    @SerializedName("departure-time")
    private String departure_time;

    @SerializedName("arrival-time")
    private String arrival_time;

    @SerializedName("upward-pass-through-time")
    private String upward_pass_through_time;

    @SerializedName("downward-pass-through-time")
    private String downward_pass_through_time;

    public TimeMakersVO() {
    }

    public TimeMakersVO(String departure_time, String arrival_time, String upward_pass_through_time, String downward_pass_through_time) {
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.upward_pass_through_time = upward_pass_through_time;
        this.downward_pass_through_time = downward_pass_through_time;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getUpward_pass_through_time() {
        return upward_pass_through_time;
    }

    public String getDownward_pass_through_time() {
        return downward_pass_through_time;
    }
}

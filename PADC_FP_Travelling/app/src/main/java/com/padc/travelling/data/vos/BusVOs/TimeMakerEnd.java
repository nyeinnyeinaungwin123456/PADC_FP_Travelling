package com.padc.travelling.data.vos.BusVOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class TimeMakerEnd {

    @SerializedName("departure-time")
    private String departureTime;

    @SerializedName("arrival-time")
    private String arrivalTime;

    @SerializedName("upward-pass-through-time")
    private String upwardPass;

    @SerializedName("downward-pass-through-time")
    private String downwardPass;

    public TimeMakerEnd() {
    }

    public TimeMakerEnd(String departureTime, String arrivalTime, String upwardPass, String downwardPass) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.upwardPass = upwardPass;
        this.downwardPass = downwardPass;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getUpwardPass() {
        return upwardPass;
    }

    public String getDownwardPass() {
        return downwardPass;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setUpwardPass(String upwardPass) {
        this.upwardPass = upwardPass;
    }

    public void setDownwardPass(String downwardPass) {
        this.downwardPass = downwardPass;
    }
}

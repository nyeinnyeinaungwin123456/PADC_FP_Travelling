package com.padc.travelling.data.vos.BusVOs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class Routes {

    @SerializedName("route-id")
    private Integer routeId;

    @SerializedName("route-title")
    private String routeTitle;

    @SerializedName("photos")
    private String routePhotos;

    @SerializedName("price")
    private String routePrice;

    @SerializedName("start-destination")
    private StartDestination startDestination;

    @SerializedName("end-destination")
    private EndDestination endDestination;

    @SerializedName("mid-points")
    private List<MidPoint> midPoint;

    public Routes() {
    }

    public Routes(Integer routeId, String routeTitle, String routePhotos, String routePrice, StartDestination startDestination, EndDestination endDestination, List<MidPoint> midPoint) {
        this.routeId = routeId;
        this.routeTitle = routeTitle;
        this.routePhotos = routePhotos;
        this.routePrice = routePrice;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.midPoint = midPoint;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public String getRouteTitle() {
        return routeTitle;
    }

    public String getRoutePhotos() {
        return routePhotos;
    }

    public String getRoutePrice() {
        return routePrice;
    }

    public StartDestination getStartDestination() {
        return startDestination;
    }

    public EndDestination getEndDestination() {
        return endDestination;
    }

    public List<MidPoint> getMidPoint() {
        return midPoint;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public void setRouteTitle(String routeTitle) {
        this.routeTitle = routeTitle;
    }

    public void setRoutePhotos(String routePhotos) {
        this.routePhotos = routePhotos;
    }

    public void setRoutePrice(String routePrice) {
        this.routePrice = routePrice;
    }

    public void setStartDestination(StartDestination startDestination) {
        this.startDestination = startDestination;
    }

    public void setEndDestination(EndDestination endDestination) {
        this.endDestination = endDestination;
    }

    public void setMidPoint(List<MidPoint> midPoint) {
        this.midPoint = midPoint;
    }
}

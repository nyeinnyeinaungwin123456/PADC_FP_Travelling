package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TY on 9/22/2016.
 */
public class RoutesVO {

    @SerializedName("route_id")
    private int route_id;

    @SerializedName("route_title")
    private String route_title;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("price")
    private int price;

    @SerializedName("start-destination")
    private StartDestinationVO startDestinationVO;

    @SerializedName("end-destination")
    private EndDestinationVO endDestinationVO;

    @SerializedName("mid-points")
    private MidPointsVO[] midPointsVOs;

    public RoutesVO() {
    }

    public RoutesVO(int route_id, String route_title, String[] photos, int price, StartDestinationVO startDestinationVO, EndDestinationVO endDestinationVO, MidPointsVO[] midPointsVOs) {
        this.route_id = route_id;
        this.route_title = route_title;
        this.photos = photos;
        this.price = price;
        this.startDestinationVO = startDestinationVO;
        this.endDestinationVO = endDestinationVO;
        this.midPointsVOs = midPointsVOs;
    }

    public int getRoute_id() {
        return route_id;
    }

    public String getRoute_title() {
        return route_title;
    }

    public String[] getPhotos() {
        return photos;
    }

    public int getPrice() {
        return price;
    }

    public StartDestinationVO getStartDestinationVO() {
        return startDestinationVO;
    }

    public EndDestinationVO getEndDestinationVO() {
        return endDestinationVO;
    }

    public MidPointsVO[] getMidPointsVOs() {
        return midPointsVOs;
    }
}

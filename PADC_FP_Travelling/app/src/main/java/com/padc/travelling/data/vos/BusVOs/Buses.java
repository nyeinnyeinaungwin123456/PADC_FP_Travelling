package com.padc.travelling.data.vos.BusVOs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class Buses {

    @SerializedName("company-id")
    private Integer companyId;

    @SerializedName("name")
    private String busName;

    @SerializedName("description")
    private String busDesc;

    @SerializedName("photos")
    private String[] busPhotos;

    @SerializedName("ticketing-outlets")
    private List<TicketOutlets> busTicketOutlet;

    @SerializedName("routes")
    private List<Routes> busRoute;


    public Buses() {
    }

    public Buses(Integer companyId, String busName, String busDesc, String[] busPhotos, List<TicketOutlets> busTicketOutlet, List<Routes> busRoute) {
        this.companyId = companyId;
        this.busName = busName;
        this.busDesc = busDesc;
        this.busPhotos = busPhotos;
        this.busTicketOutlet = busTicketOutlet;
        this.busRoute = busRoute;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getBusName() {
        return busName;
    }

    public String getBusDesc() {
        return busDesc;
    }

    public String[] getBusPhotos() {
        return busPhotos;
    }

    public List<TicketOutlets> getBusTicketOutlet() {
        return busTicketOutlet;
    }

    public List<Routes> getBusRoute() {
        return busRoute;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public void setBusDesc(String busDesc) {
        this.busDesc = busDesc;
    }

    public void setBusPhotos(String[] busPhotos) {
        this.busPhotos = busPhotos;
    }

    public void setBusTicketOutlet(List<TicketOutlets> busTicketOutlet) {
        this.busTicketOutlet = busTicketOutlet;
    }

    public void setBusRoute(List<Routes> busRoute) {
        this.busRoute = busRoute;
    }
}

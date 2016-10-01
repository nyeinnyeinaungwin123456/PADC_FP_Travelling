package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TY on 9/22/2016.
 */
public class BusComponiesVO {

    @SerializedName("company-id")
    private int company_id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("ticketing-outlets")
    private TicketingOutletsVO[] ticketingOutletsVOs;

    @SerializedName("routes")
    private RoutesVO[] routesVOs;

    public BusComponiesVO() {
    }

    public BusComponiesVO(int company_id, String name, String description, String[] photos, TicketingOutletsVO[] ticketingOutletsVOs, RoutesVO[] routesVOs) {
        this.company_id = company_id;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.ticketingOutletsVOs = ticketingOutletsVOs;
        this.routesVOs = routesVOs;
    }

    public int getCompany_id() {
        return company_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getPhotos() {
        return photos;
    }

    public TicketingOutletsVO[] getTicketingOutletsVOs() {
        return ticketingOutletsVOs;
    }

    public RoutesVO[] getRoutesVOs() {
        return routesVOs;
    }
}

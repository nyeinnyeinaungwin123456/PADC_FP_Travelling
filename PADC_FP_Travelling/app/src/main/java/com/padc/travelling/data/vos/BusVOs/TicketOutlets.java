package com.padc.travelling.data.vos.BusVOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class TicketOutlets {

    @SerializedName("outlet-id")
    private Integer outletId;

    @SerializedName("direction-to-outlet")
    private String outletDir;

    @SerializedName("agent-name")
    private String agentName;

    @SerializedName("photos")
    private String outletPhotos;

    @SerializedName("phone-numbers")
    private String[] outletPhone;

    @SerializedName("highway-gate")
    private String outletGate;

    @SerializedName("location")
    private LocationTicketOutlet outletLocation;

    @SerializedName("operating-time")
    private OperationTimeTicketOutlet outletOptime;
}

package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TY on 9/22/2016.
 */
public class TicketingOutletsVO {

    @SerializedName("outlet-id")
    private int outlet_id;

    @SerializedName("direction-to-outlet")
    private String direction_to_outlet;

    @SerializedName("agent-name")
    private String agent_name;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("phone-numbers")
    private String[] phone_numbers;

    @SerializedName("highway-gate")
    private String highway_gate;

    @SerializedName("location")
    private LocationVO locationVO;

    @SerializedName("operating-time")
    private OperatingTimeVO operatingTimeVO;

    public TicketingOutletsVO() {
    }

    public TicketingOutletsVO(int outlet_id, String direction_to_outlet, String agent_name, String[] photos, String[] phone_numbers, String highway_gate, LocationVO locationVO, OperatingTimeVO operatingTimeVO) {
        this.outlet_id = outlet_id;
        this.direction_to_outlet = direction_to_outlet;
        this.agent_name = agent_name;
        this.photos = photos;
        this.phone_numbers = phone_numbers;
        this.highway_gate = highway_gate;
        this.locationVO = locationVO;
        this.operatingTimeVO = operatingTimeVO;
    }

    public int getOutlet_id() {
        return outlet_id;
    }

    public String getDirection_to_outlet() {
        return direction_to_outlet;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public String[] getPhotos() {
        return photos;
    }

    public String[] getPhone_numbers() {
        return phone_numbers;
    }

    public String getHighway_gate() {
        return highway_gate;
    }

    public LocationVO getLocationVO() {
        return locationVO;
    }

    public OperatingTimeVO getOperationTimeVO() {
        return operatingTimeVO;
    }
}

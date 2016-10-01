package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TY on 9/22/2016.
 */
public class StateVO {

    @SerializedName("state-id")
    private long state_id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    public StateVO() {
    }

    public StateVO(long state_id, String name, String description) {
        this.state_id = state_id;
        this.name = name;
        this.description = description;
    }

    public long getState_id() {
        return state_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class StateVO {

    @SerializedName("state-id")
    private long stateId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    public StateVO() {
    }

    public StateVO(long stateId, String name, String description) {
        this.stateId = stateId;
        this.name = name;
        this.description = description;
    }

    public long getStateId() {
        return stateId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

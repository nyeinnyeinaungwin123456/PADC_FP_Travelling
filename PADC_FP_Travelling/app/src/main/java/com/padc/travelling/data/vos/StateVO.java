package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 24-Sep-16.
 */
public class StateVO {

    @SerializedName("state-id")
    private int stateId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    private static StateVO objInstance;

    public StateVO() {
    }

    public static StateVO getInstance(){
        if(objInstance==null){
            objInstance = new StateVO();
        }
        return objInstance;
    }

    public int getStateId() {
        return stateId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

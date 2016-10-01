package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TY on 9/22/2016.
 */
public class CityVO {

    @SerializedName("city-id")
    private long city_id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    public CityVO() {
    }

    public CityVO(long city_id, String name, String description) {
        this.city_id = city_id;
        this.name = name;
        this.description = description;
    }

    public long getCity_id() {
        return city_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

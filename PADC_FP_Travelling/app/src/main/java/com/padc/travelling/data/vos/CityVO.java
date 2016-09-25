package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class CityVO {

    @SerializedName("city-id")
    private long cityId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    public CityVO() {
    }

    public CityVO(long cityId, String name, String description) {
        this.cityId = cityId;
        this.name = name;
        this.description = description;
    }

    public long getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

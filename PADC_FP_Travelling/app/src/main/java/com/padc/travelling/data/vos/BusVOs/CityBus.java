
package com.padc.travelling.data.vos.BusVOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CityBus {

    @SerializedName("city-id")
    @Expose
    private Long cityId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * 
     * @return
     *     The cityId
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 
     * @param cityId
     *     The city-id
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}

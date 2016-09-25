
package com.padc.travelling.data.vos.attractionplaces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StatePlaces {

    @SerializedName("state-id")
    @Expose
    private Long stateId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;

    public StatePlaces() {
    }

    public StatePlaces(Long stateId, String name, String description) {
        this.stateId = stateId;
        this.name = name;
        this.description = description;
    }

    /**
     * 
     * @return
     *     The stateId
     */
    public Long getStateId() {
        return stateId;
    }

    /**
     * 
     * @param stateId
     *     The state-id
     */
    public void setStateId(Long stateId) {
        this.stateId = stateId;
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

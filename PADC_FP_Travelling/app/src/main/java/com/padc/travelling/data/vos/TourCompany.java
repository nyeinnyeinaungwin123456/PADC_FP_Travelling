
package com.padc.travelling.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TourCompany {

    @SerializedName("company-id")
    @Expose
    private Long companyId;
    @SerializedName("company-name")
    @Expose
    private String companyName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("photos")
    @Expose
    private List<String> photos = new ArrayList<String>();
    @SerializedName("phone-numbers")
    @Expose
    private List<String> phoneNumbers = new ArrayList<String>();
    @SerializedName("location")
    @Expose
    private Location location;

    /**
     * 
     * @return
     *     The companyId
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 
     * @param companyId
     *     The company-id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 
     * @return
     *     The companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     * @param companyName
     *     The company-name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    /**
     * 
     * @return
     *     The photos
     */
    public List<String> getPhotos() {
        return photos;
    }

    /**
     * 
     * @param photos
     *     The photos
     */
    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    /**
     * 
     * @return
     *     The phoneNumbers
     */
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * 
     * @param phoneNumbers
     *     The phone-numbers
     */
    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

}

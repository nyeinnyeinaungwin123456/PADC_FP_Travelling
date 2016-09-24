
package com.padc.travelling.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class TourPackage {

    @SerializedName("package-id")
    @Expose
    private Integer packageId;
    @SerializedName("package-name")
    @Expose
    private String packageName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("photos")
    @Expose
//    private List<String> photos = new ArrayList<String>();
    private String[] photos;
    @SerializedName("estimate-price-per-person")
    @Expose
    private Integer estimatePricePerPerson;
    @SerializedName("total-days")
    @Expose
    private String totalDays;
    @SerializedName("sub-destinations")
    @Expose
    private List<SubDestination> subDestinations = new ArrayList<SubDestination>();
    @SerializedName("tour-company")
    @Expose
    private TourCompany tourCompany;

    /**
     * 
     * @return
     *     The packageId
     */
    public Integer getPackageId() {
        return packageId;
    }

    /**
     * 
     * @param packageId
     *     The package-id
     */
    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    /**
     * 
     * @return
     *     The packageName
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * 
     * @param packageName
     *     The package-name
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
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
    public String[] getPhotos() {
        return photos;
    }

    /**
     * 
     * @param photos
     *     The photos
     */
    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    /**
     * 
     * @return
     *     The estimatePricePerPerson
     */
    public Integer getEstimatePricePerPerson() {
        return estimatePricePerPerson;
    }

    /**
     * 
     * @param estimatePricePerPerson
     *     The estimate-price-per-person
     */
    public void setEstimatePricePerPerson(Integer estimatePricePerPerson) {
        this.estimatePricePerPerson = estimatePricePerPerson;
    }

    /**
     * 
     * @return
     *     The totalDays
     */
    public String getTotalDays() {
        return totalDays;
    }

    /**
     * 
     * @param totalDays
     *     The total-days
     */
    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    /**
     * 
     * @return
     *     The subDestinations
     */
    public List<SubDestination> getSubDestinations() {
        return subDestinations;
    }

    /**
     * 
     * @param subDestinations
     *     The sub-destinations
     */
    public void setSubDestinations(List<SubDestination> subDestinations) {
        this.subDestinations = subDestinations;
    }

    /**
     * 
     * @return
     *     The tourCompany
     */
    public TourCompany getTourCompany() {
        return tourCompany;
    }

    /**
     * 
     * @param tourCompany
     *     The tour-company
     */
    public void setTourCompany(TourCompany tourCompany) {
        this.tourCompany = tourCompany;
    }

}

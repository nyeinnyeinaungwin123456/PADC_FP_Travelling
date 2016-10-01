
package com.padc.travelling.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.padc.travelling.data.vos.tourpackageVOs.TourPackage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Example {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("tour-packages")
    @Expose
    private List<TourPackage> tourPackages = new ArrayList<TourPackage>();

    /**
     * 
     * @return
     *     The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The tourPackages
     */
    public List<TourPackage> getTourPackages() {
        return tourPackages;
    }

    /**
     * 
     * @param tourPackages
     *     The tour-packages
     */
    public void setTourPackages(List<TourPackage> tourPackages) {
        this.tourPackages = tourPackages;
    }

}

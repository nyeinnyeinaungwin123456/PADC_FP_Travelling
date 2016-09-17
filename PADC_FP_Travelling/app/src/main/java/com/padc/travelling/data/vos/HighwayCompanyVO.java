package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dellpc on 11-Sep-16.
 */
public class HighwayCompanyVO {

    @SerializedName("busName")
    private String companyTitle;

    @SerializedName("address")
    private String address;

    @SerializedName("phoneNo")
    private String phoneNo;

    @SerializedName("companyImage")
    private Integer companyImage;

    public HighwayCompanyVO() {

    }

    public HighwayCompanyVO(String companyTitle, String address, String phoneNo, Integer companyImage) {
        this.companyTitle = companyTitle;
        this.address = address;
        this.phoneNo = phoneNo;
        this.companyImage = companyImage;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public Integer getCompanyImage() {
        return companyImage;
    }
}

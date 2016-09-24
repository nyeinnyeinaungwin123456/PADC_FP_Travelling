package com.padc.travelling.data.vos;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.R;

/**
 * Created by TY on 9/14/2016.
 */
public class HotelVO {

    @SerializedName("tv_hotel_name")
    private String tvHotelName;

    @SerializedName("iv_hotel_image")
    private Integer ivHotelImage;

    @SerializedName("tv_hotel_address")
    private String tvHotelAddress;

    @SerializedName("tv_hotel_phone")
    private String tvHotelPhone;

    public HotelVO() {
    }

    public HotelVO(String tvHotelName, Integer ivHotelImage, String tvHotelAddress, String tvHotelPhone) {
        this.tvHotelName = tvHotelName;
        this.ivHotelImage = ivHotelImage;
        this.tvHotelAddress = tvHotelAddress;
        this.tvHotelPhone = tvHotelPhone;
    }

    public void setIvHotelImage(Integer ivHotelImage) {
        this.ivHotelImage = ivHotelImage;
    }

    public String getTvHotelName() {
        return tvHotelName;
    }

    public Integer getIvHotelImage() {
        return ivHotelImage;
    }

    public String getTvHotelAddress() {
        return tvHotelAddress;
    }

    public String getTvHotelPhone() {
        return tvHotelPhone;
    }
}

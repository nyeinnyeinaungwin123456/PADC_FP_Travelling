package com.padc.travelling.data.vos;

/**
 * Created by Nyein Nyein on 9/16/2016.
 */
public class RestaurantVO {

    private Integer restaurantImage;
    private String restaurantTile;
    private Integer restaurantImgSetting;

    public RestaurantVO() {
    }

    public RestaurantVO(Integer restaurantImage, String restaurantTile, Integer restaurantImgSetting) {
        this.restaurantImage = restaurantImage;
        this.restaurantTile = restaurantTile;
        this.restaurantImgSetting = restaurantImgSetting;
    }

    public Integer getRestaurantImage() {
        return restaurantImage;
    }

    public String getRestaurantTile() {
        return restaurantTile;
    }

    public Integer getRestaurantImgSetting() {
        return restaurantImgSetting;
    }

    public void setRestaurantImage(Integer restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public void setRestaurantTile(String restaurantTile) {
        this.restaurantTile = restaurantTile;
    }

    public void setRestaurantImgSetting(Integer restaurantImgSetting) {
        this.restaurantImgSetting = restaurantImgSetting;
    }
}

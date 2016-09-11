package com.padc.travelling.data.vos;

/**
 * Created by Nyein Nyein on 9/7/2016.
 */
public class AttractionPlacesVO {

    private Integer subtitle1photo;
    private String subtitle;
    private String subtitle1desc;


    public AttractionPlacesVO() {
    }

    public AttractionPlacesVO(Integer subtitle1photo, String subtitle, String subtitle1desc) {
        this.subtitle1photo = subtitle1photo;
        this.subtitle = subtitle;
        this.subtitle1desc = subtitle1desc;
    }

    public Integer getSubtitle1photo() {
        return subtitle1photo;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getSubtitle1desc() {
        return subtitle1desc;
    }

    public void setSubtitle1photo(Integer subtitle1photo) {
        this.subtitle1photo = subtitle1photo;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setSubtitle1desc(String subtitle1desc) {
        this.subtitle1desc = subtitle1desc;
    }
}

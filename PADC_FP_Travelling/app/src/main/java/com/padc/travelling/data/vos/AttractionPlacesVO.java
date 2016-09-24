package com.padc.travelling.data.vos;

import java.io.Serializable;

/**
 * Created by Nyein Nyein on 9/7/2016.
 */
public class AttractionPlacesVO implements Serializable{

    private Integer subtitle1photo;
    private String subtitle;
    private String subtitle1desc;
    private Integer favourite;
    private Integer share;

    public AttractionPlacesVO() {
    }

    public AttractionPlacesVO(Integer subtitle1photo, String subtitle, String subtitle1desc, Integer favourite, Integer share) {
        this.subtitle1photo = subtitle1photo;
        this.subtitle = subtitle;
        this.subtitle1desc = subtitle1desc;
        this.favourite = favourite;
        this.share = share;
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

    public Integer getFavourite() {
        return favourite;
    }

    public Integer getShare() {
        return share;
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

    public void setFavourite(Integer favourite) {
        this.favourite = favourite;
    }

    public void setShare(Integer share) {
        this.share = share;
    }
}

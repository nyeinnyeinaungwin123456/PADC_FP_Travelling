package com.padc.travelling.data.vos;

/**
 * Created by Nyein Nyein on 9/7/2016.
 */
public class AttractionPlacesVO {

    private Integer titlephoto;
    private String title;
    private String titledesc;
    private Integer subtitle1photo;
    private String subtitle1;
    private String subtitle1desc;
    private Integer subtitle2photo;
    private String subtitle2;
    private String subtitle2desc;

    public AttractionPlacesVO() {
    }

    public AttractionPlacesVO(Integer titlephoto, String title, String titledesc, Integer subtitle1photo, String subtitle1, String subtitle1desc, Integer subtitle2photo, String subtitle2, String subtitle2desc) {
        this.titlephoto = titlephoto;
        this.title = title;
        this.titledesc = titledesc;
        this.subtitle1photo = subtitle1photo;
        this.subtitle1 = subtitle1;
        this.subtitle1desc = subtitle1desc;
        this.subtitle2photo = subtitle2photo;
        this.subtitle2 = subtitle2;
        this.subtitle2desc = subtitle2desc;
    }

    public Integer getTitlephoto() {
        return titlephoto;
    }

    public String getTitle() {
        return title;
    }

    public String getTitledesc() {
        return titledesc;
    }

    public Integer getSubtitle1photo() {
        return subtitle1photo;
    }

    public String getSubtitle1() {
        return subtitle1;
    }

    public String getSubtitle1desc() {
        return subtitle1desc;
    }

    public Integer getSubtitle2photo() {
        return subtitle2photo;
    }

    public String getSubtitle2() {
        return subtitle2;
    }

    public String getSubtitle2desc() {
        return subtitle2desc;
    }

    public void setTitlephoto(Integer titlephoto) {
        this.titlephoto = titlephoto;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitledesc(String titledesc) {
        this.titledesc = titledesc;
    }

    public void setSubtitle1photo(Integer subtitle1photo) {
        this.subtitle1photo = subtitle1photo;
    }

    public void setSubtitle1(String subtitle1) {
        this.subtitle1 = subtitle1;
    }

    public void setSubtitle1desc(String subtitle1desc) {
        this.subtitle1desc = subtitle1desc;
    }

    public void setSubtitle2photo(Integer subtitle2photo) {
        this.subtitle2photo = subtitle2photo;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }

    public void setSubtitle2desc(String subtitle2desc) {
        this.subtitle2desc = subtitle2desc;
    }
}

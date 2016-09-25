package com.padc.travelling.data.vos.attractionplaces;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/25/2016.
 */
public class PlaceCategories {

    @SerializedName("category-id")
    private Long CatId;

    @SerializedName("category-name")
    private String CatName;

    @SerializedName("description")
    private String CatDesc;

    public PlaceCategories() {
    }

    public PlaceCategories(Long catId, String catName, String catDesc) {
        CatId = catId;
        CatName = catName;
        CatDesc = catDesc;
    }

    public Long getCatId() {
        return CatId;
    }

    public String getCatName() {
        return CatName;
    }

    public String getCatDesc() {
        return CatDesc;
    }

    public void setCatId(Long catId) {
        CatId = catId;
    }

    public void setCatName(String catName) {
        CatName = catName;
    }

    public void setCatDesc(String catDesc) {
        CatDesc = catDesc;
    }
}

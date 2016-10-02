package com.padc.travelling.data.vos.attractionplaces;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 9/25/2016.
 */
public class Tags {

    @SerializedName("tag-id")
    private Long tagId;

    @SerializedName("tag-name")
    private String tagName;

    @SerializedName("description")
    private String tagDesc;

    public Tags() {
    }

    public Tags(Long tagId, String tagName, String tagDesc) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDesc = tagDesc;
    }

    public Long getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }
}

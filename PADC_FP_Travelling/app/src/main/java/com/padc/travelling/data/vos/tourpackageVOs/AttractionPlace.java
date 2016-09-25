
package com.padc.travelling.data.vos.tourpackageVOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AttractionPlace {

    @SerializedName("place-id")
    @Expose
    private Integer placeId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private List<String> image = new ArrayList<String>();
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("note-to-visitor")
    @Expose
    private String noteToVisitor;

    /**
     * 
     * @return
     *     The placeId
     */
    public Integer getPlaceId() {
        return placeId;
    }

    /**
     * 
     * @param placeId
     *     The place-id
     */
    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The image
     */
    public List<String> getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(List<String> image) {
        this.image = image;
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
     *     The noteToVisitor
     */
    public String getNoteToVisitor() {
        return noteToVisitor;
    }

    /**
     * 
     * @param noteToVisitor
     *     The note-to-visitor
     */
    public void setNoteToVisitor(String noteToVisitor) {
        this.noteToVisitor = noteToVisitor;
    }

}

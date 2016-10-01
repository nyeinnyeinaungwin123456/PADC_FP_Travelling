
package com.padc.travelling.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SubDestination {

    @SerializedName("destination-id")
    @Expose
    private Long destinationId;

    @SerializedName("destination-title")
    @Expose
    private String destinationTitle;

    @SerializedName("sort-order")
    @Expose
    private Integer sortOrder;

    @SerializedName("destination-photos")
    @Expose
    private List<String> destinationPhotos = new ArrayList<String>();

    @SerializedName("note-to-visitor")
    @Expose
    private String noteToVisitor;

    @SerializedName("location")
    @Expose
    private LocationVO location;

    @SerializedName("attraction-places")
    @Expose
    private List<AttractionPlace> attractionPlaces = new ArrayList<AttractionPlace>();

    /**
     * 
     * @return
     *     The destinationId
     */
    public Long getDestinationId() {
        return destinationId;
    }

    /**
     * 
     * @param destinationId
     *     The destination-id
     */
    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    /**
     * 
     * @return
     *     The destinationTitle
     */
    public String getDestinationTitle() {
        return destinationTitle;
    }

    /**
     * 
     * @param destinationTitle
     *     The destination-title
     */
    public void setDestinationTitle(String destinationTitle) {
        this.destinationTitle = destinationTitle;
    }

    /**
     * 
     * @return
     *     The sortOrder
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 
     * @param sortOrder
     *     The sort-order
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 
     * @return
     *     The destinationPhotos
     */
    public List<String> getDestinationPhotos() {
        return destinationPhotos;
    }

    /**
     * 
     * @param destinationPhotos
     *     The destination-photos
     */
    public void setDestinationPhotos(List<String> destinationPhotos) {
        this.destinationPhotos = destinationPhotos;
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

    /**
     * 
     * @return
     *     The location
     */
    public LocationVO getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(LocationVO location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The attractionPlaces
     */
    public List<AttractionPlace> getAttractionPlaces() {
        return attractionPlaces;
    }

    /**
     * 
     * @param attractionPlaces
     *     The attraction-places
     */
    public void setAttractionPlaces(List<AttractionPlace> attractionPlaces) {
        this.attractionPlaces = attractionPlaces;
    }

}

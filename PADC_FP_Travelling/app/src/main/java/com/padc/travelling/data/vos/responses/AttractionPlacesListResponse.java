package com.padc.travelling.data.vos.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.data.vos.attractionplaces.AttractionPlaces;

import java.util.ArrayList;

/**
 * Created by Nyein Nyein on 9/25/2016.
 */
public class AttractionPlacesListResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("attraction-places")
    private ArrayList<AttractionPlaces> attractionplacesList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<AttractionPlaces> getAttractionPlacesList() {
        return attractionplacesList;
    }
}

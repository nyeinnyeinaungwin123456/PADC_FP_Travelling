package com.padc.travelling.data.vos.attractionplaces;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.persistances.TravelMyanmarContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nyein Nyein on 9/25/2016.
 */
public class AttractionPlaces {

    @SerializedName("place-id")
    private Long placeId;

    @SerializedName("title")
    private String placeTitle;

    @SerializedName("image")
    private String[] placeImage;

    @SerializedName("description")
    private String placeDesc;

    @SerializedName("note-to-visitor")
    private String placeNote;

    @SerializedName("location")
    private LocationPlaces placeLocation;

    @SerializedName("tags")
    private List<Tags> placeTags;

    @SerializedName("operating-time")
    private OperationTimePlaces placeOpTime;

    @SerializedName("place-category")
    private PlaceCategories placeCat;

    public AttractionPlaces() {
    }

    public AttractionPlaces(Long placeId, String placeTitle, String[] placeImage, String placeDesc, String placeNote, LocationPlaces placeLocation, List<Tags> placeTags, OperationTimePlaces placeOpTime, PlaceCategories placeCat) {
        this.placeId = placeId;
        this.placeTitle = placeTitle;
        this.placeImage = placeImage;
        this.placeDesc = placeDesc;
        this.placeNote = placeNote;
        this.placeLocation = placeLocation;
        this.placeTags = placeTags;
        this.placeOpTime = placeOpTime;
        this.placeCat = placeCat;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public String getPlaceTitle() {
        return placeTitle;
    }

    public String[] getPlaceImage() {
        return placeImage;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public String getPlaceNote() {
        return placeNote;
    }

    public LocationPlaces getPlaceLocation() {
        return placeLocation;
    }

    public List<Tags> getPlaceTags() {
        return placeTags;
    }

    public OperationTimePlaces getPlaceOpTime() {
        return placeOpTime;
    }

    public PlaceCategories getPlaceCat() {
        return placeCat;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public void setPlaceTitle(String placeTitle) {
        this.placeTitle = placeTitle;
    }

    public void setPlaceImage(String[] placeImage) {
        this.placeImage = placeImage;
    }

    public void setPlaceDesc(String placeDesc) {
        this.placeDesc = placeDesc;
    }

    public void setPlaceNote(String placeNote) {
        this.placeNote = placeNote;
    }

    public void setPlaceLocation(LocationPlaces placeLocation) {
        this.placeLocation = placeLocation;
    }

    public void setPlaceTags(List<Tags> placeTags) {
        this.placeTags = placeTags;
    }

    public void setPlaceOpTime(OperationTimePlaces placeOpTime) {
        this.placeOpTime = placeOpTime;
    }

    public void setPlaceCat(PlaceCategories placeCat) {
        this.placeCat = placeCat;
    }

    public static void saveAttractions(List<AttractionPlaces> attractionList) {
        Context context = TravellingApp.getContext();
        ContentValues[] attractionCVs = new ContentValues[attractionList.size()];
        for (int index = 0; index < attractionList.size(); index++) {
            AttractionPlaces attraction = attractionList.get(index);
            attractionCVs[index] = attraction.parseToContentValues();

            //Bulk insert into attraction_images.
            AttractionPlaces.saveAttractionImages(attraction.getPlaceTitle(), attraction.getPlaceImage());
        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.AttractionEntry.CONTENT_URI, attractionCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }

    private static void saveAttractionImages(String title, String[] images) {
        ContentValues[] attractionImagesCVs = new ContentValues[images.length];
        for (int index = 0; index < images.length; index++) {
            String image = images[index];

            ContentValues cv = new ContentValues();
            cv.put(TravelMyanmarContract.AttractionImageEntry.COLUMN_ATTRACTION_TITLE, title);
            cv.put(TravelMyanmarContract.AttractionImageEntry.COLUMN_IMAGE, image);

            attractionImagesCVs[index] = cv;
        }

        Context context = TravellingApp.getContext();
        int insertCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.AttractionImageEntry.CONTENT_URI, attractionImagesCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction_images table : " + insertCount);
    }

    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(TravelMyanmarContract.AttractionEntry.COLUMN_TITLE, placeTitle);
        cv.put(TravelMyanmarContract.AttractionEntry.COLUMN_DESC, placeDesc);
        return cv;
    }

    public static AttractionPlaces parseFromCursor(Cursor data) {
        AttractionPlaces attraction = new AttractionPlaces();
        attraction.placeTitle = data.getString(data.getColumnIndex(TravelMyanmarContract.AttractionEntry.COLUMN_TITLE));
        attraction.placeDesc = data.getString(data.getColumnIndex(TravelMyanmarContract.AttractionEntry.COLUMN_DESC));
        return attraction;
    }

    public static String[] loadAttractionImagesByTitle(String title) {
        Context context = TravellingApp.getContext();
        ArrayList<String> images = new ArrayList<>();

        Cursor cursor = context.getContentResolver().query(TravelMyanmarContract.AttractionImageEntry.buildAttractionImageUriWithTitle(title),
                null, null, null, null);

        if(cursor != null && cursor.moveToFirst()) {
            do {
                images.add(cursor.getString(cursor.getColumnIndex(TravelMyanmarContract.AttractionImageEntry.COLUMN_IMAGE)));
            } while (cursor.moveToNext());
        }

        String[] imageArray = new String[images.size()];
        images.toArray(imageArray);
        return imageArray;
    }
}

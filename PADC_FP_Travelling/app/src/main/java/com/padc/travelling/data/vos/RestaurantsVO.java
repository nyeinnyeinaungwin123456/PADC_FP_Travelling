package com.padc.travelling.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.persistances.TravelMyanmarContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class RestaurantsVO {

    @SerializedName("restaurant-id")
    private long restaurantId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("note-to-visitor")
    private String noteToVisitor;

    @SerializedName("location")
    private LocationVO location;

    @SerializedName("operating-time")
    private OperatingTimeVO operatingTime;

    public RestaurantsVO() {
    }

    public RestaurantsVO(long restaurantId, String name, String description, String[] photos, String noteToVisitor, LocationVO location, OperatingTimeVO operatingTime) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.noteToVisitor = noteToVisitor;
        this.location = location;
        this.operatingTime = operatingTime;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getPhotos() {
        return photos;
    }

    public String getNoteToVisitor() {
        return noteToVisitor;
    }

    public LocationVO getLocation() {
        return location;
    }

    public OperatingTimeVO getOperatingTime() {
        return operatingTime;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    public void setNoteToVisitor(String noteToVisitor) {
        this.noteToVisitor = noteToVisitor;
    }

    public void setLocation(LocationVO location) {
        this.location = location;
    }

    public void setOperatingTime(OperatingTimeVO operatingTime) {
        this.operatingTime = operatingTime;
    }

    public static void saveRestaurant(List<RestaurantsVO> restaurantList) {
        Context context = TravellingApp.getContext();
        ContentValues[] restaurantCVs = new ContentValues[restaurantList.size()];
        for (int index = 0; index < restaurantList.size(); index++) {
            RestaurantsVO restaurant = restaurantList.get(index);
            restaurantCVs[index] = restaurant.parseToContentValues();

            //Bulk insert into attraction_images.
            RestaurantsVO.saveRestaurantImage(restaurant.getName(), restaurant.getPhotos());
        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.RestaurantEntry.CONTENT_URI, restaurantCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }

    private static void saveRestaurantImage(String name, String[] photos) {
        ContentValues[] restaurantImagesCVs = new ContentValues[photos.length];
        for (int index = 0; index < photos.length; index++) {
            String image = photos[index];

            ContentValues cv = new ContentValues();
            cv.put(TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_RESTAURANT_NAME, name);
            cv.put(TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_PHOTOS, image);

            restaurantImagesCVs[index] = cv;
        }

        Context context = TravellingApp.getContext();
        int insertCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.RestaurantPhotoEntry.CONTENT_URI, restaurantImagesCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction_images table : " + insertCount);
    }

    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(TravelMyanmarContract.RestaurantEntry.COLUMN_NAME, name);
        cv.put(TravelMyanmarContract.RestaurantEntry.COLUMN_DESC, description);

        return cv;
    }

    public static RestaurantsVO parseFromCursor(Cursor data) {
        RestaurantsVO restaurant = new RestaurantsVO();
        restaurant.name = data.getString(data.getColumnIndex(TravelMyanmarContract.RestaurantEntry.COLUMN_NAME));
        restaurant.description = data.getString(data.getColumnIndex(TravelMyanmarContract.RestaurantEntry.COLUMN_DESC));

        return restaurant;
    }

    public static String[] loadRestaurantPhotobyName(String name) {
        Context context = TravellingApp.getContext();
        ArrayList<String> images = new ArrayList<>();

        Cursor cursor = context.getContentResolver().query(TravelMyanmarContract.RestaurantPhotoEntry.buildRestaurantPhotoUriWithName(name),
                null, null, null, null);

        if(cursor != null && cursor.moveToFirst()) {
            do {
                images.add(cursor.getString(cursor.getColumnIndex(TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_PHOTOS)));
            } while (cursor.moveToNext());
        }

        String[] imageArray = new String[images.size()];
        images.toArray(imageArray);
        return imageArray;
    }

}

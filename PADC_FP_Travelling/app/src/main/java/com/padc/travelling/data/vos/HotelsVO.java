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
 * Created by TY on 9/22/2016.
 */
public class HotelsVO {

    @SerializedName("hotel-id")
    private int hotel_id;

    @SerializedName("hotel-name")
    private String hotel_name;

    @SerializedName("description")
    private String description;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("direction-to-hotel")
    private String direction_to_hotel;

    @SerializedName("phone-numbers")
    private String[] phoneNumbers;

    @SerializedName("location")
    private LocationVO locationVO;

    public HotelsVO() {
    }

    public HotelsVO(int hotel_id, String hotel_name, String description, String[] photos, String direction_to_hotel, String[] phoneNumbers, LocationVO locationVO) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.description = description;
        this.photos = photos;
        this.direction_to_hotel = direction_to_hotel;
        this.phoneNumbers = phoneNumbers;
        this.locationVO = locationVO;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getPhotos() {
        return photos;
    }

    public String getDirection_to_hotel() {
        return direction_to_hotel;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public LocationVO getLocationVO() {
        return locationVO;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    public void setDirection_to_hotel(String direction_to_hotel) {
        this.direction_to_hotel = direction_to_hotel;
    }

    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setLocationVO(LocationVO locationVO) {
        this.locationVO = locationVO;
    }

    public static void saveHotels(List<HotelsVO> hotelList) {
        Context context = TravellingApp.getContext();
        ContentValues[] hotelCVs = new ContentValues[hotelList.size()];
        for (int index = 0; index < hotelList.size(); index++) {
            HotelsVO hotel = hotelList.get(index);
            hotelCVs[index] = hotel.parseToContentValues();

            //Bulk insert into attraction_images.
            HotelsVO.saveHotelImages(hotel.getHotel_name(), hotel.getPhotos());
        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.HotelEntry.CONTENT_URI, hotelCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }

    private static void saveHotelImages(String name, String[] images) {
        ContentValues[] hotelphotoCVs = new ContentValues[images.length];
        for (int index = 0; index < images.length; index++) {
            String image = images[index];

            ContentValues cv = new ContentValues();
            cv.put(TravelMyanmarContract.HotelPhotosEntry.COLUMN_HOTEL_NAME, name);
            cv.put(TravelMyanmarContract.HotelPhotosEntry.COLUMN_PHOTOS, image);

            hotelphotoCVs[index] = cv;
        }

        Context context = TravellingApp.getContext();
        int insertCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.HotelPhotosEntry.CONTENT_URI, hotelphotoCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction_images table : " + insertCount);
    }

    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(TravelMyanmarContract.HotelEntry.COLUMN_NAME, hotel_name);
        cv.put(TravelMyanmarContract.HotelEntry.COLUMN_DESC, description);
        return cv;
    }

    public static HotelsVO parseFromCursor(Cursor data) {
        HotelsVO hotel = new HotelsVO();
        hotel.hotel_name = data.getString(data.getColumnIndex(TravelMyanmarContract.HotelEntry.COLUMN_NAME));
        hotel.description = data.getString(data.getColumnIndex(TravelMyanmarContract.HotelEntry.COLUMN_DESC));
        return hotel;
    }

    public static String[] loadHotelPhotoByTitle(String title) {
        Context context = TravellingApp.getContext();
        ArrayList<String> images = new ArrayList<>();

        Cursor cursor = context.getContentResolver().query(TravelMyanmarContract.HotelPhotosEntry.buildHotelPhotosUriWithName(title),
                null, null, null, null);

        if(cursor != null && cursor.moveToFirst()) {
            do {
                images.add(cursor.getString(cursor.getColumnIndex(TravelMyanmarContract.HotelPhotosEntry.COLUMN_PHOTOS)));
            } while (cursor.moveToNext());
        }

        String[] imageArray = new String[images.size()];
        images.toArray(imageArray);
        return imageArray;
    }
}

package com.padc.travelling.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.persistances.TravelMyanmarContract;

import java.util.List;

/**
 * Created by TY on 9/22/2016.
 */
public class EndDestinationVO {

    @SerializedName("destination-id")
    private int destination_id;

    @SerializedName("destination-title")
    private String destination_title;

    @SerializedName("destination-photos")
    private String[] destination_photos;

    @SerializedName("time-markers")
    private TimeMakersVO timeMakersVO;

    public EndDestinationVO() {
    }

    public EndDestinationVO(int destination_id, String destination_title, String[] destination_photos, TimeMakersVO timeMakersVO) {
        this.destination_id = destination_id;
        this.destination_title = destination_title;
        this.destination_photos = destination_photos;
        this.timeMakersVO = timeMakersVO;
    }

    public int getDestination_id() {
        return destination_id;
    }

    public String getDestination_title() {
        return destination_title;
    }

    public String[] getDestination_photos() {
        return destination_photos;
    }

    public TimeMakersVO getTimeMakersVO() {
        return timeMakersVO;
    }

    public void setDestination_id(int destination_id) {
        this.destination_id = destination_id;
    }

    public void setDestination_title(String destination_title) {
        this.destination_title = destination_title;
    }

    public void setDestination_photos(String[] destination_photos) {
        this.destination_photos = destination_photos;
    }

    public void setTimeMakersVO(TimeMakersVO timeMakersVO) {
        this.timeMakersVO = timeMakersVO;
    }

    public static void saveEndDestination(List<EndDestinationVO> endList) {
        Context context = TravellingApp.getContext();
        ContentValues[] endCVs = new ContentValues[endList.size()];
        for (int index = 0; index < endList.size(); index++) {
            EndDestinationVO end = endList.get(index);
            endCVs[index] = end.parseToContentValues();

            //Bulk insert into attraction_images.
//            AttractionPlaces.saveAttractionImages(attraction.getPlaceTitle(), attraction.getPlaceImage());
        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.EndDestinationEntry.CONTENT_URI, endCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }


    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(TravelMyanmarContract.EndDestinationEntry.COLUMN_HIGHWAY_NAME, destination_title);
//        cv.put(TravelMyanmarContract.StartDestinationEntry.COLUMN_PRICE, price);

        return cv;
    }

    public static EndDestinationVO parseFromCursor(Cursor data) {
        EndDestinationVO end = new EndDestinationVO();
        end.destination_title = data.getString(data.getColumnIndex(TravelMyanmarContract.EndDestinationEntry.COLUMN_HIGHWAY_NAME));
//        route.price = data.getInt(data.getColumnIndex(TravelMyanmarContract.HighwayRouteEntry.COLUMN_PRICE));
        return end;
    }
}

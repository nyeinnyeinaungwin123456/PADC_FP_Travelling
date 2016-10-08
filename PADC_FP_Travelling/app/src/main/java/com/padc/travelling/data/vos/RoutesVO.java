package com.padc.travelling.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.persistances.TravelMyanmarContract;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TY on 9/22/2016.
 */
public class RoutesVO implements Serializable{

    @SerializedName("route_id")
    private int route_id;

    @SerializedName("route_title")
    private String route_title;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("price")
    private int price;

    @SerializedName("start-destination")
    private StartDestinationVO startDestinationVO;

    @SerializedName("end-destination")
    private EndDestinationVO endDestinationVO;

    @SerializedName("mid-points")
    private MidPointsVO[] midPointsVOs;



    public RoutesVO() {
    }

    public RoutesVO(int route_id, String route_title, String[] photos, int price, StartDestinationVO startDestinationVO, EndDestinationVO endDestinationVO, MidPointsVO[] midPointsVOs) {
        this.route_id = route_id;
        this.route_title = route_title;
        this.photos = photos;
        this.price = price;
        this.startDestinationVO = startDestinationVO;
        this.endDestinationVO = endDestinationVO;
        this.midPointsVOs = midPointsVOs;
    }

    public int getRoute_id() {
        return route_id;
    }

    public String getRoute_title() {
        return route_title;
    }

    public String[] getPhotos() {
        return photos;
    }

    public int getPrice() {
        return price;
    }

    public StartDestinationVO getStartDestinationVO() {
        return startDestinationVO;
    }

    public EndDestinationVO getEndDestinationVO() {
        return endDestinationVO;
    }

    public MidPointsVO[] getMidPointsVOs() {
        return midPointsVOs;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public void setRoute_title(String route_title) {
        this.route_title = route_title;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStartDestinationVO(StartDestinationVO startDestinationVO) {
        this.startDestinationVO = startDestinationVO;
    }

    public void setEndDestinationVO(EndDestinationVO endDestinationVO) {
        this.endDestinationVO = endDestinationVO;
    }

    public void setMidPointsVOs(MidPointsVO[] midPointsVOs) {
        this.midPointsVOs = midPointsVOs;
    }

    public static void saveRoutes(String name, List<RoutesVO> routeList) {
        Context context = TravellingApp.getContext();
        ContentValues[] routeCVs = new ContentValues[routeList.size()];
        for (int index = 0; index < routeList.size(); index++) {
            RoutesVO route = routeList.get(index);

            ContentValues cv = route.parseToContentValues();
            cv.put(TravelMyanmarContract.HighwayRouteEntry.COLUMN_HIGHWAY_NAME,name);

            routeCVs[index] = cv;

            //Bulk insert into attraction_images.
//            AttractionPlaces.saveAttractionImages(attraction.getPlaceTitle(), attraction.getPlaceImage());
        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.HighwayRouteEntry.CONTENT_URI, routeCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }


    private ContentValues parseToContentValues() {
        BusComponiesVO buscompany = new BusComponiesVO();
        ContentValues cv = new ContentValues();
        cv.put(TravelMyanmarContract.HighwayRouteEntry.COLUMN_HIGHWAY_NAME,buscompany.getName());
        cv.put(TravelMyanmarContract.HighwayRouteEntry.COLUMN_PRICE, price);

        return cv;
    }

    public static RoutesVO parseFromCursor(Cursor data) {
        RoutesVO route = new RoutesVO();
        route.route_title = data.getString(data.getColumnIndex(TravelMyanmarContract.HighwayRouteEntry.COLUMN_HIGHWAY_NAME));
        route.price = data.getInt(data.getColumnIndex(TravelMyanmarContract.HighwayRouteEntry.COLUMN_PRICE));
        return route;
    }

//    public static StartDestinationVO loadStartDestinationbyName(String name) {
//        Context context = TravellingApp.getContext();
//        StartDestinationVO start = new StartDestinationVO();
//
//        Cursor cursor = context.getContentResolver().query(TravelMyanmarContract.StartDestinationEntry.buildStartDestinationUriWithName(name),
//                null, null, null, null);
//
//        if(cursor != null && cursor.moveToFirst()) {
//            do {
//                start.(cursor.getString(cursor.getColumnIndex(TravelMyanmarContract.StartDestinationEntry.COLUMN_HIGHWAY_NAME)));
//            } while (cursor.moveToNext());
//        }
//
//
//        return start;
//    }
}

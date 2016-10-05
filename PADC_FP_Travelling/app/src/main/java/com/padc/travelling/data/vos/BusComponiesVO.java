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

import okhttp3.Route;

/**
 * Created by TY on 9/22/2016.
 */
public class BusComponiesVO {

    @SerializedName("company-id")
    private int company_id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("photos")
    private String[] photos;

    @SerializedName("ticketing-outlets")
    private TicketingOutletsVO[] ticketingOutletsVOs;

    @SerializedName("routes")
    private RoutesVO[] routesVOs;
//    private List<RoutesVO> routesVOList = new ArrayList<>();

    public static BusComponiesVO mBusCompany;

    public BusComponiesVO() {
    }

    public BusComponiesVO(int company_id, String name, String description, String[] photos, TicketingOutletsVO[] ticketingOutletsVOs, RoutesVO[] routesVOs) {
        this.company_id = company_id;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.ticketingOutletsVOs = ticketingOutletsVOs;
        this.routesVOs = routesVOs;
    }

    public int getCompany_id() {
        return company_id;
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

    public TicketingOutletsVO[] getTicketingOutletsVOs() {
        return ticketingOutletsVOs;
    }

    public RoutesVO[] getRoutesVOs() {
        return routesVOs;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
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

    public void setTicketingOutletsVOs(TicketingOutletsVO[] ticketingOutletsVOs) {
        this.ticketingOutletsVOs = ticketingOutletsVOs;
    }

    public void setRoutesVOs(RoutesVO[] routesVOs) {
        this.routesVOs = routesVOs;
    }

    public static void saveBusCompany(List<BusComponiesVO> buscompanyList) {
        Context context = TravellingApp.getContext();
        ContentValues[] buscompanyCVs = new ContentValues[buscompanyList.size()];
        for (int index = 0; index < buscompanyList.size(); index++) {
            BusComponiesVO buscompany = buscompanyList.get(index);
            buscompanyCVs[index] = buscompany.parseToContentValues();

            RoutesVO route = new RoutesVO();
            List<RoutesVO> routesVOList = new ArrayList<>();
            RoutesVO[] data = buscompany.getRoutesVOs();
            for(int i=0;i<data.length;i++){
                routesVOList.add(data[i]);
            }
//            List<RoutesVO> routeList = BusComponiesModel.getInstance().getRoutesVOList();
//            List<RoutesVO> routeList = new ArrayList<>();

            //Bulk insert into attraction_images.
            BusComponiesVO.saveBusCompanyImages(buscompany.getName(), buscompany.getPhotos());
//            BusComponiesVO.saveRoute(buscompany.getName(), buscompany.getRoutesVOs());
            route.saveRoutes(routesVOList);
        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.HighwayBusEntry.CONTENT_URI, buscompanyCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }


    private static void saveBusCompanyImages(String name, String[] photos) {
        ContentValues[] buscompanyImagesCVs = new ContentValues[photos.length];
        for (int index = 0; index < photos.length; index++) {
            String photo = photos[index];

            ContentValues cv = new ContentValues();
            cv.put(TravelMyanmarContract.HighwayPhotoEntry.COLUMN_HIGHWAY_NAME, name);
            cv.put(TravelMyanmarContract.HighwayPhotoEntry.COLUMN_PHOTOS, photo);

            buscompanyImagesCVs[index] = cv;
        }

        Context context = TravellingApp.getContext();
        int insertCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.HighwayPhotoEntry.CONTENT_URI, buscompanyImagesCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction_images table : " + insertCount);
    }


//    private static void saveRoute(List<RoutesVO> routeList) {
//        Context context = TravellingApp.getContext();
//        ContentValues[] routeCVs = new ContentValues[routeList.size()];
//        for (int index = 0; index < routeList.size(); index++) {
//            RoutesVO route = routeList.get(index);
//            routeCVs[index] = route.par();
//
//        }

//        Context contextroute = TravellingApp.getContext();
//        int insertCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.HighwayPhotoEntry.CONTENT_URI, routeCVs);
//
//        Log.d(TravellingApp.TAG, "Bulk inserted into attraction_images table : " + insertCount);
//    }

//    private ContentValues parseToContentValuesForRoute() {
//        ContentValues cv = new ContentValues();
//        cv.put(TravelMyanmarContract.HighwayRouteEntry.COLUMN_PRICE, name);
////        cv.put(TravelMyanmarContract.HighwayBusEntry.COLUMN_DESC, description);
//        return cv;
//    }

    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(TravelMyanmarContract.HighwayBusEntry.COLUMN_NAME, name);
        cv.put(TravelMyanmarContract.HighwayBusEntry.COLUMN_DESC, description);
        return cv;
    }

    public static BusComponiesVO parseFromCursor(Cursor data) {
        BusComponiesVO buscompany = new BusComponiesVO();
        buscompany.name = data.getString(data.getColumnIndex(TravelMyanmarContract.HighwayBusEntry.COLUMN_NAME));
        buscompany.description = data.getString(data.getColumnIndex(TravelMyanmarContract.HighwayBusEntry.COLUMN_DESC));
//        buscompany.routesVOs = data.getString(String.valueOf(data.getColumnIndex(TravelMyanmarContract.HighwayBusEntry.COLUMN_ROUTE)));
        return buscompany;
    }

    public static String[] loadBusCompanyPhotosByName(String name) {
        Context context = TravellingApp.getContext();
        ArrayList<String> images = new ArrayList<>();

        Cursor cursor = context.getContentResolver().query(TravelMyanmarContract.HighwayPhotoEntry.buildHighwayPhotoUriWithName(name),
                null, null, null, null);

        if(cursor != null && cursor.moveToFirst()) {
            do {
                images.add(cursor.getString(cursor.getColumnIndex(TravelMyanmarContract.HighwayPhotoEntry.COLUMN_PHOTOS)));
            } while (cursor.moveToNext());
        }

        String[] imageArray = new String[images.size()];
        images.toArray(imageArray);
        return imageArray;
    }

    public static String[] loadRouteByName(String name) {
        Context context = TravellingApp.getContext();
        ArrayList<String> route = new ArrayList<>();

        Cursor cursor = context.getContentResolver().query(TravelMyanmarContract.HighwayRouteEntry.buildHighwayRouteUriWithName(name),
                null, null, null, null);

        if(cursor != null && cursor.moveToFirst()) {
            do {
                route.add(cursor.getString(cursor.getColumnIndex(TravelMyanmarContract.HighwayRouteEntry.COLUMN_ROUTE)));
            } while (cursor.moveToNext());
        }

        String[] routeArray = new String[route.size()];
        route.toArray(routeArray);
        return routeArray;
    }
}

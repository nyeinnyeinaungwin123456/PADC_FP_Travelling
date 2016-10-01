package com.padc.travelling.data.vos.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.events.DataEvent;
import com.padc.travelling.data.vos.persistances.TravelMyanmarContract;
import com.padc.travelling.data.vos.tourpackageVOs.TourPackage;
import com.padc.travelling.utils.TravellingConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.greenrobot.event.EventBus;

//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.EventBus;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class TourPackageModel extends BaseModel {

    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    public List<TourPackage> tourpackageVOList;
//    public List<Tour> attractionplacesVOList;
    private static TourPackageModel tourpackageModel;
//    public static final String DUMMY_ATTRACTION_LIST = "myanmar_attractions.json";

    public TourPackageModel(){
        super();
        tourpackageVOList = new ArrayList<>();
        dataAgent.loadTourPackage();
    }


    public static TourPackageModel getInstance() {

        if(tourpackageModel==null) {
            tourpackageModel = new TourPackageModel();
        }
        return tourpackageModel;
    }

    //TourPackage List
    public List<TourPackage> getTourPackageList() {

        return tourpackageVOList;

    }

    public void setStoredData(List<TourPackage> tourpackageList) {
        tourpackageVOList = tourpackageList;
    }




    public TourPackage getTourPackageByName(String tourpackageName) {
        for (TourPackage tourpackage : tourpackageVOList) {
            if (tourpackage.getPackageName().equals(tourpackageName)) {
                return tourpackage;
            }
        }
        return null;
    }

    public void notifyErrorInLoadingTravel(String message) {

    }

    public void notifyTourPackageLoaded(List<TourPackage> tourpackageList) {
        //Notify that the data is ready - using LocalBroadcast
        tourpackageVOList = tourpackageList;
        TourPackage.saveTourPackage(tourpackageVOList);
//        broadcastTourpackageLoadedWithEventBus();
        //keep the data in persistent layer.
//        MealOrderVO.saveAttractions(mAttractionList);

    }

    public String getRandomAttractionImage() {
        if (tourpackageVOList == null || tourpackageVOList.size() == 0) {
            return null;
        }

        Random random = new Random();
        int randomInt = random.nextInt(tourpackageVOList.size());

        TourPackage tourpackage = tourpackageVOList.get(randomInt);
        return TravellingConstants.IMAGE_ROOT_TOURPACKAGE + tourpackage.getPhotos()[tourpackage.getPhotos().length - 1];
    }


    private void broadcastAttractionLoadedWithLocalBroadcastManager() {
        Intent intent = new Intent(BROADCAST_DATA_LOADED);
        intent.putExtra("key-for-extra", "extra-in-broadcast");
        LocalBroadcastManager.getInstance(TravellingApp.getContext()).sendBroadcast(intent);
    }

    private void broadcastTourpackageLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.TourPackageDataLoadedEvent("extra-in-broadcast", tourpackageVOList));
    }

    public List<TourPackage> getTourPackageVOList(){
        return tourpackageVOList;
    }

}

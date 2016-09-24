package com.padc.travelling.data.vos.model;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.events.DataEvent;
import com.padc.travelling.data.vos.TourPackage;

import java.util.ArrayList;
import java.util.List;

//import de.greenrobot.event.EventBus;

import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.EventBus;

/**
 * Created by Nyein Nyein on 9/24/2016.
 */
public class TourPackageModel extends BaseModel {

    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    public List<TourPackage> tourpackageVOList;
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

    public List<TourPackage> getTourPackageList() {

        return tourpackageVOList;

    }

    public TourPackage getTourPackageByName(String tourpackageName) {
        for (TourPackage tourpackage : tourpackageVOList) {
            if (tourpackage.getPackageName().equals(tourpackageName)) {
                return tourpackage;
            }
        }
        return null;
    }

    public void notifyErrorInLoadingAttractions(String message) {

    }

    public void notifyTourPackageLoaded(List<TourPackage> tourpackageList) {
        //Notify that the data is ready - using LocalBroadcast
        tourpackageVOList = tourpackageList;
        broadcastAttractionLoadedWithEventBus();
        //keep the data in persistent layer.
//        MealOrderVO.saveAttractions(mAttractionList);

    }

//        private List<MealOrderVO> initializeMealOrderList(){
//
//        List<MealOrderVO> mealorderList = new ArrayList<>();
//
//        try{
//            String dummyAttractiontList = JsonUtils.getInstance().loadDummyData(DUMMY_ATTRACTION_LIST);
//            Type listType = new TypeToken<List<AttractionVO>>() {
//            }.getType();
//
//            attractList = CommonInstances.getGsonInstance().fromJson(dummyAttractiontList, listType);
//        }catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return attractList;
//    }

    private void broadcastAttractionLoadedWithLocalBroadcastManager() {
        Intent intent = new Intent(BROADCAST_DATA_LOADED);
        intent.putExtra("key-for-extra", "extra-in-broadcast");
        LocalBroadcastManager.getInstance(TravellingApp.getContext()).sendBroadcast(intent);
    }

    private void broadcastAttractionLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.TourPackageDataLoadedEvent("extra-in-broadcast", tourpackageVOList));
    }

    public List<TourPackage> getTourPackageVOList(){
        return tourpackageVOList;
    }

}

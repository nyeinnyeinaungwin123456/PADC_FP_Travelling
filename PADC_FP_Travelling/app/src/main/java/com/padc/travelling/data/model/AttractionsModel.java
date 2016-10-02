package com.padc.travelling.data.model;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.attractionplaces.AttractionPlaces;
import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.utils.TravellingConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.greenrobot.event.EventBus;

/**
 * Created by Nyein Nyein on 9/25/2016.
 */
public class AttractionsModel extends BaseModel {

    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    public List<AttractionPlaces> attractionplacesVOList;
    private static AttractionsModel attractionModel;
//    public static final String DUMMY_ATTRACTION_LIST = "myanmar_attractions.json";

    public AttractionsModel(){
        super();
        attractionplacesVOList = new ArrayList<>();
//        dataAgent.loadAttractionPlaces();
        loadAttractions();
    }


    public static AttractionsModel getInstance() {

        if(attractionModel==null) {
            attractionModel = new AttractionsModel();
        }
        return attractionModel;
    }

    public void loadAttractions() {
        dataAgent.loadAttraction();
    }

    //AttractionPlaces List
    public List<AttractionPlaces> getAttractionPLacesList() {

        return attractionplacesVOList;

    }

    public void setStoredData(List<AttractionPlaces> attractionList) {
        attractionplacesVOList = attractionList;
    }

    public AttractionPlaces getAttractionPlacesByTitle(String attractionplacesName) {
        for (AttractionPlaces attractionplaces : attractionplacesVOList) {
            if (attractionplaces.getPlaceTitle().equals(attractionplacesName)) {
                return attractionplaces;
            }
        }
        return null;
    }

    public void notifyErrorInLoadingTravel(String message) {

    }

    public void notifyAttractionPlacesLoaded(List<AttractionPlaces> attractionplacesList) {
        //Notify that the data is ready - using LocalBroadcast
        attractionplacesVOList = attractionplacesList;
        AttractionPlaces.saveAttractions(attractionplacesVOList);
//        broadcastAttractionPlacesLoadedWithEventBus();
        //keep the data in persistent layer.
//        MealOrderVO.saveAttractions(mAttractionList);

    }


    public String getRandomAttractionImage() {
        if (attractionplacesVOList == null || attractionplacesVOList.size() == 0) {
            return null;
        }

        Random random = new Random();
        int randomInt = random.nextInt(attractionplacesVOList.size());

        AttractionPlaces attraction = attractionplacesVOList.get(randomInt);
        return TravellingConstants.IMAGE_ROOT_ATTRACTION + attraction.getPlaceImage()[attraction.getPlaceImage().length - 1];
    }

    private void broadcastAttractionLoadedWithLocalBroadcastManager() {
        Intent intent = new Intent(BROADCAST_DATA_LOADED);
        intent.putExtra("key-for-extra", "extra-in-broadcast");
        LocalBroadcastManager.getInstance(TravellingApp.getContext()).sendBroadcast(intent);
    }

    private void broadcastAttractionPlacesLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.AttractionPlacesDataLoadedEvent("extra-in-broadcast", attractionplacesVOList));
    }

    public List<AttractionPlaces> getAttractionPlacesVOList(){
        return attractionplacesVOList;
    }

}

package com.padc.travelling.data.model;

import com.padc.travelling.data.vos.HotelsVO;
import com.padc.travelling.data.events.DataEvent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class HotelsModel extends BaseModel {

    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    public List<HotelsVO> hotelsVOList;
    private static HotelsModel hotelsModel;

    public HotelsModel() {
        super();
        hotelsVOList = new ArrayList<>();
        dataAgent.loadHotels();
    }

    public static HotelsModel getInstance() {

        if(hotelsModel==null) {
            hotelsModel = new HotelsModel();
        }
        return hotelsModel;
    }

    public List<HotelsVO> getHotelsList() {
        return hotelsVOList;
    }

    public HotelsVO getHotelsByName(String hotelsName) {
        for (HotelsVO hotels : hotelsVOList) {
            if (hotels.getHotel_name().equals(hotelsName)) {
                return hotels;
            }
        }
        return null;
    }

    public void notifyErrorInLoadingHotels(String message) {

    }

    public void notifyHotelsLoaded(List<HotelsVO> hotelsList) {
        //Notify that the data is ready - using LocalBroadcast
        hotelsVOList = hotelsList;
        broadcastAttractionLoadedWithEventBus();
    }

    /*private void broadcastAttractionLoadedWithLocalBroadcastManager() {
        Intent intent = new Intent(BROADCAST_DATA_LOADED);
        intent.putExtra("key-for-extra", "extra-in-broadcast");
        LocalBroadcastManager.getInstance(TravellingApp.getContext()).sendBroadcast(intent);
    }*/

    private void broadcastAttractionLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.HotelsDataLoadedEvent("extra-in-broadcast", hotelsVOList));
    }

    public List<HotelsVO> getHotelsVOList() {
        return hotelsVOList;
    }
}

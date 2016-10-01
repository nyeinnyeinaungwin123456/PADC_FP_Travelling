package com.padc.travelling.data.vos.model;

import com.padc.travelling.data.vos.BusComponiesVO;
import com.padc.travelling.data.vos.events.DataEvent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by TY on 9/27/2016.
 */
public class BusComponiesModel extends BaseModel{

    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    public List<BusComponiesVO> busComponiesVOList;
    private static BusComponiesModel busComponiesModel;

    public BusComponiesModel() {
        super();
        busComponiesVOList = new ArrayList<>();
        dataAgent.loadBusComponies();
    }

    public static BusComponiesModel getInstance() {

        if(busComponiesModel==null) {
            busComponiesModel = new BusComponiesModel();
        }
        return busComponiesModel;
    }

    public List<BusComponiesVO> getBusComponiesVOList() {
        return busComponiesVOList;
    }

    public void notifyErrorInLoadingBusComponies(String message) {

    }

    public void notifyBusComponiesLoaded(List<BusComponiesVO> mBusComponiesVOList) {

        //Notify that the data is ready - using LocalBroadcast

        busComponiesVOList = mBusComponiesVOList;
        broadcastBusComponiesLoadedWithEventBus();
    }

    private void broadcastBusComponiesLoadedWithEventBus() {

        EventBus.getDefault().post(new DataEvent.BusComponiesDataLoadedEvent("extra-in-broadcast", busComponiesVOList));
    }
}

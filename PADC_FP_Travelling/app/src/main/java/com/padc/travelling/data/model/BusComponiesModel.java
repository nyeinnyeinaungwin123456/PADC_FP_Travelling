package com.padc.travelling.data.model;

import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.data.vos.BusComponiesVO;
import com.padc.travelling.data.vos.RoutesVO;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by TY on 9/27/2016.
 */
public class BusComponiesModel extends BaseModel{

    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    public List<BusComponiesVO> busComponiesVOList;
    public List<RoutesVO> routeVOList;
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

    public void setStoredData(List<BusComponiesVO> buscompanyList) {
        busComponiesVOList = buscompanyList;
    }

    public List<RoutesVO> getRoutesVOList() {
        return routeVOList;
    }

    public void setStoredDataRoute(List<RoutesVO> routeList) {
        routeVOList = routeList;
    }

    public void notifyErrorInLoadingBusComponies(String message) {

    }

    public void notifyBusComponiesLoaded(List<BusComponiesVO> mBusComponiesVOList) {

        //Notify that the data is ready - using LocalBroadcast

        busComponiesVOList = mBusComponiesVOList;
        BusComponiesVO.saveBusCompany(busComponiesVOList);
//        broadcastBusComponiesLoadedWithEventBus();
    }

//    public List<BusComponiesVO> notifyBusComponiesLoadedForDetail(List<BusComponiesVO> mBusComponiesVOList) {
//
//        //Notify that the data is ready - using LocalBroadcast
//
//        busComponiesVOList = mBusComponiesVOList;
//        BusComponiesVO.saveBusCompany(busComponiesVOList);
//
//        return busComponiesVOList;
////        broadcastBusComponiesLoadedWithEventBus();
//    }

    private void broadcastBusComponiesLoadedWithEventBus() {

        EventBus.getDefault().post(new DataEvent.BusComponiesDataLoadedEvent("extra-in-broadcast", busComponiesVOList));
    }
}

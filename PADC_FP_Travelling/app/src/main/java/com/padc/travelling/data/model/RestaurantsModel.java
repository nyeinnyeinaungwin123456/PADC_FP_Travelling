package com.padc.travelling.data.model;

import com.padc.travelling.data.vos.RestaurantsVO;
import com.padc.travelling.data.events.DataEvent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by dellpc on 25-Sep-16.
 */
public class RestaurantsModel extends BaseModel {

    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    public List<RestaurantsVO> restaurantsVOList;
    private static RestaurantsModel restaurantsModel;

    public RestaurantsModel() {
        super();
        restaurantsVOList = new ArrayList<>();
        dataAgent.loadRestaurants();
    }

    public static RestaurantsModel getInstance(){
        if(restaurantsModel==null){
            restaurantsModel = new RestaurantsModel();
        }
        return  restaurantsModel;
    }

    public List<RestaurantsVO> getRestaurantsVOList() {
        return restaurantsVOList;
    }

    public RestaurantsVO getRestaurantsByName(String restaurantsName) {
        for (RestaurantsVO restaurants : restaurantsVOList) {
            if (restaurants.getName().equals(restaurantsName)) {
                return restaurants;
            }
        }
        return null;
    }

    public void notifyErrorInLoadingRestaurants(String message) {

    }

    public void notifyRestaurantsLoaded(List<RestaurantsVO> restaurntsList) {
        //Notify that the data is ready - using LocalBroadcast
        restaurantsVOList = restaurntsList;
        broadcastRestaurantsLoadedWithEventBus();
    }

    private void broadcastRestaurantsLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.RestaurantsDataLoadedEvent("extra-in-broadcast", restaurantsVOList));
    }


}

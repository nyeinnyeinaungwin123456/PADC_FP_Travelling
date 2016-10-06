package com.padc.travelling.data.model;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.events.DataEvent;
import com.padc.travelling.data.vos.RestaurantsVO;
import com.padc.travelling.utils.TravellingConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void setStoredData(List<RestaurantsVO> restaurantList) {
        restaurantsVOList = restaurantList;
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
        RestaurantsVO.saveRestaurant(restaurantsVOList);
    }

    private void broadcastRestaurantsLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.RestaurantsDataLoadedEvent("extra-in-broadcast", restaurantsVOList));
    }

    public String getRandomRestaurantImage() {
        if (restaurantsVOList == null || restaurantsVOList.size() == 0) {
            return null;
        }

        Random random = new Random();
        int randomInt = random.nextInt(restaurantsVOList.size());

        RestaurantsVO restaurant = restaurantsVOList.get(randomInt);
        return TravellingConstants.IMAGE_ROOT_RESTAURANT + restaurant.getPhotos()[restaurant.getPhotos().length - 1];
    }

    private void broadcastRestaurantLoadedWithLocalBroadcastManager() {
        Intent intent = new Intent(BROADCAST_DATA_LOADED);
        intent.putExtra("key-for-extra", "extra-in-broadcast");
        LocalBroadcastManager.getInstance(TravellingApp.getContext()).sendBroadcast(intent);
    }

    private void broadcastAttractionPlacesLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.RestaurantsDataLoadedEvent("extra-in-broadcast", restaurantsVOList));
    }

    public List<RestaurantsVO> getRestaurantVOList(){
        return restaurantsVOList;
    }


}

package com.padc.travelling.data.vos.events;

import com.padc.travelling.data.vos.BusComponiesVO;
import com.padc.travelling.data.vos.HotelsVO;
import com.padc.travelling.data.vos.RestaurantsVO;
import com.padc.travelling.data.vos.TourPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aung on 7/9/16.
 */
public class DataEvent {
    public static class TourPackageDataLoadedEvent {

        public String extraMessage;
        public List<TourPackage> tourpackageList = new ArrayList<>();

        public TourPackageDataLoadedEvent(String extraMessage, List<TourPackage> tourpackageList) {
            this.extraMessage = extraMessage;
            this.tourpackageList = tourpackageList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<TourPackage> getTourPackageList() {
            return tourpackageList;
        }
    }

    public static class HotelsDataLoadedEvent{

        public String extraMessage;
        public List<HotelsVO> hotelsList = new ArrayList<>();

        public HotelsDataLoadedEvent(String extraMessage, List<HotelsVO> hotelsList){
            this.extraMessage = extraMessage;
            this.hotelsList = hotelsList;
        }

        public String getExtraMessage(){
            return extraMessage;
        }

        public List<HotelsVO> getHotelsList() {
            return hotelsList;
        }
    }

    public static class BusComponiesDataLoadedEvent{
        public String extraMessage;
        public List<BusComponiesVO> busComponiesVOsList = new ArrayList<>();

        public BusComponiesDataLoadedEvent(String extraMessage, List<BusComponiesVO> busComponiesVOsList) {
            this.extraMessage = extraMessage;
            this.busComponiesVOsList = busComponiesVOsList;
        }


        public String getExtraMessage() {
            return extraMessage;
        }

        public List<BusComponiesVO> getBusComponiesVOsList() {
            return busComponiesVOsList;
        }
    }

    public static class  RestaurantsDataLoadedEvent{

        public String extraMessage;
        public  List<RestaurantsVO> restaurantsList = new ArrayList<>();

        public RestaurantsDataLoadedEvent(String extraMessage, List<RestaurantsVO> restaurantsList) {
            this.extraMessage = extraMessage;
            this.restaurantsList = restaurantsList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<RestaurantsVO> getRestaurantsList() {
            return restaurantsList;
        }
    }

    public static class DatePickedEvent {
        private String dateOfBrith;

        public DatePickedEvent(String dateOfBrith) {
            this.dateOfBrith = dateOfBrith;
        }

        public String getDateOfBrith() {
            return dateOfBrith;
        }
    }

    public static class RefreshUserLoginStatusEvent {

    }
}

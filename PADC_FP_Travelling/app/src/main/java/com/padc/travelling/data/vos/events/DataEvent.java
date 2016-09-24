package com.padc.travelling.data.vos.events;

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

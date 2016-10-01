package com.padc.travelling.data.vos.events;

import com.padc.travelling.data.vos.attractionplaces.AttractionPlaces;

import com.padc.travelling.data.vos.tourpackageVOs.TourPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aung on 7/9/16.
 */
public class DataEvent {

    //Tourpackage
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

    //Attraction Places

    public static class AttractionPlacesDataLoadedEvent {

        public String extraMessage;
        public List<AttractionPlaces> attractionplacesList = new ArrayList<>();

        public AttractionPlacesDataLoadedEvent(String extraMessage, List<AttractionPlaces> attractionplacesList) {
            this.extraMessage = extraMessage;
            this.attractionplacesList = attractionplacesList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        //AttractionPlaces
        public List<AttractionPlaces> getAttractionPlacesList() {
            return attractionplacesList;
        }
    }

    //DatePicker
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

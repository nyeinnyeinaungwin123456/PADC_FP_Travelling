package com.padc.travelling.data.persistances;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.padc.travelling.TravellingApp;

/**
 * Created by aung on 7/9/16.
 */
public class TravelMyanmarContract {

    public static final String CONTENT_AUTHORITY = TravellingApp.class.getPackage().getName();
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    //ATTRACTION PLACES
    public static final String PATH_ATTRACTION = "attractions";
    public static final String PATH_ATTRACTION_IMAGES = "attractions_images";

    //HOTEL
    public static final String PATH_HOTEL = "hotels";
    public static final String PATH_HOTEL_PHOTOS = "hotels_photos";
//    public static final String PATH_HOTEL_PHONE = "hotels_phone";

    //HIGHWAY BUSES
    public static final String PATH_HIGHWAYBUS = "highwaybus";
    public static final String PATH_HIGHWAYBUS_PHOTOS = "highwaybus_photos";
    public static final String PATH_HIGHWAYBUS_OUTLET = "highway_outlets";
    public static final String PATH_HIGHWAYBUS_ROUTES = "highway_route";
    public static final String PATH_HIGHWAYBUS_PHONE = "highway_phone";
    public static final String PATH_STARTDESTINATION = "startdestination";
    public static final String PATH_ENDDESTINATION = "enddestination";

    //RESTAURANT
    public static final String PATH_RESTAURANT = "restaurant";
    public static final String PATH_RESTAURANT_PHOTOS = "restaurant_photos";
//    public static final String PATH_RESTAURANT_OFFDAY = "off_days";

    //TOUR PACKAGE
    public static final String PATH_TOURPACKAGE = "tourpackage";
    public static final String PATH_TOURPACKAGE_PHOTOS = "tourpackage_photos";
    public static final String PATH_TOURPACKAGE_DESTINATIONPHOTO = "destination_photos";
    public static final String PATH_TOURPACKAGE_ATTRACTIONPLACEPHOTO = "attractionplace_photos";



    //For Hotel
    public static final class HotelEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_HOTEL).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HOTEL;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HOTEL;

        public static final String TABLE_NAME = "hotels";

//        public static final String COLUMN_ID = "hotel-id";
        public static final String COLUMN_NAME = "hotelname";
        public static final String COLUMN_DESC = "description";
        public static final String COLUMN_DIRECTION = "directiontohotel";
        public static final String COLUMN_LOCATION = "location";

        public static Uri buildHotelUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildHotelUriWithName(String hotelName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions?title="Yangon"
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_NAME, hotelName)
                    .build();
        }

        public static String getNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_NAME);
        }
    }

    public static final class HotelPhotosEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_HOTEL_PHOTOS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HOTEL_PHOTOS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HOTEL_PHOTOS;

        public static final String TABLE_NAME = "hotelsphotos";

        public static final String COLUMN_HOTEL_NAME = "hotelname";
        public static final String COLUMN_PHOTOS = "photos";

        public static Uri buildHotelPhotoUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildHotelPhotosUriWithName(String hotelName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_HOTEL_NAME, hotelName)
                    .build();
        }

        public static String getHotelNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_HOTEL_NAME);
        }
    }

//    public static final class HotelPhoneEntry implements BaseColumns {
//        public static final Uri CONTENT_URI =
//                BASE_CONTENT_URI.buildUpon().appendPath(PATH_HOTEL_PHONE).build();
//
//        public static final String DIR_TYPE =
//                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HOTEL_PHONE;
//
//        public static final String ITEM_TYPE =
//                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HOTEL_PHONE;
//
//        public static final String TABLE_NAME = "hotelsphone";
//
//        public static final String COLUMN_HOTEL_NAME = "hotelname";
//        public static final String COLUMN_PHONE = "phone";
//
//        public static Uri buildHotelPhoneUri(long id) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
//            return ContentUris.withAppendedId(CONTENT_URI, id);
//        }
//
//        public static Uri buildHotelPhoneUriWithName(String hotelName) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
//            return CONTENT_URI.buildUpon()
//                    .appendQueryParameter(COLUMN_HOTEL_NAME, hotelName)
//                    .build();
//        }
//
//        public static String getHotelNameFromParam(Uri uri) {
//            return uri.getQueryParameter(COLUMN_HOTEL_NAME);
//        }
//    }


    //HIGHWAY BUSES

    public static final class HighwayBusEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_HIGHWAYBUS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS;

        public static final String TABLE_NAME = "highwaybus";

//        public static final String COLUMN_ID = "companyid";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESC = "description";
        public static final String COLUMN_TICKETOUTLET = "ticketingoutlets";
        public static final String COLUMN_ROUTE = "routes";

        public static Uri buildHighwayUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildHighwayUriWithName(String highwayName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions?title="Yangon"
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_NAME, highwayName)
                    .build();
        }

        public static String getNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_NAME);
        }
    }

    public static final class HighwayPhotoEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_HIGHWAYBUS_PHOTOS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS_PHOTOS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS_PHOTOS;

        public static final String TABLE_NAME = "highway_photos";

        public static final String COLUMN_HIGHWAY_NAME = "highwayname";
        public static final String COLUMN_PHOTOS = "photos";

        public static Uri buildHighwayPhotoUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildHighwayPhotoUriWithName(String hotelName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_HIGHWAY_NAME, hotelName)
                    .build();
        }

        public static String getHighwayNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_HIGHWAY_NAME);
        }
    }

    public static final class HighwayOutletEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_HIGHWAYBUS_OUTLET).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS_OUTLET;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS_OUTLET;

        public static final String TABLE_NAME = "highway_outlets";

        public static final String COLUMN_HIGHWAY_NAME = "companyname";
        public static final String COLUMN_AGENTNAME = "agentnames";

        public static Uri buildHighwayOutletUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildHighwayOutletUriWithName(String highwayName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_HIGHWAY_NAME, highwayName)
                    .build();
        }

        public static String getHighwayNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_HIGHWAY_NAME);
        }
    }

    public static final class HighwayRouteEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_HIGHWAYBUS_ROUTES).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS_ROUTES;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS_ROUTES;

        public static final String TABLE_NAME = "highway_routes";

        public static final String COLUMN_HIGHWAY_NAME = "companyname";
        public static final String COLUMN_ROUTE = "routes";
        public static final String COLUMN_PRICE = "price";
//        public static final RoutesVO COLUMN_ROUTE = 0;
//        public static final String COLUMN_STARTDESTINATION = "startdestination";
//        public static final String COLUMN_ENDDESTINATION = "enddestination";


        public static Uri buildHighwayRouteUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildHighwayRouteUriWithName(String highwayName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_HIGHWAY_NAME, highwayName)
                    .build();
        }

        public static String getHighwayNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_HIGHWAY_NAME);
        }
    }

    public static final class HighwayPhoneEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_HIGHWAYBUS_PHONE).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS_PHONE;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HIGHWAYBUS_PHONE;

        public static final String TABLE_NAME = "highway_phone";

        public static final String COLUMN_HIGHWAY_NAME = "companyname";
        public static final String COLUMN_PHONE = "phone";


        public static Uri buildHighwayPhoneUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildHighwayPhoneUriWithName(String highwayName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_HIGHWAY_NAME, highwayName)
                    .build();
        }

        public static String getHighwayNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_HIGHWAY_NAME);
        }
    }

    public static final class StartDestinationEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_STARTDESTINATION).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STARTDESTINATION;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STARTDESTINATION;

        public static final String TABLE_NAME = "highway_startdestination";

        public static final String COLUMN_HIGHWAY_NAME = "companyname";
        public static final String COLUMN_STARTDESTINATION = "startdestination";


        public static Uri buildStartDestinationUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildStartDestinationUriWithName(String startdestinationName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_HIGHWAY_NAME, startdestinationName)
                    .build();
        }

        public static String getHighwayNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_HIGHWAY_NAME);
        }
    }

    public static final class EndDestinationEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ENDDESTINATION).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ENDDESTINATION;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ENDDESTINATION;

        public static final String TABLE_NAME = "highway_enddestination";

        public static final String COLUMN_HIGHWAY_NAME = "companyname";
        public static final String COLUMN_ENDDESTINATION = "enddestination";


        public static Uri buildEndDestinationUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildEndDestinationUriWithName(String enddestinationName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_HIGHWAY_NAME, enddestinationName)
                    .build();
        }

        public static String getHighwayNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_HIGHWAY_NAME);
        }
    }

    //RESTAURANT
    public static final class RestaurantEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_RESTAURANT).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESTAURANT;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESTAURANT;

        public static final String TABLE_NAME = "restaurant";

        public static final String COLUMN_ID = "restaurant_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESC = "description";
        public static final String COLUMN_NOTE = "note_to_visitor";
        public static final String COLUMN_LOCATION = "location";
        public static final String COLUMN_OPTIME = "operating_time";

        public static Uri buildRestaurantUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildRestaurantUriWithName(String restaurantName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions?title="Yangon"
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_NAME, restaurantName)
                    .build();
        }

        public static String getNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_NAME);
        }
    }

    public static final class RestaurantPhotoEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_RESTAURANT_PHOTOS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESTAURANT_PHOTOS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESTAURANT_PHOTOS;

        public static final String TABLE_NAME = "restaurant_photos";

        public static final String COLUMN_RESTAURANT_NAME = "restaurantname";
        public static final String COLUMN_PHOTOS = "photos";

        public static Uri buildRestaurantPhotoUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildRestaurantPhotoUriWithName(String restaurantName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_RESTAURANT_NAME, restaurantName)
                    .build();
        }

        public static String getRestaurantNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_RESTAURANT_NAME);
        }
    }

//    public static final class RestaurantOffdayEntry implements BaseColumns {
//        public static final Uri CONTENT_URI =
//                BASE_CONTENT_URI.buildUpon().appendPath(PATH_RESTAURANT_OFFDAY).build();
//
//        public static final String DIR_TYPE =
//                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESTAURANT_OFFDAY;
//
//        public static final String ITEM_TYPE =
//                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESTAURANT_OFFDAY;
//
//        public static final String TABLE_NAME = "restaurant_offday";
//
//        public static final String COLUMN_RESTAURANT_ID = "restaurant_id";
//        public static final String COLUMN_OFFDAY = "phone_numbers";
//
//        public static Uri buildRestaurantOffdayUri(long id) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
//            return ContentUris.withAppendedId(CONTENT_URI, id);
//        }
//
//        public static Uri buildRestaurantOffdayUriWithId(String hotelId) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
//            return CONTENT_URI.buildUpon()
//                    .appendQueryParameter(COLUMN_RESTAURANT_ID, hotelId)
//                    .build();
//        }
//
//        public static String getRestaurantIdFromParam(Uri uri) {
//            return uri.getQueryParameter(COLUMN_RESTAURANT_ID);
//        }
//    }


    //For Attraction Places
    public static final class AttractionEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ATTRACTION).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTION;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTION;

        public static final String TABLE_NAME = "attractions";

        //        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESC = "desc";

        public static Uri buildAttractionUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


        //To Ask
        public static Uri buildAttractionUriWithTitle(String attractiontitle) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions?title="Yangon"
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_TITLE, attractiontitle)
                    .build();
        }

        public static String getTitleFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_TITLE);
        }
    }

    public static final class AttractionImageEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ATTRACTION_IMAGES).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTION_IMAGES;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTION_IMAGES;

        public static final String TABLE_NAME = "attraction_images";

        public static final String COLUMN_ATTRACTION_TITLE = "attraction_title";
        public static final String COLUMN_IMAGE = "image";

        public static Uri buildAttractionImageUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildAttractionImageUriWithTitle(String attractionTitle) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_ATTRACTION_TITLE, attractionTitle)
                    .build();
        }

        public static String getAttractionTitleFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_ATTRACTION_TITLE);
        }
    }

    //TOURPACKAGE
    public static final class TourpackageEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOURPACKAGE).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOURPACKAGE;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOURPACKAGE;

        public static final String TABLE_NAME = "tourpackages";

        public static final String COLUMN_ID = "packageid";
        public static final String COLUMN_NAME = "packagename";
        public static final String COLUMN_DESC = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_TOTALDAY = "totaldays";
        public static final String COLUMN_SUBDESTINATION = "subdestinations";
        public static final String COLUMN_TOURCOMPANY = "tourcompany";


        public static Uri buildTourpackageUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildTourpackageUriWithName(String tourpackageName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions?title="Yangon"
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_NAME, tourpackageName)
                    .build();
        }

        public static String getNameFromParam(Uri uri) {

            return uri.getQueryParameter(COLUMN_NAME);
        }
    }

    public static final class TourpackagePhotoEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOURPACKAGE_PHOTOS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOURPACKAGE_PHOTOS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOURPACKAGE_PHOTOS;

        public static final String TABLE_NAME = "tourpackage_photos";

        public static final String COLUMN_TOURPACKAGE_NAME = "packagename";
        public static final String COLUMN_TOURPACKAGE_ID = "tourpackage_id";

        public static final String COLUMN_PHOTOS = "photos";

        public static Uri buildTourpackagePhotoUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildTourpackagePhotoUriWithName(String tourpackageName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_TOURPACKAGE_NAME, tourpackageName)
                    .build();
        }

        public static String getTourpackageNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_TOURPACKAGE_NAME);
        }
    }



//    public static final class TourpackageDestinationPhotoEntry implements BaseColumns {
//        public static final Uri CONTENT_URI =
//                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOURPACKAGE_DESTINATIONPHOTO).build();
//
//        public static final String DIR_TYPE =
//                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOURPACKAGE_DESTINATIONPHOTO;
//
//        public static final String ITEM_TYPE =
//                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOURPACKAGE_DESTINATIONPHOTO;
//
//        public static final String TABLE_NAME = "tourpackage_destinationphotos";
//
//        public static final String COLUMN_TOURPACKAGE_NAME = "tourpackage-name";
//        public static final String COLUMN_DESTINATIONPHOTO = "destination_photos";
//
//        public static Uri buildDestinationPhotoUri(long id) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
//            return ContentUris.withAppendedId(CONTENT_URI, id);
//        }
//
//        public static Uri buildDestinationPhotoUriWithName(String hotelName) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
//            return CONTENT_URI.buildUpon()
//                    .appendQueryParameter(COLUMN_TOURPACKAGE_NAME, hotelName)
//                    .build();
//        }
//
//        public static String getDestinationNameFromParam(Uri uri) {
//            return uri.getQueryParameter(COLUMN_TOURPACKAGE_NAME);
//        }
//    }
//
//    public static final class TourpackageAttractionPlacePhotoEntry implements BaseColumns {
//        public static final Uri CONTENT_URI =
//                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOURPACKAGE_ATTRACTIONPLACEPHOTO).build();
//
//        public static final String DIR_TYPE =
//                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOURPACKAGE_ATTRACTIONPLACEPHOTO;
//
//        public static final String ITEM_TYPE =
//                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOURPACKAGE_ATTRACTIONPLACEPHOTO;
//
//        public static final String TABLE_NAME = "tourpackage_attractionplaces";
//
//        public static final String COLUMN_TOURPACKAGE_NAME = "tourpackage-name";
//        public static final String COLUMN_ATTRACTIONPLACEPHOTO = "attractionplaces_photos";
//
//        public static Uri buildAttractionPlacesPhotoUri(long id) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
//            return ContentUris.withAppendedId(CONTENT_URI, id);
//        }
//
//        public static Uri buildAttractionPlacesPhotoUriWithId(String hotelName) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
//            return CONTENT_URI.buildUpon()
//                    .appendQueryParameter(COLUMN_TOURPACKAGE_NAME, hotelName)
//                    .build();
//        }
//
//        public static String getAttractionIdFromParam(Uri uri) {
//            return uri.getQueryParameter(COLUMN_TOURPACKAGE_NAME);
//        }
//    }

//        public static Uri buildTourpackagePhotoUriWithId(String tourpackageId) {
//            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
//            return CONTENT_URI.buildUpon()
//                    .appendQueryParameter(COLUMN_TOURPACKAGE_ID, tourpackageId)
//                    .build();
//        }
//
//        public static String getTourpackageIdFromParam(Uri uri) {
//            return uri.getQueryParameter(COLUMN_TOURPACKAGE_ID);
//        }
//    }



}

package com.padc.travelling.data.vos.persistances;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by aung on 7/9/16.
 */
public class TravelMyanmarDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 16;
    public static final String DATABASE_NAME = "travel.db";


    //ATTRACTION PLACES TABLE
    private static final String SQL_CREATE_ATTRACTION_TABLE = "CREATE TABLE " + TravelMyanmarContract.AttractionEntry.TABLE_NAME + " (" +
            TravelMyanmarContract.AttractionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TravelMyanmarContract.AttractionEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
            TravelMyanmarContract.AttractionEntry.COLUMN_DESC + " TEXT NOT NULL, " +

            " UNIQUE (" + TravelMyanmarContract.AttractionEntry.COLUMN_TITLE + ") ON CONFLICT IGNORE" +
            " );";

    private static final String SQL_CREATE_ATTRACTION_IMAGE_TABLE = "CREATE TABLE " + TravelMyanmarContract.AttractionImageEntry.TABLE_NAME + " (" +
            TravelMyanmarContract.AttractionImageEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TravelMyanmarContract.AttractionImageEntry.COLUMN_ATTRACTION_TITLE + " TEXT NOT NULL, " +
            TravelMyanmarContract.AttractionImageEntry.COLUMN_IMAGE + " TEXT NOT NULL, " +

            " UNIQUE (" + TravelMyanmarContract.AttractionImageEntry.COLUMN_ATTRACTION_TITLE + ", " +
            TravelMyanmarContract.AttractionImageEntry.COLUMN_IMAGE + ") ON CONFLICT IGNORE" +
            " );";

//    //HOTEL TABLE
//    private static final String SQL_CREATE_HOTEL_TABLE = "CREATE TABLE " + TravelMyanmarContract.HotelEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HotelEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
////            TravelMyanmarContract.HotelEntry.COLUMN_NAME) + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelEntry.COLUMN_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelEntry.COLUMN_DESC + " TEXT NOT NULL, " +
////            TravelMyanmarContract.HotelEntry.COLUMN_DIRECTION + " TEXT NOT NULL, " +
////            TravelMyanmarContract.HotelEntry.COLUMN_LOCATION + " TEXT, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HotelEntry.COLUMN_NAME + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_HOTEL_PHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.HotelPhotosEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HotelPhotosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HotelPhotosEntry.COLUMN_HOTEL_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelPhotosEntry.COLUMN_PHOTOS + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HotelPhotosEntry.COLUMN_HOTEL_NAME + ", " +
//            TravelMyanmarContract.HotelPhotosEntry.COLUMN_PHOTOS + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_HOTEL_PHONE_TABLE = "CREATE TABLE " + TravelMyanmarContract.HotelPhoneEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HotelPhoneEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HotelPhoneEntry.COLUMN_HOTEL_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelPhoneEntry.COLUMN_PHONE + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HotelPhoneEntry.COLUMN_HOTEL_NAME + ", " +
//            TravelMyanmarContract.HotelPhoneEntry.COLUMN_PHONE + ") ON CONFLICT IGNORE" +
//            " );";
//
//    //HIGHWAY TABLE
//    private static final String SQL_CREATE_HIGHWAY_TABLE = "CREATE TABLE " + TravelMyanmarContract.HighwayBusEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HighwayBusEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_DESC + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_TICKETOUTLET + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_ROUTE + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HighwayBusEntry.COLUMN_ID + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_HIGHWAY_PHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.HighwayPhotoEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HighwayPhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HighwayPhotoEntry.COLUMN_HIGHWAY_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayPhotoEntry.COLUMN_PHOTOS + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HighwayPhotoEntry.COLUMN_HIGHWAY_ID + ", " +
//            TravelMyanmarContract.HighwayPhotoEntry.COLUMN_PHOTOS + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_HIGHWAY_PHONE_TABLE = "CREATE TABLE " + TravelMyanmarContract.HighwayPhoneEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HighwayPhoneEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HighwayPhoneEntry.COLUMN_HIGHWAY_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayPhoneEntry.COLUMN_PHONE + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HighwayPhoneEntry.COLUMN_HIGHWAY_ID + ", " +
//            TravelMyanmarContract.HotelPhoneEntry.COLUMN_PHONE + ") ON CONFLICT IGNORE" +
//            " );";
//
//
//    //RESTAURNAT TABLE
//    private static final String SQL_CREATE_RESTAURANT_TABLE = "CREATE TABLE " + TravelMyanmarContract.RestaurantEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.RestaurantEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_DESC + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_NOTE + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_LOCATION + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_OPTIME + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.RestaurantEntry.COLUMN_ID + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_RESTAURANT_PHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.RestaurantPhotoEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.RestaurantPhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_RESTAURANT_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_PHOTOS + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_RESTAURANT_ID + ", " +
//            TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_PHOTOS + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_RESTAURANT_OFFDAY_TABLE = "CREATE TABLE " + TravelMyanmarContract.RestaurantOffdayEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.RestaurantOffdayEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.RestaurantOffdayEntry.COLUMN_RESTAURANT_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantOffdayEntry.COLUMN_OFFDAY + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.RestaurantOffdayEntry.COLUMN_RESTAURANT_ID + ", " +
//            TravelMyanmarContract.RestaurantOffdayEntry.COLUMN_OFFDAY + ") ON CONFLICT IGNORE" +
//            " );";

    //TOURPACKAGE TABLE

//    private static final String SQL_CREATE_TOURPACKAGE_TABLE = "CREATE TABLE " + TravelMyanmarContract.TourpackageEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.TourpackageEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.TourpackageEntry.COLUMN_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.TourpackageEntry.COLUMN_DESC + " TEXT NOT NULL, " +
//            TravelMyanmarContract.TourpackageEntry.COLUMN_PRICE + " INTEGER NOT NULL, " +
//            TravelMyanmarContract.TourpackageEntry.COLUMN_TOTALDAY + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.TourpackageEntry.COLUMN_NAME + ") ON CONFLICT IGNORE" +

//    //HOTEL TABLE
//    private static final String SQL_CREATE_HOTEL_TABLE = "CREATE TABLE " + TravelMyanmarContract.HotelEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HotelEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HotelEntry.COLUMN_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelEntry.COLUMN_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelEntry.COLUMN_DESC + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelEntry.COLUMN_DIRECTION + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelEntry.COLUMN_LOCATION + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HotelEntry.COLUMN_ID + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_HOTEL_PHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.HotelPhotosEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HotelPhotosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HotelPhotosEntry.COLUMN_HOTEL_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelPhotosEntry.COLUMN_PHOTOS + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HotelPhotosEntry.COLUMN_HOTEL_ID + ", " +
//            TravelMyanmarContract.HotelPhotosEntry.COLUMN_PHOTOS + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_HOTEL_PHONE_TABLE = "CREATE TABLE " + TravelMyanmarContract.HotelPhoneEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HotelPhoneEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HotelPhoneEntry.COLUMN_HOTEL_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HotelPhoneEntry.COLUMN_PHONE + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HotelPhoneEntry.COLUMN_HOTEL_ID + ", " +
//            TravelMyanmarContract.HotelPhoneEntry.COLUMN_PHONE + ") ON CONFLICT IGNORE" +
//            " );";
//
//    //HIGHWAY TABLE
//    private static final String SQL_CREATE_HIGHWAY_TABLE = "CREATE TABLE " + TravelMyanmarContract.HighwayBusEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HighwayBusEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_DESC + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_TICKETOUTLET + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayBusEntry.COLUMN_ROUTE + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HighwayBusEntry.COLUMN_ID + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_HIGHWAY_PHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.HighwayPhotoEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HighwayPhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HighwayPhotoEntry.COLUMN_HIGHWAY_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayPhotoEntry.COLUMN_PHOTOS + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HighwayPhotoEntry.COLUMN_HIGHWAY_ID + ", " +
//            TravelMyanmarContract.HighwayPhotoEntry.COLUMN_PHOTOS + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_HIGHWAY_PHONE_TABLE = "CREATE TABLE " + TravelMyanmarContract.HighwayPhoneEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.HighwayPhoneEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.HighwayPhoneEntry.COLUMN_HIGHWAY_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.HighwayPhoneEntry.COLUMN_PHONE + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.HighwayPhoneEntry.COLUMN_HIGHWAY_ID + ", " +
//            TravelMyanmarContract.HotelPhoneEntry.COLUMN_PHONE + ") ON CONFLICT IGNORE" +
//            " );";
//
//
//    //RESTAURNAT TABLE
//    private static final String SQL_CREATE_RESTAURANT_TABLE = "CREATE TABLE " + TravelMyanmarContract.RestaurantEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.RestaurantEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_DESC + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_NOTE + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_LOCATION + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantEntry.COLUMN_OPTIME + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.RestaurantEntry.COLUMN_ID + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_RESTAURANT_PHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.RestaurantPhotoEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.RestaurantPhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_RESTAURANT_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_PHOTOS + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_RESTAURANT_ID + ", " +
//            TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_PHOTOS + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_RESTAURANT_OFFDAY_TABLE = "CREATE TABLE " + TravelMyanmarContract.RestaurantOffdayEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.RestaurantOffdayEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.RestaurantOffdayEntry.COLUMN_RESTAURANT_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.RestaurantOffdayEntry.COLUMN_OFFDAY + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.RestaurantOffdayEntry.COLUMN_RESTAURANT_ID + ", " +
//            TravelMyanmarContract.RestaurantOffdayEntry.COLUMN_OFFDAY + ") ON CONFLICT IGNORE" +
//            " );";
//
    //TOURPACKAGE TABLE
    private static final String SQL_CREATE_TOURPACKAGE_TABLE = "CREATE TABLE " + TravelMyanmarContract.TourpackageEntry.TABLE_NAME + " (" +
            TravelMyanmarContract.TourpackageEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TravelMyanmarContract.TourpackageEntry.COLUMN_ID + " TEXT NOT NULL, " +
            TravelMyanmarContract.TourpackageEntry.COLUMN_NAME + " TEXT NOT NULL, " +
            TravelMyanmarContract.TourpackageEntry.COLUMN_DESC + " TEXT NOT NULL, " +
            TravelMyanmarContract.TourpackageEntry.COLUMN_TOTALDAY + " TEXT NOT NULL, " +
            TravelMyanmarContract.TourpackageEntry.COLUMN_SUBDESTINATION + " TEXT NOT NULL, " +
            TravelMyanmarContract.TourpackageEntry.COLUMN_TOURCOMPANY + " TEXT NOT NULL, " +

            " UNIQUE (" + TravelMyanmarContract.TourpackageEntry.COLUMN_ID + ") ON CONFLICT IGNORE" +
            " );";

    private static final String SQL_CREATE_TOURPACKAGE_PHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.TourpackagePhotoEntry.TABLE_NAME + " (" +
            TravelMyanmarContract.TourpackagePhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_TOURPACKAGE_NAME + " TEXT NOT NULL, " +
            TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_PHOTOS + " TEXT NOT NULL, " +

            " UNIQUE (" + TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_TOURPACKAGE_NAME + ", " +
            TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_PHOTOS + ") ON CONFLICT IGNORE" +
            " );";


//    private static final String SQL_CREATE_TOURPACKAGE_DESTINATIONPHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.TourpackageDestinationPhotoEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.TourpackageDestinationPhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.TourpackageDestinationPhotoEntry.COLUMN_TOURPACKAGE_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.TourpackageDestinationPhotoEntry.COLUMN_DESTINATIONPHOTO + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.TourpackageDestinationPhotoEntry.COLUMN_TOURPACKAGE_NAME + ", " +
//            TravelMyanmarContract.TourpackageDestinationPhotoEntry.COLUMN_DESTINATIONPHOTO + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_TOURPACKAGE_ATTRACTIONPLACEPHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.COLUMN_TOURPACKAGE_NAME + " TEXT NOT NULL, " +
//            TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.COLUMN_ATTRACTIONPLACEPHOTO + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.COLUMN_TOURPACKAGE_NAME + ", " +
//            TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.COLUMN_ATTRACTIONPLACEPHOTO + ") ON CONFLICT IGNORE" +
//            " );";
//=======
//            TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_TOURPACKAGE_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_PHOTOS + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_TOURPACKAGE_ID + ", " +
//            TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_PHOTOS + ") ON CONFLICT IGNORE" +
//            " );";

//    private static final String SQL_CREATE_TOURPACKAGE_DESTINATIONPHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.TourpackageDestinationPhotoEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.TourpackageDestinationPhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.TourpackageDestinationPhotoEntry.COLUMN_TOURPACKAGE_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.TourpackageDestinationPhotoEntry.COLUMN_DESTINATIONPHOTO + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.TourpackageDestinationPhotoEntry.COLUMN_TOURPACKAGE_ID + ", " +
//            TravelMyanmarContract.TourpackageDestinationPhotoEntry.COLUMN_DESTINATIONPHOTO + ") ON CONFLICT IGNORE" +
//            " );";
//
//    private static final String SQL_CREATE_TOURPACKAGE_ATTRACTIONPLACEPHOTO_TABLE = "CREATE TABLE " + TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.TABLE_NAME + " (" +
//            TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.COLUMN_TOURPACKAGE_ID + " TEXT NOT NULL, " +
//            TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.COLUMN_ATTRACTIONPLACEPHOTO + " TEXT NOT NULL, " +
//
//            " UNIQUE (" + TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.COLUMN_TOURPACKAGE_ID + ", " +
//            TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.COLUMN_ATTRACTIONPLACEPHOTO + ") ON CONFLICT IGNORE" +
//            " );";
//>>>>>>> 031156b91b09c853b42bb69b036304ffd60bb8cb



    public TravelMyanmarDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //ATTRACTION PLACES
        sqLiteDatabase.execSQL(SQL_CREATE_ATTRACTION_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ATTRACTION_IMAGE_TABLE);

//        //HOTEL
//        sqLiteDatabase.execSQL(SQL_CREATE_HOTEL_TABLE);
//        sqLiteDatabase.execSQL(SQL_CREATE_HOTEL_PHOTO_TABLE);
//        sqLiteDatabase.execSQL(SQL_CREATE_HOTEL_PHONE_TABLE);
//
//        //HIGHWAY
//        sqLiteDatabase.execSQL(SQL_CREATE_HIGHWAY_TABLE);
//        sqLiteDatabase.execSQL(SQL_CREATE_HIGHWAY_PHOTO_TABLE);
//        sqLiteDatabase.execSQL(SQL_CREATE_HIGHWAY_PHOTO_TABLE);
//
//        //RESTAURANT
//        sqLiteDatabase.execSQL(SQL_CREATE_RESTAURANT_TABLE);
//        sqLiteDatabase.execSQL(SQL_CREATE_RESTAURANT_PHOTO_TABLE);
//        sqLiteDatabase.execSQL(SQL_CREATE_RESTAURANT_OFFDAY_TABLE);


        //TOURPACKAGE
        sqLiteDatabase.execSQL(SQL_CREATE_TOURPACKAGE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TOURPACKAGE_PHOTO_TABLE);

//        sqLiteDatabase.execSQL(SQL_CREATE_TOURPACKAGE_DESTINATIONPHOTO_TABLE);
//        sqLiteDatabase.execSQL(SQL_CREATE_TOURPACKAGE_ATTRACTIONPLACEPHOTO_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //ATTRACTION PLACES
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.AttractionImageEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.AttractionEntry.TABLE_NAME);

//        //HOTELS
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.HotelPhotosEntry.TABLE_NAME);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.HotelPhoneEntry.TABLE_NAME);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.HotelEntry.TABLE_NAME);
//
//        //HIGHWAY
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.HighwayPhotoEntry.TABLE_NAME);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.HighwayPhoneEntry.TABLE_NAME);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.HighwayBusEntry.TABLE_NAME);
//
//        //RESTAURANT
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.RestaurantPhotoEntry.TABLE_NAME);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.RestaurantOffdayEntry.TABLE_NAME);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.RestaurantEntry.TABLE_NAME);

        //TOURPACKAGE
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.TABLE_NAME);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.TourpackageDestinationPhotoEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.TourpackagePhotoEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TravelMyanmarContract.TourpackageEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);

    }
}

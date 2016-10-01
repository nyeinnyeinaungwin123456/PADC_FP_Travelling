package com.padc.travelling.data.vos.persistances;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import retrofit2.http.HEAD;

/**
 * Created by aung on 7/10/16.
 */
public class TravelMyanmarProvider extends ContentProvider {

    //ATTRACTION PLACES
    public static final int ATTRACTION = 100;
    public static final int ATTRACTION_IMAGE = 200;

    private static final String sAttractionTitleSelection = TravelMyanmarContract.AttractionEntry.COLUMN_TITLE + " = ?";
    private static final String sAttractionImageSelectionWithTitle = TravelMyanmarContract.AttractionImageEntry.COLUMN_ATTRACTION_TITLE + " = ?";

//    //HOTEL
//    public static final int HOTEL = 300;
//    public static final int HOTEL_PHOTO = 400;
//    public static final int HOTEL_PHONE = 500;
//
//    private static final String sHotelIdSelection = TravelMyanmarContract.HotelEntry.COLUMN_NAME + " = ?";
//    private static final String sHotelPhotoSelectionWithId = TravelMyanmarContract.HotelPhotosEntry.COLUMN_HOTEL_NAME + " = ?";
//    private static final String sHotelPhoneSelectionWithId = TravelMyanmarContract.HotelPhoneEntry.COLUMN_HOTEL_NAME + " = ?";
//
//
//    //HIGHWAY
//    public static final int HIGHWAY = 600;
//    public static final int HIGHWAY_PHOTO = 700;
//    public static final int HIGHWAY_PHONE = 800;
//
//    private static final String sHighwayIdSelection = TravelMyanmarContract.HighwayBusEntry.COLUMN_ID + " = ?";
//    private static final String sHighwayPhotoSelectionWithId = TravelMyanmarContract.HighwayPhotoEntry.COLUMN_HIGHWAY_ID + " = ?";
//    private static final String sHighwayPhoneSelectionWithId = TravelMyanmarContract.HighwayPhoneEntry.COLUMN_HIGHWAY_ID + " = ?";
//
//    //RESTAURANT
//    public static final int RESTAURANT = 900;
//    public static final int RESTAURANT_PHOTO = 1000;
//    public static final int RESTAURANT_OFFDAY = 1100;
//
//    private static final String sRestaurantIdSelection = TravelMyanmarContract.RestaurantEntry.COLUMN_ID + " = ?";
//    private static final String sRestaurantPhotoSelectionWithId = TravelMyanmarContract.RestaurantPhotoEntry.COLUMN_RESTAURANT_ID + " = ?";
//    private static final String sRestaurantOffdaySelectionWithId = TravelMyanmarContract.RestaurantOffdayEntry.COLUMN_RESTAURANT_ID + " = ?";

    //TOURPACKAGE
    public static final int TOURPACKAGE = 300;
    public static final int TOURPACKAGE_PHOTO = 400;
//    public static final int TOURPACKAGE_DESTINATIONPHOTO = 1400;
//    public static final int TOURPACKAGE_ATTRACTIONPLACEPHOTO = 1500;

    private static final String sTourpackageNameSelection = TravelMyanmarContract.TourpackageEntry.COLUMN_NAME + " = ?";
    private static final String sTourpackagePhotoSelectionWithName = TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_TOURPACKAGE_NAME + " = ?";
//    private static final String sDestinationPhotoSelectionWithId = TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_TOURPACKAGE_NAME + " = ?";

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private TravelMyanmarDBHelper mTravelMyanmarDBHelper;

    @Override
    public boolean onCreate() {
        mTravelMyanmarDBHelper = new TravelMyanmarDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor queryCursor;

        int matchUri = sUriMatcher.match(uri);
        switch (matchUri) {

            //ATTRACTION PLACES
            case ATTRACTION:
                String attractionTitle = TravelMyanmarContract.AttractionEntry.getTitleFromParam(uri);
                if (!TextUtils.isEmpty(attractionTitle)) {
                    selection = sAttractionTitleSelection;
                    selectionArgs = new String[]{attractionTitle};
                }
                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.AttractionEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;
            case ATTRACTION_IMAGE:
                String title = TravelMyanmarContract.AttractionImageEntry.getAttractionTitleFromParam(uri);
                if (title != null) {
                    selection = sAttractionImageSelectionWithTitle;
                    selectionArgs = new String[]{title};
                }
                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.AttractionImageEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;


//            //HOTEL
//            case HOTEL:
//                String hotelId = TravelMyanmarContract.HotelEntry.getNameFromParam(uri);
//                if (!TextUtils.isEmpty(hotelId)) {
//                    selection = sHotelIdSelection;
//                    selectionArgs = new String[]{hotelId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.HotelEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null, //group_by
//                        null, //having
//                        sortOrder);
//                break;
//
//            case HOTEL_PHOTO:
//                String hotelphotoId = TravelMyanmarContract.HotelPhotosEntry.getHotelIdFromParam(uri);
//                if (hotelphotoId != null) {
//                    selection = sHotelPhotoSelectionWithId;
//                    selectionArgs = new String[]{hotelphotoId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.HotelPhotosEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;
//
//            case HOTEL_PHONE:
//                String hotelphoneId = TravelMyanmarContract.HotelPhoneEntry.getHotelNameFromParam(uri);
//                if (hotelphoneId != null) {
//                    selection = sHotelPhoneSelectionWithId;
//                    selectionArgs = new String[]{hotelphoneId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.HotelPhoneEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;
//
//            //HIGHWAY
//            case HIGHWAY:
//                String highwayId = TravelMyanmarContract.HighwayBusEntry.getIdFromParam(uri);
//                if (!TextUtils.isEmpty(highwayId)) {
//                    selection = sHighwayIdSelection;
//                    selectionArgs = new String[]{highwayId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.HighwayBusEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null, //group_by
//                        null, //having
//                        sortOrder);
//                break;
//
//            case HIGHWAY_PHOTO:
//                String highwayphotoId = TravelMyanmarContract.HighwayPhotoEntry.getHighwayIdFromParam(uri);
//                if (highwayphotoId != null) {
//                    selection = sHotelPhotoSelectionWithId;
//                    selectionArgs = new String[]{highwayphotoId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.HighwayPhotoEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;
//
//            case HIGHWAY_PHONE:
//                String highwayphoneId = TravelMyanmarContract.HighwayPhoneEntry.getHighwayIdFromParam(uri);
//                if (highwayphoneId != null) {
//                    selection = sHighwayPhoneSelectionWithId;
//                    selectionArgs = new String[]{highwayphoneId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.HighwayPhoneEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;
//
//            //RESTAURANT
//            case RESTAURANT:
//                String restaurantId = TravelMyanmarContract.RestaurantEntry.getIdFromParam(uri);
//                if (!TextUtils.isEmpty(restaurantId)) {
//                    selection = sRestaurantIdSelection;
//                    selectionArgs = new String[]{restaurantId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.RestaurantEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null, //group_by
//                        null, //having
//                        sortOrder);
//                break;
//
//            case RESTAURANT_PHOTO:
//                String restaurantphotoId = TravelMyanmarContract.RestaurantPhotoEntry.getRestaurantIdFromParam(uri);
//                if (restaurantphotoId != null) {
//                    selection = sRestaurantPhotoSelectionWithId;
//                    selectionArgs = new String[]{restaurantphotoId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.RestaurantPhotoEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;
//
//            case RESTAURANT_OFFDAY:
//                String restaurantoffdayId = TravelMyanmarContract.HighwayPhoneEntry.getHighwayIdFromParam(uri);
//                if (restaurantoffdayId != null) {
//                    selection = sRestaurantOffdaySelectionWithId;
//                    selectionArgs = new String[]{restaurantoffdayId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.RestaurantOffdayEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;

            //TOURPACKAGE
            case TOURPACKAGE:
                String tourpackageName = TravelMyanmarContract.TourpackageEntry.getNameFromParam(uri);
                if (!TextUtils.isEmpty(tourpackageName)) {
                    selection = sTourpackageNameSelection;
                    selectionArgs = new String[]{tourpackageName};

                }
                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.TourpackageEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null, //group_by
                        null, //having
                        sortOrder);
                break;

            case TOURPACKAGE_PHOTO:
                String tourpackagephotoName = TravelMyanmarContract.TourpackagePhotoEntry.getTourpackageNameFromParam(uri);
                if (tourpackagephotoName != null) {
                    selection = sTourpackagePhotoSelectionWithName;
                    selectionArgs = new String[]{tourpackagephotoName};

                    queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.TourpackagePhotoEntry.TABLE_NAME,
                            projection,
                            selection,
                            selectionArgs,
                            null,
                            null,
                            sortOrder);
                    break;
                }

//            case TOURPACKAGE_DESTINATIONPHOTO:
//                String destinationphotoId = TravelMyanmarContract.TourpackageDestinationPhotoEntry.getDestinationNameFromParam(uri);
//                if (destinationphotoId != null) {
//                    selection = sTourpackagePhotoSelectionWithId;
//                    selectionArgs = new String[]{destinationphotoId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.TourpackageDestinationPhotoEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;

//            case TOURPACKAGE_ATTRACTIONPLACEPHOTO:
//                String attractionplacephotoId = TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.getAttractionIdFromParam(uri);
//                if (attractionplacephotoId != null) {
//                    selection = sDestinationPhotoSelectionWithId;
//                    selectionArgs = new String[]{attractionplacephotoId};
//                }
//                queryCursor = mTravelMyanmarDBHelper.getReadableDatabase().query(TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.TABLE_NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
//                break;

            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        Context context = getContext();
        if (context != null) {
            queryCursor.setNotificationUri(context.getContentResolver(), uri);
        }

        return queryCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        final int matchUri = sUriMatcher.match(uri);
        switch (matchUri) {

            //ATTRACTION PLACES
            case ATTRACTION:
                return TravelMyanmarContract.AttractionEntry.DIR_TYPE;
            case ATTRACTION_IMAGE:
                return TravelMyanmarContract.AttractionImageEntry.DIR_TYPE;

//            //HOTEL
//            case HOTEL:
//                return TravelMyanmarContract.HotelEntry.DIR_TYPE;
//            case HOTEL_PHOTO:
//                return TravelMyanmarContract.HotelPhotosEntry.DIR_TYPE;
//            case HOTEL_PHONE:
//                return TravelMyanmarContract.HotelPhoneEntry.DIR_TYPE;
//
//            //HIGHWAY
//            case HIGHWAY:
//                return TravelMyanmarContract.HighwayBusEntry.DIR_TYPE;
//            case HIGHWAY_PHOTO:
//                return TravelMyanmarContract.HighwayPhotoEntry.DIR_TYPE;
//            case HIGHWAY_PHONE:
//                return TravelMyanmarContract.HighwayPhoneEntry.DIR_TYPE;
//
//            //RESTAURANT
//            case RESTAURANT:
//                return TravelMyanmarContract.RestaurantEntry.DIR_TYPE;
//            case RESTAURANT_PHOTO:
//                return TravelMyanmarContract.RestaurantPhotoEntry.DIR_TYPE;
//            case RESTAURANT_OFFDAY:
//                return TravelMyanmarContract.RestaurantOffdayEntry.DIR_TYPE;

            //TOURPACKAGE
            case TOURPACKAGE:
                return TravelMyanmarContract.TourpackageEntry.DIR_TYPE;
            case TOURPACKAGE_PHOTO:
                return TravelMyanmarContract.TourpackagePhotoEntry.DIR_TYPE;

//            case TOURPACKAGE_DESTINATIONPHOTO:
//                return TravelMyanmarContract.TourpackageDestinationPhotoEntry.DIR_TYPE;
//            case TOURPACKAGE_ATTRACTIONPLACEPHOTO:
//                return TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.DIR_TYPE;


            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final SQLiteDatabase db = mTravelMyanmarDBHelper.getWritableDatabase();
        final int matchUri = sUriMatcher.match(uri);
        Uri insertedUri;

        switch (matchUri) {

            //ATTRACTION
            case ATTRACTION: {
                long _id = db.insert(TravelMyanmarContract.AttractionEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = TravelMyanmarContract.AttractionEntry.buildAttractionUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case ATTRACTION_IMAGE: {
                long _id = db.insert(TravelMyanmarContract.AttractionImageEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = TravelMyanmarContract.AttractionImageEntry.buildAttractionImageUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }


//            //HOTEL
//            case HOTEL: {
//                long _id = db.insert(TravelMyanmarContract.HotelEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = TravelMyanmarContract.HotelEntry.buildHotelUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }
//            case HOTEL_PHOTO: {
//                long _id = db.insert(TravelMyanmarContract.HotelPhotosEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = TravelMyanmarContract.HotelPhotosEntry.buildHotelPhotoUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }
//
//            case HOTEL_PHONE: {
//                long _id = db.insert(TravelMyanmarContract.HotelPhoneEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = TravelMyanmarContract.HotelPhoneEntry.buildHotelPhoneUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }
//
//            //HIGHWAY
//            case HIGHWAY: {
//                long _id = db.insert(TravelMyanmarContract.HighwayBusEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = TravelMyanmarContract.HighwayBusEntry.buildHighwayUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }
//            case HIGHWAY_PHOTO: {
//                long _id = db.insert(TravelMyanmarContract.HighwayPhotoEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = TravelMyanmarContract.HighwayPhotoEntry.buildHighwayPhotoUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }
//
//            case HIGHWAY_PHONE: {
//                long _id = db.insert(TravelMyanmarContract.HighwayPhoneEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = TravelMyanmarContract.HighwayPhoneEntry.buildHighwayPhoneUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }


            //TOURPACKAGE
            case TOURPACKAGE: {
                long _id = db.insert(TravelMyanmarContract.TourpackageEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = TravelMyanmarContract.TourpackageEntry.buildTourpackageUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }
            case TOURPACKAGE_PHOTO: {
                long _id = db.insert(TravelMyanmarContract.TourpackagePhotoEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    insertedUri = TravelMyanmarContract.TourpackagePhotoEntry.buildTourpackagePhotoUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            }

//            case TOURPACKAGE_DESTINATIONPHOTO: {
//                long _id = db.insert(TravelMyanmarContract.TourpackageDestinationPhotoEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = TravelMyanmarContract.TourpackageDestinationPhotoEntry.buildDestinationPhotoUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }
//
//            case TOURPACKAGE_ATTRACTIONPLACEPHOTO: {
//                long _id = db.insert(TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.TABLE_NAME, null, contentValues);
//                if (_id > 0) {
//                    insertedUri = TravelMyanmarContract.TourpackageAttractionPlacePhotoEntry.buildAttractionPlacesPhotoUri(_id);
//                } else {
//                    throw new SQLException("Failed to insert row into " + uri);
//                }
//                break;
//            }

            //TODO

            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return insertedUri;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        final SQLiteDatabase db = mTravelMyanmarDBHelper.getWritableDatabase();
        String tableName = getTableName(uri);
        int insertedCount = 0;

        try {
            db.beginTransaction();
            for (ContentValues cv : values) {
                long _id = db.insert(tableName, null, cv);
                if (_id > 0) {
                    insertedCount++;
                }
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }

        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }

        return insertedCount;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mTravelMyanmarDBHelper.getWritableDatabase();
        int rowDeleted;
        String tableName = getTableName(uri);

        rowDeleted = db.delete(tableName, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowDeleted > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mTravelMyanmarDBHelper.getWritableDatabase();
        int rowUpdated;
        String tableName = getTableName(uri);

        rowUpdated = db.update(tableName, contentValues, selection, selectionArgs);
        Context context = getContext();
        if (context != null && rowUpdated > 0) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return rowUpdated;
    }

    private static UriMatcher buildUriMatcher() {
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        //ATTRACTION PLACES
        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_ATTRACTION, ATTRACTION);
        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_ATTRACTION_IMAGES, ATTRACTION_IMAGE);

//        //HOTEL
//        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_HOTEL, HOTEL);
//        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_HOTEL_PHOTOS, HOTEL_PHOTO);
//        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_HOTEL_PHONE, HOTEL_PHONE);
//
//        //HIGHWAY
//        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_HIGHWAYBUS, HIGHWAY);
//        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_HIGHWAYBUS_PHOTOS, HIGHWAY_PHOTO);
//        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_HIGHWAYBUS_PHONE, HIGHWAY_PHONE);

        //TOURPACKAGE
        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_TOURPACKAGE, TOURPACKAGE);
        uriMatcher.addURI(TravelMyanmarContract.CONTENT_AUTHORITY, TravelMyanmarContract.PATH_TOURPACKAGE_PHOTOS, TOURPACKAGE_PHOTO);


        return uriMatcher;
    }

    private String getTableName(Uri uri) {
        final int matchUri = sUriMatcher.match(uri);

        switch (matchUri) {

            //ATTRACTION PLACES
            case ATTRACTION:
                return TravelMyanmarContract.AttractionEntry.TABLE_NAME;
            case ATTRACTION_IMAGE:
                return TravelMyanmarContract.AttractionImageEntry.TABLE_NAME;

//            //HOTEL
//            case HOTEL:
//                return TravelMyanmarContract.HotelEntry.TABLE_NAME;
//            case HOTEL_PHOTO:
//                return TravelMyanmarContract.HotelPhotosEntry.TABLE_NAME;
//            case HOTEL_PHONE:
//                return TravelMyanmarContract.HotelPhoneEntry.TABLE_NAME;
//
//            //HIGHWAY
//            case HIGHWAY:
//                return TravelMyanmarContract.HighwayBusEntry.TABLE_NAME;
//            case HIGHWAY_PHOTO:
//                return TravelMyanmarContract.HighwayPhotoEntry.TABLE_NAME;
//            case HIGHWAY_PHONE:
//                return TravelMyanmarContract.HighwayPhoneEntry.TABLE_NAME;

            //ATTRACTION PLACES
            case TOURPACKAGE:
                return TravelMyanmarContract.TourpackageEntry.TABLE_NAME;
            case TOURPACKAGE_PHOTO:
                return TravelMyanmarContract.TourpackagePhotoEntry.TABLE_NAME;


            //TODO

            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }
}

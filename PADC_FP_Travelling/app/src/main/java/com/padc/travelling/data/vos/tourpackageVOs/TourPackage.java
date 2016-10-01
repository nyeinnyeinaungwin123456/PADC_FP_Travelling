
package com.padc.travelling.data.vos.tourpackageVOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.padc.travelling.TravellingApp;
import com.padc.travelling.data.vos.persistances.TravelMyanmarContract;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TourPackage {

    @SerializedName("package-id")
    @Expose
    private Integer packageId;
    @SerializedName("package-name")
    @Expose
    private String packageName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("photos")
    @Expose
//    private List<String> photos = new ArrayList<String>();
    private String[] photos;
    @SerializedName("estimate-price-per-person")
    @Expose
    private Integer estimatePricePerPerson;
    @SerializedName("total-days")
    @Expose
    private String totalDays;
    @SerializedName("sub-destinations")
    @Expose
    private List<SubDestination> subDestinations = new ArrayList<SubDestination>();
    @SerializedName("tour-company")
    @Expose
    private TourCompany tourCompany;

    /**
     * 
     * @return
     *     The packageId
     */
    public Integer getPackageId() {
        return packageId;
    }

    /**
     * 
     * @param packageId
     *     The package-id
     */
    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    /**
     * 
     * @return
     *     The packageName
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * 
     * @param packageName
     *     The package-name
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The photos
     */
    public String[] getPhotos() {
        return photos;
    }

    /**
     * 
     * @param photos
     *     The photos
     */
    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    /**
     * 
     * @return
     *     The estimatePricePerPerson
     */
    public Integer getEstimatePricePerPerson() {
        return estimatePricePerPerson;
    }

    /**
     * 
     * @param estimatePricePerPerson
     *     The estimate-price-per-person
     */
    public void setEstimatePricePerPerson(Integer estimatePricePerPerson) {
        this.estimatePricePerPerson = estimatePricePerPerson;
    }

    /**
     * 
     * @return
     *     The totalDays
     */
    public String getTotalDays() {
        return totalDays;
    }

    /**
     * 
     * @param totalDays
     *     The total-days
     */
    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    /**
     * 
     * @return
     *     The subDestinations
     */
    public List<SubDestination> getSubDestinations() {
        return subDestinations;
    }

    /**
     * 
     * @param subDestinations
     *     The sub-destinations
     */
    public void setSubDestinations(List<SubDestination> subDestinations) {
        this.subDestinations = subDestinations;
    }

    /**
     * 
     * @return
     *     The tourCompany
     */
    public TourCompany getTourCompany() {
        return tourCompany;
    }

    /**
     * 
     * @param tourCompany
     *     The tour-company
     */
    public void setTourCompany(TourCompany tourCompany) {
        this.tourCompany = tourCompany;
    }

    public static void saveTourPackage(List<TourPackage> tourpackageList) {
        Context context = TravellingApp.getContext();
        ContentValues[] tourpackageCVs = new ContentValues[tourpackageList.size()];
        for (int index = 0; index < tourpackageList.size(); index++) {
            TourPackage tourpackage = tourpackageList.get(index);
            tourpackageCVs[index] = tourpackage.parseToContentValues();

            //Bulk insert into attraction_images.
            TourPackage.saveTourPackageImage(tourpackage.getPackageName(), tourpackage.getPhotos());
        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.TourpackageEntry.CONTENT_URI, tourpackageCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }

    private static void saveTourPackageImage(String title, String[] images) {
        ContentValues[] tourpackageImagesCVs = new ContentValues[images.length];
        for (int index = 0; index < images.length; index++) {
            String image = images[index];

            ContentValues cv = new ContentValues();
            cv.put(TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_TOURPACKAGE_NAME, title);
            cv.put(TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_PHOTOS, image);

            tourpackageImagesCVs[index] = cv;
        }

        Context context = TravellingApp.getContext();
        int insertCount = context.getContentResolver().bulkInsert(TravelMyanmarContract.TourpackagePhotoEntry.CONTENT_URI, tourpackageImagesCVs);

        Log.d(TravellingApp.TAG, "Bulk inserted into attraction_images table : " + insertCount);
    }

    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(TravelMyanmarContract.TourpackageEntry.COLUMN_NAME, packageName);
        cv.put(TravelMyanmarContract.AttractionEntry.COLUMN_DESC, description);
        return cv;
    }

    public static TourPackage parseFromCursor(Cursor data) {
        TourPackage tourpackage = new TourPackage();
        tourpackage.packageName = data.getString(data.getColumnIndex(TravelMyanmarContract.TourpackageEntry.COLUMN_NAME));
        tourpackage.description = data.getString(data.getColumnIndex(TravelMyanmarContract.TourpackageEntry.COLUMN_DESC));
        tourpackage.estimatePricePerPerson = data.getInt(data.getColumnIndex(TravelMyanmarContract.TourpackageEntry.COLUMN_PRICE));
        tourpackage.totalDays = data.getString(data.getColumnIndex(TravelMyanmarContract.TourpackageEntry.COLUMN_TOTALDAY));
        return tourpackage;
    }

    public static String[] loadTourPackagePhotobyName(String name) {
        Context context = TravellingApp.getContext();
        ArrayList<String> images = new ArrayList<>();

        Cursor cursor = context.getContentResolver().query(TravelMyanmarContract.TourpackagePhotoEntry.buildTourpackagePhotoUriWithName(name),
                null, null, null, null);

        if(cursor != null && cursor.moveToFirst()) {
            do {
                images.add(cursor.getString(cursor.getColumnIndex(TravelMyanmarContract.TourpackagePhotoEntry.COLUMN_PHOTOS)));
            } while (cursor.moveToNext());
        }

        String[] imageArray = new String[images.size()];
        images.toArray(imageArray);
        return imageArray;
    }

}

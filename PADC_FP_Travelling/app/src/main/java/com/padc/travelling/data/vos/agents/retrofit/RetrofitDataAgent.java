package com.padc.travelling.data.vos.agents.retrofit;

import android.util.Log;

import com.padc.travelling.data.vos.agents.TourPackageDataAgent;
import com.padc.travelling.data.vos.model.AttractionsModel;
import com.padc.travelling.data.vos.model.TourPackageModel;
import com.padc.travelling.data.vos.responses.AttractionPlacesListResponse;
import com.padc.travelling.data.vos.responses.TourPackageListResponse;
import com.padc.travelling.utils.CommonInstances;
import com.padc.travelling.utils.TravellingConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aung on 7/9/16.
 */
public class RetrofitDataAgent implements TourPackageDataAgent {

    private static RetrofitDataAgent objInstance;

    private final TravellingApi theApi;

    private RetrofitDataAgent() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofittourpackage = new Retrofit.Builder()
                .baseUrl(TravellingConstants.TOURPACKAGE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofittourpackage.create(TravellingApi.class);

//        Retrofit retrofitattraction = new Retrofit.Builder()
//                .baseUrl(TravellingConstants.ATTRACTION_BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
//                .client(okHttpClient)
//                .build();
//
//        theApi = retrofitattraction.create(TravellingApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    //TourPackage
    @Override
    public void loadTourPackage() {
        Call<TourPackageListResponse> loadTourPackageCall = theApi.loadTourPackage(TravellingConstants.ACCESS_TOKEN);
        loadTourPackageCall.enqueue(new Callback<TourPackageListResponse>() {
            @Override

            public void onResponse(Call<TourPackageListResponse> call, Response<TourPackageListResponse> response) {

                Log.e("RetrofitDataAgent", "onResponse");
                if (response.isSuccessful()) {
                    Log.e("RetrofitDataAgent", "onResponse Success");
                    TourPackageListResponse tourpackageListResponse = response.body();
                    if (tourpackageListResponse == null) {
                        TourPackageModel.getInstance().notifyErrorInLoadingTravel(response.message());
                    } else {
                        TourPackageModel.getInstance().notifyTourPackageLoaded(tourpackageListResponse.getTourPackageList());
                    }
                } else {
                    Log.e("RetrofitDataAgent", "onResponse Fail");
                }
            }

            @Override
            public void onFailure(Call<TourPackageListResponse> call, Throwable throwable) {
                throwable.printStackTrace();
                TourPackageModel.getInstance().notifyErrorInLoadingTravel(throwable.getMessage());
                Log.e("RetrofitDataAgent", "onResponse Fail");
            }
        });
    }

    //AttractionPlaces
    @Override
    public void loadAttractionPlaces() {
        Call<AttractionPlacesListResponse> loadAttractoinPlacesCall = theApi.loadAttractionPlaces(TravellingConstants.ACCESS_TOKEN);
        loadAttractoinPlacesCall.enqueue(new Callback<AttractionPlacesListResponse>() {
            @Override

            public void onResponse(Call<AttractionPlacesListResponse> call, Response<AttractionPlacesListResponse> response) {

                Log.e("RetrofitAttraction", "onResponse");
                if (response.isSuccessful()) {
                    Log.e("RetrofitDataAgent", "onResponse Success");
                    AttractionPlacesListResponse attractionplacesListResponse = response.body();
                    if (attractionplacesListResponse == null) {
                        AttractionsModel.getInstance().notifyErrorInLoadingTravel(response.message());
                    } else {
                        AttractionsModel.getInstance().notifyAttractionPlacesLoaded(attractionplacesListResponse.getAttractionPlacesList());
                    }
                } else {
                    Log.e("RetrofitAttraction", "onResponse Fail");
                }
            }

            @Override
            public void onFailure(Call<AttractionPlacesListResponse> call, Throwable throwable) {
                throwable.printStackTrace();
                AttractionsModel.getInstance().notifyErrorInLoadingTravel(throwable.getMessage());
                Log.e("RetrofitAttraction", "onResponse Fail");

                String message = throwable.getMessage();
                Log.d("failure", message);
            }
        });
    }


}

package com.padc.travelling.data.vos.agents.retrofit;

import android.util.Log;

import com.padc.travelling.data.vos.agents.HotelsDataAgent;
import com.padc.travelling.data.vos.agents.RestaurantsDataAgent;
import com.padc.travelling.data.vos.agents.TourPackageDataAgent;
import com.padc.travelling.data.vos.model.HotelsModel;
import com.padc.travelling.data.vos.model.RestaurantsModel;
import com.padc.travelling.data.vos.model.TourPackageModel;
import com.padc.travelling.data.vos.responses.HotelsListResponse;
import com.padc.travelling.data.vos.responses.RestaurantsListResponse;
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
public class RetrofitDataAgent implements TourPackageDataAgent,HotelsDataAgent,RestaurantsDataAgent {

    private static RetrofitDataAgent objInstance;

    private final TourPackageApi theApi;

    private RetrofitDataAgent() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TravellingConstants.TOURPACKAGE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(TourPackageApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadTourPackage() {
        Call<TourPackageListResponse> loadTourPackageCall = theApi.loadTourPackage(TravellingConstants.ACCESS_TOKEN);
        loadTourPackageCall.enqueue(new Callback<TourPackageListResponse>() {
            @Override

            public void onResponse(Call<TourPackageListResponse> call, Response<TourPackageListResponse> response) {

                Log.e("RetrofitDataAgent", "onResponse");
                if (response.isSuccessful()) {
                    Log.e("RetrofitDataAgent", "onResponse Success(TourPackage)");
                    TourPackageListResponse tourpackageListResponse = response.body();
                    if (tourpackageListResponse == null) {
                        TourPackageModel.getInstance().notifyErrorInLoadingAttractions(response.message());
                    } else {
                        TourPackageModel.getInstance().notifyTourPackageLoaded(tourpackageListResponse.getTourPackageList());
                    }
                } else {
                    Log.e("RetrofitDataAgent", "onResponse Fail(TourPackage)");
                }
            }

            @Override
            public void onFailure(Call<TourPackageListResponse> call, Throwable throwable) {
                throwable.printStackTrace();
                TourPackageModel.getInstance().notifyErrorInLoadingAttractions(throwable.getMessage());
                Log.e("RetrofitDataAgent", "onResponse Fail(TourPackage)");
            }
        });
    }

    @Override
    public void loadHotels() {
        Call<HotelsListResponse> loadHotelsCall = theApi.loadHotels(TravellingConstants.ACCESS_TOKEN);
        loadHotelsCall.enqueue(new Callback<HotelsListResponse>() {
            @Override
            public void onResponse(Call<HotelsListResponse> call, Response<HotelsListResponse> response) {

                Log.e("RetrofitDataAgent", "onResponse");

                if (response.isSuccessful()) {
                    Log.e("RetrofitDataAgent", "onResponse Success(Hotel)");
                    HotelsListResponse hotelsListResponse = response.body();
                    if(hotelsListResponse == null){
                        HotelsModel.getInstance().notifyErrorInLoadingAttractions(response.message());
                    }else{
                        HotelsModel.getInstance().notifyHotelsLoaded(hotelsListResponse.getHotelsList());
                    }
                }else {
                    Log.e("RetrofitDataAgent", "onResponse Fail(Hotel)");
                }

            }

            @Override
            public void onFailure(Call<HotelsListResponse> call, Throwable throwable) {
                throwable.printStackTrace();
                HotelsModel.getInstance().notifyErrorInLoadingAttractions(throwable.getMessage());
                Log.e("RetrofitDataAgent", "onResponse Fail(Hotel)");
            }
        });

    }

    @Override
    public void loadRestaurants() {
        Call<RestaurantsListResponse> loadRestaurantsCall = theApi.loadRestaurants(TravellingConstants.ACCESS_TOKEN);
        loadRestaurantsCall.enqueue(new Callback<RestaurantsListResponse>() {
            @Override
            public void onResponse(Call<RestaurantsListResponse> call, Response<RestaurantsListResponse> response) {

                Log.e("RetrofitDataAgent", "onResponse");

                if (response.isSuccessful()) {
                    Log.e("RetrofitDataAgent", "onResponse Success(Restaurant)");
                    RestaurantsListResponse restaurantsListResponse = response.body();
                    if(restaurantsListResponse == null){
                        RestaurantsModel.getInstance().notifyErrorInLoadingRestaurants(response.message());
                    }else{
                        RestaurantsModel.getInstance().notifyRestaurantsLoaded(restaurantsListResponse.getRestaurantsList());
                    }
                }else {
                    Log.e("RetrofitDataAgent", "onResponse Fail(Restaurant)");
                }
            }

            @Override
            public void onFailure(Call<RestaurantsListResponse> call, Throwable throwable) {
                throwable.printStackTrace();
                RestaurantsModel.getInstance().notifyErrorInLoadingRestaurants(throwable.getMessage());
                Log.e("RetrofitDataAgent", "onResponse Fail(Restaurant)");
            }
        });
    }
}

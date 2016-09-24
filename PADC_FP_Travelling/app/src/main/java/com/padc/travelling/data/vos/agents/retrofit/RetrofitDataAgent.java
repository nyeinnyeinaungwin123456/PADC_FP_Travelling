package com.padc.travelling.data.vos.agents.retrofit;

import android.util.Log;

import com.padc.travelling.data.vos.agents.TourPackageDataAgent;
import com.padc.travelling.data.vos.model.TourPackageModel;
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
                    Log.e("RetrofitDataAgent", "onResponse Success");
                    TourPackageListResponse tourpackageListResponse = response.body();
                    if (tourpackageListResponse == null) {
                        TourPackageModel.getInstance().notifyErrorInLoadingAttractions(response.message());
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
                TourPackageModel.getInstance().notifyErrorInLoadingAttractions(throwable.getMessage());
                Log.e("RetrofitDataAgent", "onResponse Fail");
            }
        });
    }


}

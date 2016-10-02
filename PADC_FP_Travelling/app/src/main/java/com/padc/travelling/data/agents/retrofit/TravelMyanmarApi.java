package com.padc.travelling.data.agents.retrofit;

import com.padc.travelling.data.responses.AttractionPlacesListResponse;
import com.padc.travelling.data.responses.BusComponiesResponse;
import com.padc.travelling.data.responses.HotelsListResponse;
import com.padc.travelling.data.responses.RestaurantsListResponse;
import com.padc.travelling.data.responses.TourPackageListResponse;
import com.padc.travelling.utils.TravellingConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aung on 7/9/16.
 */
public interface TravelMyanmarApi {

//    @FormUrlEncoded
//    @POST(TravellingConstants.API_GET_TOURPACKAGE_LIST)
//    Call<TourPackageListResponse> loadTourPackage(
//            @Field(TravellingConstants.PARAM_ACCESS_TOKEN) String param);

    @FormUrlEncoded
    @POST(TravellingConstants.API_GETHOTELS_LIST)
    Call<HotelsListResponse> loadHotels(
            @Field(TravellingConstants.PARAM_ACCESS_TOKEN) String param);


    @FormUrlEncoded
    @POST(TravellingConstants.API_GET_RESTAURANT_LIST)
    Call<RestaurantsListResponse> loadRestaurants(
            @Field(TravellingConstants.PARAM_ACCESS_TOKEN) String param);

    @FormUrlEncoded
    @POST(TravellingConstants.API_GET_BUSCOMPONIES_LIST)
    Call<BusComponiesResponse> loadBusComponies(
            @Field(TravellingConstants.PARAM_ACCESS_TOKEN) String param);

    @FormUrlEncoded
    @POST(TravellingConstants.API_GET_TOURPACKAGE_LIST)
    Call<TourPackageListResponse> loadTourPackage(
            @Field(TravellingConstants.PARAM_ACCESS_TOKEN) String param);

    @FormUrlEncoded
    @POST(TravellingConstants.API_GET_ATTRACTIONPLACES_LIST)
    Call<AttractionPlacesListResponse> loadAttractionPlaces(
            @Field(TravellingConstants.PARAM_ACCESS_TOKEN) String param);


}

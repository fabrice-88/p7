package com.fabrice.go4lunch.service;


import android.location.Location;

import com.fabrice.go4lunch.BuildConfig;
import com.fabrice.go4lunch.model.ResultPlaces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final Gson gson = new GsonBuilder().setLenient().create();
    private static final OkHttpClient httpClient = new OkHttpClient.Builder().build();
    private static final String PLACE_URL = "https://maps.googleapis.com/maps/api/place/";
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(PLACE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    private ApiRetroService apiretroservice() {
        return retrofit.create(ApiRetroService.class);
    }

    public Call<ResultPlaces> getRestaurantPlaces(Location location) {
        return apiretroservice().getResultPlaces(locationToString(location), "restaurant", BuildConfig.MAPS_API_KEY);
    }

    private static String locationToString(Location location) {
        return location.getLatitude() + "," + location.getLongitude();
    }
}


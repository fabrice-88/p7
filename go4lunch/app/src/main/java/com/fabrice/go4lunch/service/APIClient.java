package com.fabrice.go4lunch.service;


import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/place/")
            .client(new OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
            .build();

    public static GoogleMapAPI getGoogleMapAPI() {
        return retrofit.create(GoogleMapAPI.class);
    }
}


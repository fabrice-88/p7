package com.fabrice.go4lunch.service;

import android.location.Location;

import com.fabrice.go4lunch.model.DetailsPlaces;
import com.fabrice.go4lunch.model.PlacesResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleMapAPI {

    @GET("nearbysearch/json")
    Call<PlacesResults> getNearby(@Query("location") String location,
                                  @Query("radius") int radius,
                                  @Query("type") String type,
                                  @Query("key") String key);

    @GET("details/json")
    Call<DetailsPlaces> getDetailsPlaces(@Query("place_id") String placeId,
                                         @Query("fields") String fields,
                                         @Query("key") String key);

}

package com.fabrice.go4lunch.service;

import com.fabrice.go4lunch.model.DetailsPlaces;
import com.fabrice.go4lunch.model.AutoCompletePlace;
import com.fabrice.go4lunch.model.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRetroService {

    @GET("nearbysearch/json")
    Call<List<Place>> getNearby(@Query("location") String location,
                                @Query("radius") int radius,
                                @Query("type") String type,
                                @Query("keyword") String keyword,
                                @Query("key") String key);

    @GET("details/json")
    Call<DetailsPlaces> getDetailsPlaces(@Query("place_id") String placeId,
                                         @Query("fields") String fields,
                                         @Query("key") String key);

    @GET("autocomplete/json")
    Call<AutoCompletePlace> getAutoCompletePlace(@Query("input") String input,
                                                 @Query("type") String type,
                                                 @Query("location") String location,
                                                 @Query("radius") String radius,
                                                 @Query("key") String key);
}

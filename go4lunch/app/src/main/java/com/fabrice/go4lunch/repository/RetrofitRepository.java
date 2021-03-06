package com.fabrice.go4lunch.repository;


import android.location.Location;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.fabrice.go4lunch.BuildConfig;
import com.fabrice.go4lunch.callback.OnGetPlaces;
import com.fabrice.go4lunch.model.PlacesResults;
import com.fabrice.go4lunch.model.Result;
import com.fabrice.go4lunch.service.GoogleMapAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRepository {

    private final GoogleMapAPI mGoogleMapAPI;

    public RetrofitRepository(GoogleMapAPI googleMapAPI) {
        this.mGoogleMapAPI = googleMapAPI;
    }

    public void getPlaceResults(Location location, OnGetPlaces onGetPlaces) {
        String locationFormatted = location.getLatitude()+"," + location.getLongitude();
        mGoogleMapAPI.getNearby(locationFormatted,1000, "restaurant", BuildConfig.MAPS_API_KEY).enqueue(new Callback<PlacesResults>() {
            @Override
            public void onResponse(@NonNull Call<PlacesResults> call, @NonNull Response<PlacesResults> response) {
                assert response.body() != null;
                onGetPlaces.onGetplacesData(response.body().getResults());
            }
            @Override
            public void onFailure(@NonNull Call<PlacesResults> call, @NonNull Throwable t) {
            }
        });
    }
}

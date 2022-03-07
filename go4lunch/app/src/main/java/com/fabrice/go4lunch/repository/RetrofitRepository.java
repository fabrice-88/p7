package com.fabrice.go4lunch.repository;


import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.fabrice.go4lunch.BuildConfig;
import com.fabrice.go4lunch.model.PlacesResults;
import com.fabrice.go4lunch.model.Result;
import com.fabrice.go4lunch.service.GoogleMapAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRepository {

    private final GoogleMapAPI mGoogleMapAPI;

    public RetrofitRepository(GoogleMapAPI googleMapAPI) {
        this.mGoogleMapAPI = googleMapAPI;
    }

    public MutableLiveData <List<Result>> getPlaceResultsLiveData() {
        MutableLiveData <List<Result>> PlaceResultsMutableLiveData = new MutableLiveData<>();
        mGoogleMapAPI.getNearby(1000, "restaurant", BuildConfig.MAPS_API_KEY).enqueue(new Callback<PlacesResults>() {
                @Override
                public void onResponse(@NonNull Call<PlacesResults> call, @NonNull Response<PlacesResults> response) {
                    assert response.body() != null;
                    PlaceResultsMutableLiveData.setValue(response.body().getResults());
                }
                @Override
                public void onFailure(@NonNull Call<PlacesResults> call, @NonNull Throwable t) {
                    PlaceResultsMutableLiveData.setValue(null);
                }
            });
        return PlaceResultsMutableLiveData;
    }
}

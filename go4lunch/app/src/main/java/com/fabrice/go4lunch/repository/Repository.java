package com.fabrice.go4lunch.repository;

import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.model.User;
import com.fabrice.go4lunch.service.ApiService;

import java.util.ArrayList;

public class Repository {

    private final ApiService mApiService;

    public Repository(ApiService apiService){

        this.mApiService = apiService;
    }

    public ArrayList<Restaurant> getRestaurants(){
        return mApiService.getRestaurants();
    }

    public ArrayList<User> getUser(){
        return mApiService.getUser();
    }
}

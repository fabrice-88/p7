package com.fabrice.go4lunch.service;

import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.model.User;

import java.util.ArrayList;

public class FakeApiService implements ApiService {

    private final ArrayList<Restaurant> mRestaurants = FakeGenerator.generateRestaurant();
    private final ArrayList<User> mUsers = FakeGenerator.generateUser();

    @Override
    public ArrayList<Restaurant> getRestaurants() {
        return mRestaurants;
    }

    @Override
    public ArrayList<User> getUser() {
        return mUsers;
    }

}

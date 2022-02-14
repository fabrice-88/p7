package com.fabrice.go4lunch.service;

import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.model.User;

import java.util.List;

public class FakeApiService implements ApiService {

    private final List<Restaurant> mRestaurants = FakeGenerator.generateRestaurant();
    private final List<User> mUsers = FakeGenerator.generateUser();


    @Override
    public List<Restaurant> getRestau() {
        return mRestaurants;
    }

    @Override
    public List<User> getUser() {
        return mUsers;
    }
}

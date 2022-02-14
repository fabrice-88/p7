package com.fabrice.go4lunch.service;

import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.model.User;

import java.util.List;

public interface ApiService {

    List<Restaurant> getRestau();

    List<User> getUser();

}

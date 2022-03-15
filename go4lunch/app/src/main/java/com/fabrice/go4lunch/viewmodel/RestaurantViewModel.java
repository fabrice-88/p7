package com.fabrice.go4lunch.viewmodel;

import android.location.Location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.model.Result;
import com.fabrice.go4lunch.repository.Repository;
import com.fabrice.go4lunch.repository.RetrofitRepository;

import java.util.ArrayList;
import java.util.List;

public class RestaurantViewModel extends ViewModel {

    Repository mRepository;
    RetrofitRepository mRetrofitRepository;
    MutableLiveData<ArrayList<Restaurant>> mRestaurantList;
    MutableLiveData <List<Result>> PlaceResultsMutableLiveData = new MutableLiveData<>();


    public MutableLiveData<ArrayList<Restaurant>> getMutableLiveDataRestaurant() {
        return mRestaurantList;
    }

    public RestaurantViewModel(Repository repository, RetrofitRepository retrofitRepository){
        mRetrofitRepository = retrofitRepository;
        mRepository = repository;
        mRestaurantList = new MutableLiveData<>();
    }

//    public void initListRestaurantMutableLiveData() {
//        PlaceResultsMutableLiveData = mRetrofitRepository.getPlaceResultsLiveData();
//    }



    public void initRestaurant(){
        ArrayList<Restaurant> restaurants = mRepository.getRestaurants();
        mRestaurantList.setValue(restaurants);
    }
}

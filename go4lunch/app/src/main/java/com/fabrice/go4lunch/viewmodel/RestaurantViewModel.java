package com.fabrice.go4lunch.viewmodel;

import android.location.Location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fabrice.go4lunch.model.Result;
import com.fabrice.go4lunch.repository.RetrofitRepository;

import java.util.ArrayList;
import java.util.List;

public class RestaurantViewModel extends ViewModel {

    RetrofitRepository mRetrofitRepository;
    public MutableLiveData <List<Result>> mPlaceResultsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData <List<Result>> mDetailsPlaceResultsMutableLiveData = new MutableLiveData<>();

    List<Result> mResultList = new ArrayList<>();

    // dès que l'utilisateur ouvre sa map faire le call sur nearby search
    // renvoi liste des restaurants
    // faire une boucle for sur tous les restaurants et pour chaque restaurants call details
    // details renvoi un restaurant avec toutes ses infos
    // pour chaque restaurant renvoyé par details l'ajouter à une mutablelivadata<list<Restaurant>>
    // observer cette liste depuis les fragments

    public RestaurantViewModel(RetrofitRepository retrofitRepository){
        mRetrofitRepository = retrofitRepository;
    }

    public void initListRestaurantMutableLiveData(Location location) {
        mRetrofitRepository.getPlaceResults(location, places -> {
            mPlaceResultsMutableLiveData.setValue(places);

            for (Result r : places){
                mRetrofitRepository.getPlacetDetails(r.getPlace_id(), restaurantDetails -> {
                    mResultList.add(restaurantDetails);
                    mDetailsPlaceResultsMutableLiveData.setValue(mResultList);
                });
            }
        });
    }
}

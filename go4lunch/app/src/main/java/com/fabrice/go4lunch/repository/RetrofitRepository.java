package com.fabrice.go4lunch.repository;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fabrice.go4lunch.model.ResultPlacesDetails;
import com.fabrice.go4lunch.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

public class RetrofitRepository {

    private final RetrofitService mRetrofitService;
    private final MutableLiveData<List<ResultPlacesDetails>> mResultPlacesDetails = new MutableLiveData<>(new ArrayList<>());

    public RetrofitRepository(RetrofitService retrofitService) {
        mRetrofitService = retrofitService;
    }

    public LiveData<List<ResultPlacesDetails>> getResultPlacesDetailsLiveData() {
        return mResultPlacesDetails;
    }



}

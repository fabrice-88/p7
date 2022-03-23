package com.fabrice.go4lunch.callback;

import com.fabrice.go4lunch.model.Result;

import java.util.List;

public interface OnGetPlaces {
    void onGetplacesData(List<Result> places);
}

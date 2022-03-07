package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaceResults {

    @SerializedName("results")
    @Expose
    private final List<Result> results;

    public PlaceResults(List<Result> results) {
        this.results = results;

    }

    public List<Result> getResult() {
        return results;
    }

}


package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaceAutoComplete {

    @SerializedName("status")
    @Expose
    private final String status;

    @SerializedName("predictions")
    @Expose
    private final List<PlaceAutoCompletePrediction> predictions;

    public PlaceAutoComplete(String status, List<PlaceAutoCompletePrediction> predictions) {
        this.status = status;
        this.predictions = predictions;
    }

    public String getStatus() {
        return status;
    }

    public List<PlaceAutoCompletePrediction> getPredictions() {
        return predictions;
    }
}

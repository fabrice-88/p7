package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsPlaces {

    @SerializedName("status")
    @Expose
    private final String status;

    @SerializedName("details")
    @Expose
    private final PlacesResults details;

    public DetailsPlaces(String status, PlacesResults details) {
        this.status = status;
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public PlacesResults getDetails() {
        return details;
    }
}

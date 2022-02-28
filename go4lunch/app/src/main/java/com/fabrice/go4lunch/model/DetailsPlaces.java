package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsPlaces {

    @SerializedName("status")
    @Expose
    private final String status;

    @SerializedName("details")
    @Expose
    private final ResultPlacesDetails details;

    public DetailsPlaces(String status, ResultPlacesDetails details) {
        this.status = status;
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public ResultPlacesDetails getDetails() {
        return details;
    }
}

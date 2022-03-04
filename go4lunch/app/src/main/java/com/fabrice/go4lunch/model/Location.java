package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsLocation {

    @SerializedName("lat")
    @Expose
    private final Double lat;

    @SerializedName("lng")
    @Expose
    private final Double lng;

    public DetailsLocation(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }
}

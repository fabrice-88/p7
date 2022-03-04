package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsGeometry {

    @SerializedName("location")
    @Expose
    private final DetailsLocation location;

    public DetailsGeometry(DetailsLocation location) {
        this.location = location;
    }

    public DetailsLocation getLocation() {
        return location;
    }
}

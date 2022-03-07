package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geometry {

    @SerializedName("location")
    @Expose
    private final Location location;

    public Geometry(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}

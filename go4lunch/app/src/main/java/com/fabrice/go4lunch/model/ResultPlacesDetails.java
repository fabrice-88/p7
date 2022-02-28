package com.fabrice.go4lunch.model;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultPlacesDetails {

    @SerializedName("place_id")
    @Expose
    private final String place_id;

    @SerializedName("geometry")
    @Expose
    private final DetailsGeometry geometry;

    @SerializedName("name")
    @Expose
    private final String name;

    @SerializedName("opening_hours")
    @Expose
    private final DetailsOpeningHours opening_hours;

    @SerializedName("website")
    @Expose
    private final String website;

    @SerializedName("phone_number")
    @Expose
    private final String phone_number;

    @SerializedName("address")
    @Expose
    private final String address;

    @SerializedName("rating")
    @Expose
    private Float rating;

    @SerializedName("photos")
    @Expose
    private final List<DetailsPhoto> photos;

    public ResultPlacesDetails(String place_id, DetailsGeometry geometry, String name, DetailsOpeningHours opening_hours, String website, String phone_number, String address, Float rating, List<DetailsPhoto> photos) {
        this.place_id = place_id;
        this.geometry = geometry;
        this.name = name;
        this.opening_hours = opening_hours;
        this.website = website;
        this.phone_number = phone_number;
        this.address = address;
        this.rating = rating;
        this.photos = photos;
    }

    public String getPlace_id() {
        return place_id;
    }

    public DetailsGeometry getGeometry() {
        return geometry;
    }

    public Location getLocation() {
        Location location = new Location("");
        location.setLatitude(geometry.getLocation().getLat());
        location.setLongitude(geometry.getLocation().getLng());
        return location;
    }

    public String getName() {
        return name;
    }

    public DetailsOpeningHours getOpening_hours() {
        return opening_hours;
    }

    public String getWebsite() {
        return website;
    }

    public String phone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public Float getRating() {
        return rating;
    }

    public List<DetailsPhoto> getPhotos() {
        return photos;
    }
}

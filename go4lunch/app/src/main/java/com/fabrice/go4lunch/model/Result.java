package com.fabrice.go4lunch.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("place_id")
    @Expose
    private final String place_id;

    @SerializedName("type")
    @Expose
    private final String type;

    @SerializedName("geometry")
    @Expose
    private final Geometry geometry;

    @SerializedName("name")
    @Expose
    private final String name;

    @SerializedName("opening_hours")
    @Expose
    private final OpeningHours opening_hours;

    @SerializedName("website")
    @Expose
    private final String website;

    @SerializedName("phone_number")
    @Expose
    private final String phone_number;

    @SerializedName("formatted_address")
    @Expose
    private final String address;

    @SerializedName("rating")
    @Expose
    private final Float rating;

    @SerializedName("photos")
    @Expose
    private final List<Photo> photos;

    @SerializedName("vicinity")
    @Expose
    private String vicinity;

    public Result(String place_id, String type, Geometry geometry, String name, OpeningHours opening_hours, String website, String phone_number, String address, Float rating, List<Photo> photos, String vicinity) {
        this.place_id = place_id;
        this.type = type;
        this.geometry = geometry;
        this.name = name;
        this.opening_hours = opening_hours;
        this.website = website;
        this.phone_number = phone_number;
        this.address = address;
        this.rating = rating;
        this.photos = photos;
        this.vicinity = vicinity;
    }

    public String getVicinity() {
        return vicinity;
    }

    public String getPlace_id() {
        return place_id;
    }

    public String getType() {
        return type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public String getName() {
        return name;
    }

    public OpeningHours getOpening_hours() {
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

    public List<Photo> getPhotos() {
        return photos;
    }
}

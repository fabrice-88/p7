package com.fabrice.go4lunch.model;

public class Restaurant {

    private Integer id;
    private String name;
    private String address;
    private String openingHours;
    private String distance;
    private final String photoUrl;

    public Restaurant(Integer id, String name, String address, String openingHours, String distance, String photoUrl) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.openingHours = openingHours;
        this.distance = distance;
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}

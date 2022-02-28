package com.fabrice.go4lunch.model;

public class User {

    private Integer uid;
    private String firstname;
    private String photoUrl;
    private String RestaurantId;
    private Boolean notificationActive;

    public User(Integer uid, String firstname, String photoUrl, String RestaurantId, Boolean notificationActive) {
        this.uid = uid;
        this.firstname = firstname;
        this.photoUrl = photoUrl;
        this.RestaurantId = RestaurantId;
        this.notificationActive = notificationActive;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(String RestaurantId) {
        this.RestaurantId = RestaurantId;
    }

    public Boolean isNotificationActive() {
        return notificationActive;
    }

    public void setNotificationActive(Boolean notificationActive) {
        this.notificationActive = notificationActive;
    }
}

package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailsPhoto {

    @SerializedName("height")
    @Expose
    private final Integer height;

    @SerializedName("width")
    @Expose
    private final Integer width;

    @SerializedName("photo")
    @Expose
    private final String photo;

    public DetailsPhoto(Integer height, Integer width, List<String> html_attributions, String photo) {
        this.height = height;
        this.width = width;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }
}

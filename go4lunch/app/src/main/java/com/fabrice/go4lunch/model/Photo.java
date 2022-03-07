package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Photo {

    @SerializedName("height")
    @Expose
    private final Integer height;

    @SerializedName("width")
    @Expose
    private final Integer width;

    @SerializedName("html_attributions")
    @Expose
    private  List<String> html_attributions = new ArrayList<>();

    @SerializedName("photo_reference")
    @Expose
    private final String photo_reference;

    public Photo(Integer height, Integer width, List<String> html_attributions, String photo_reference) {
        this.height = height;
        this.width = width;
        this.html_attributions = html_attributions;
        this.photo_reference = photo_reference;
    }

    public String getPhoto() {
        return photo_reference;
    }
}

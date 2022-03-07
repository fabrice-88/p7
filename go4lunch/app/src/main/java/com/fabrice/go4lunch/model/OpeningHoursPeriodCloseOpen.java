package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpeningHoursPeriodCloseOpen {


    @SerializedName("day")
    @Expose
    private final int day;

    @SerializedName("time")
    @Expose
    private final String time;

    public OpeningHoursPeriodCloseOpen(int day, String time) {
        this.day = day;
        this.time = time;
    }

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}

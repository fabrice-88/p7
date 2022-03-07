package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpeningHours {

    @SerializedName("open_now")
    @Expose
    private final Boolean open_now;

    @SerializedName("periods")
    @Expose
    private final List<OpeningHoursPeriod> periods;

    public OpeningHours(Boolean open_now, List<OpeningHoursPeriod> periods) {
        this.open_now = open_now;
        this.periods = periods;
    }

    public Boolean getOpen_now() {
        return open_now;
    }

    public List<OpeningHoursPeriod> getPeriods() { return periods; }
}

package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpeningHoursPeriod {

    @SerializedName("close")
    @Expose
    private final OpeningHoursPeriodCloseOpen close;

    @SerializedName("open")
    @Expose
    private final OpeningHoursPeriodCloseOpen open;

    public OpeningHoursPeriod(OpeningHoursPeriodCloseOpen close, OpeningHoursPeriodCloseOpen open) {
        this.close = close;
        this.open = open;
    }

    public OpeningHoursPeriodCloseOpen getClose() {
        return close;
    }

    public OpeningHoursPeriodCloseOpen getOpen() {
        return open;
    }
}

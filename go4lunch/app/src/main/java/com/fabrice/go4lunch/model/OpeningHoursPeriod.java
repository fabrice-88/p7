package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsOpeningHoursPeriod {

    @SerializedName("close")
    @Expose
    private final DetailsOpeningHoursPeriodCloseOpen close;

    @SerializedName("open")
    @Expose
    private final DetailsOpeningHoursPeriodCloseOpen open;

    public DetailsOpeningHoursPeriod(DetailsOpeningHoursPeriodCloseOpen close, DetailsOpeningHoursPeriodCloseOpen open) {
        this.close = close;
        this.open = open;
    }

    public DetailsOpeningHoursPeriodCloseOpen getClose() {
        return close;
    }

    public DetailsOpeningHoursPeriodCloseOpen getOpen() {
        return open;
    }
}

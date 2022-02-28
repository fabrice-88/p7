package com.fabrice.go4lunch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultPlaces {

        @SerializedName("status")
        @Expose
        private final String status;

        @SerializedName("results")
        @Expose
        private final List<ResultPlacesDetails> results;

        public ResultPlaces(String status, List<ResultPlacesDetails> results) {
            this.status = status;
            this.results = results;
        }

        public String getStatus() {
            return status;
        }

        public List<ResultPlacesDetails> getResults() {
            return results;
        }
}


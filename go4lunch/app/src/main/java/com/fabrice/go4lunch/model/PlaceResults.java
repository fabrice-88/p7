package com.fabrice.go4lunch.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Place {

        @SerializedName("result")
        @Expose
        private final List<Result> result;

        public Place(List<Result> result) {
            this.result = result;
        }

        public List<Result> getResult() {
            return result;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place that = (Place) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @NonNull
    @Override
    public String toString() {
        return "Place{" +
                "result=" + result +
                '}';
    }
}


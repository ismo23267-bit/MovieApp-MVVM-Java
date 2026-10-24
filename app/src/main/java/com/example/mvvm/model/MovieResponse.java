
package com.example.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<TmdbMovie> results;

    public int getPage() {
        return page;
    }

    public List<TmdbMovie> getResults() {
        return results;
    }
}


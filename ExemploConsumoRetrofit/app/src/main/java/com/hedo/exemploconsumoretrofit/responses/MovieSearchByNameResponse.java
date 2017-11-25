package com.hedo.exemploconsumoretrofit.responses;

import com.google.gson.annotations.SerializedName;
import com.hedo.exemploconsumoretrofit.model.MoviePreview;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Criado por hedo.junior em 22/11/2017.
 */

public class MovieSearchByNameResponse implements Serializable {

    @SerializedName("Response")
    private String responseSucceeded;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("Search")
    private ArrayList<MoviePreview> moviePreviews;

    public boolean isResponseSucceeded() {
        return responseSucceeded.equalsIgnoreCase("true");
    }

    public void setResponseSucceeded(String responseSucceeded) {
        this.responseSucceeded = responseSucceeded;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<MoviePreview> getMoviePreviews() {
        return moviePreviews;
    }

    public void setMoviePreviews(ArrayList<MoviePreview> moviePreviews) {
        this.moviePreviews = moviePreviews;
    }
}

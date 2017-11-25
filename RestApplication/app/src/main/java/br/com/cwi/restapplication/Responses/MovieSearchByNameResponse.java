package br.com.cwi.restapplication.Responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import br.com.cwi.restapplication.Models.MovieModel;

/**
 * Created by juliano.nardon on 25/11/17.
 */

public class MovieSearchByNameResponse {

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("Response")
    private String response;

    @SerializedName("Search")
    private ArrayList<MovieModel> search;

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ArrayList<MovieModel> getSearch() {
        return search;
    }

    public void setSearch(ArrayList<MovieModel> search) {
        this.search = search;
    }
}

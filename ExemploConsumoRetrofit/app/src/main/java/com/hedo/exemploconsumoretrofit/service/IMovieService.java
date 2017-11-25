package com.hedo.exemploconsumoretrofit.service;

import com.hedo.exemploconsumoretrofit.utils.Constants;
import com.hedo.exemploconsumoretrofit.model.MovieDetail;
import com.hedo.exemploconsumoretrofit.responses.MovieSearchByNameResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Criado por hedo.junior em 22/11/2017.
 */

public interface IMovieService {

    @GET(Constants.OMDB_MOVIE_SEARCH)
    Call<MovieSearchByNameResponse> searchMovies(@Query("s") String title);

//    @GET(Constants.OMDB_MOVIE_BY_IMDB_CODE)
//    Call<MovieDetail> getMovieByImdbID(@Query("i") String imdbId);

}

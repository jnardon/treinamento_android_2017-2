package com.hedo.exemploconsumoretrofit.service;

import com.google.gson.GsonBuilder;
import com.hedo.exemploconsumoretrofit.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Criado por hedo.junior em 22/11/2017.
 */

public class MovieService {
    private static IMovieService movieService;

    private MovieService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.OMDB_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        movieService = retrofit.create(IMovieService.class);
    }

    public static IMovieService getInstance() {
        if (movieService == null) {
            new MovieService();
        }

        return movieService;
    }
}

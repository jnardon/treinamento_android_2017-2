package br.com.cwi.restapplication.Services;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by juliano.nardon on 25/11/17.
 */

public class NetworkService {

    private MovieService movieService;
    private static NetworkService networkService;

    private NetworkService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        movieService = retrofit.create(MovieService.class);
    }

    public static NetworkService getInstance() {
        if (networkService == null) {
            networkService = new NetworkService();
        }

        return networkService;
    }

    public MovieService getMovieService() {
        return movieService;
    }
}

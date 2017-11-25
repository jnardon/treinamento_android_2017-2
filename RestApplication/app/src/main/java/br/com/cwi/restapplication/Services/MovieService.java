package br.com.cwi.restapplication.Services;

import br.com.cwi.restapplication.Responses.MovieSearchByNameResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by juliano.nardon on 25/11/17.
 */

public interface MovieService {

    @GET("/?apikey=77cde810&r=json&plot=short")
    Call<MovieSearchByNameResponse> searchMovies(@Query("s") String title);
}

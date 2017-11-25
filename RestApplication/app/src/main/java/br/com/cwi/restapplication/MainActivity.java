package br.com.cwi.restapplication;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;

import br.com.cwi.restapplication.Responses.MovieSearchByNameResponse;
import br.com.cwi.restapplication.Services.MovieService;
import br.com.cwi.restapplication.Services.NetworkService;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<MovieSearchByNameResponse> {

    private MovieService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRetrofit();
    }

    private void setUpRetrofit() {
        movieService = NetworkService.getInstance().getMovieService();

        movieService.searchMovies("ït").enqueue(this);
    }

    @Override
    public void onResponse(retrofit2.Call<MovieSearchByNameResponse> call, Response<MovieSearchByNameResponse> response) {
       Log.d("bombou", response.body().toString());
    }

    @Override
    public void onFailure(retrofit2.Call<MovieSearchByNameResponse> call, Throwable t) {
        Log.e("erro", t.getMessage());
    }
}

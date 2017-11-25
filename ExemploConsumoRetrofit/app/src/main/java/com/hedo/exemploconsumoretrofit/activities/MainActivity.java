package com.hedo.exemploconsumoretrofit.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.hedo.exemploconsumoretrofit.R;
import com.hedo.exemploconsumoretrofit.adapters.MoviePreviewAdapter;
import com.hedo.exemploconsumoretrofit.model.MoviePreview;
import com.hedo.exemploconsumoretrofit.responses.MovieSearchByNameResponse;
import com.hedo.exemploconsumoretrofit.service.IMovieService;
import com.hedo.exemploconsumoretrofit.service.MovieService;
import com.hedo.exemploconsumoretrofit.utils.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<MovieSearchByNameResponse> {

    private RecyclerView rvMoviePreviews;
    private EditText etQuery;
    private ImageButton ibSearch;

    private IMovieService movieService;

    private MoviePreviewAdapter moviePreviewAdapter;

    private ArrayList<MoviePreview> moviePreviews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieService = MovieService.getInstance();
        initializeComponents();
    }

    private void initializeComponents() {
        rvMoviePreviews = findViewById(R.id.movies_container_rv);
        etQuery = findViewById(R.id.movie_query_et);
        ibSearch = findViewById(R.id.movie_search_ib);
        ibSearch.setOnClickListener(this);
        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        rvMoviePreviews.setLayoutManager(layoutManager);
        moviePreviewAdapter = new MoviePreviewAdapter(moviePreviews);
        rvMoviePreviews.setAdapter(moviePreviewAdapter);
    }

    @Override
    public void onClick(View v) {
        String query = etQuery.getText().toString();
        if (!query.isEmpty()) {
            movieService.searchMovies(query).enqueue(this);
        }
    }

    @Override
    public void onResponse(@NonNull Call<MovieSearchByNameResponse> call, @NonNull Response<MovieSearchByNameResponse> response) {
        if (response.body().isResponseSucceeded()) {
            moviePreviewAdapter.setmItemList(response.body().getMoviePreviews());
            moviePreviewAdapter.notifyDataSetChanged();

        } else {
            Toast.makeText(this, "Não encontramos nenhum filme com este termo.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<MovieSearchByNameResponse> call, @NonNull Throwable t) {
        Toast.makeText(this, "Não foi possível efetuar a busca", Toast.LENGTH_SHORT).show();
        Log.e(Constants.LOG, "MainActivity.onFailure: " + t.getMessage(), t);
    }
}

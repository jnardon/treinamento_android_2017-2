package br.com.cwi.restapplication;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import br.com.cwi.restapplication.Adapters.MoviewListAdapter;
import br.com.cwi.restapplication.Models.MovieModel;
import br.com.cwi.restapplication.Responses.MovieSearchByNameResponse;
import br.com.cwi.restapplication.Services.MovieService;
import br.com.cwi.restapplication.Services.NetworkService;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<MovieSearchByNameResponse> {

    private MovieService movieService;
    private EditText editText;
    private RecyclerView recyclerView;
    private MoviewListAdapter adapter;
    private ArrayList<MovieModel> movieModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpLayout();
        setUpRetrofit();
    }

    private void setUpLayout() {
        editText= findViewById(R.id.edit_text);
        recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MoviewListAdapter(movieModels);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieService.searchMovies(editText.getText().toString()).enqueue(MainActivity.this);
            }
        });
    }

    private void setUpRetrofit() {
        movieService = NetworkService.getInstance().getMovieService();
    }

    @Override
    public void onResponse(retrofit2.Call<MovieSearchByNameResponse> call, Response<MovieSearchByNameResponse> response) {
       if (response.body().getResponse().equalsIgnoreCase("True")) {
           movieModels = response.body().getSearch();
           adapter.setItemList(movieModels);
           adapter.notifyDataSetChanged();
       }
    }

    @Override
    public void onFailure(retrofit2.Call<MovieSearchByNameResponse> call, Throwable t) {
        Log.e("erro", t.getMessage());
    }
}

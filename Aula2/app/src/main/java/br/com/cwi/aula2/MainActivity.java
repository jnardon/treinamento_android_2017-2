package br.com.cwi.aula2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import br.com.cwi.aula2.RecyclerView.LineAdapter;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.recycler_view);
        populateList();
        setUpRecylerView();
    }

    private void setUpRecylerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        LineAdapter adapter = new LineAdapter(this.list);
        recyclerView.setAdapter(adapter);
    }

    private void populateList() {
        list.add("Luke");
        list.add("Leia");
        list.add("Anakin");
        list.add("Obi-Wan");
        list.add("Boba Fett");
        list.add("Lando");
        list.add("Darth Vader");
        list.add("Hans Solo");
        list.add("R2-D2");
        list.add("C3PO");
        list.add("BB8");
    }
}

















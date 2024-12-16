package com.example.listmovieconan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listmovieconan.httpclient.ApiClient;
import com.example.listmovieconan.model.DataItem;
import com.example.listmovieconan.model.ResponseMovie;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import androidx.recyclerview.widget.GridLayoutManager;
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));// Menampilkan dalam grid

        fetchMovies();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about_page) {
            showIcon();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showIcon() {
        Intent aboutIntent = new Intent(MainActivity.this, about.class);
        startActivity(aboutIntent);
    }
    private void fetchMovies() {
        Call<ResponseMovie> call = ApiClient.getApiInterface().getMovie();

        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<DataItem> movies = response.body().getData();
                    movieAdapter = new MovieAdapter(MainActivity.this, movies);
                    recyclerView.setAdapter(movieAdapter);

                    // Menambahkan klik listener pada item RecyclerView
                    movieAdapter.setOnItemClickListener((view, position) -> {
                        DataItem movie = movies.get(position);

                        // Kirim data film ke DetailActivity
                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        intent.putExtra("movie_data", movie); // Mempassing data film
                        startActivity(intent);
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Failed to fetch movies", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


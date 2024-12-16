package com.example.listmovieconan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.listmovieconan.model.DataItem;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewPoster;
    private TextView textViewJudul, textViewSinopsis, textViewDurasi, textViewTanggalRilis;
    private Button buttonVideo;

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
        Intent aboutIntent = new Intent(DetailActivity.this, about.class);
        startActivity(aboutIntent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Inisialisasi views
        imageViewPoster = findViewById(R.id.imageViewPoster);
        textViewJudul = findViewById(R.id.textViewJudul);
        textViewSinopsis = findViewById(R.id.textViewSinopsis);
        textViewDurasi = findViewById(R.id.textViewDurasi);
        textViewTanggalRilis = findViewById(R.id.textViewTanggalRilis);
        buttonVideo = findViewById(R.id.buttonVideo);

        // Ambil DataItem yang dikirim dari MainActivity
        DataItem movie = (DataItem) getIntent().getSerializableExtra("movie_data");

        // Cek apakah objek movie tidak null
        if (movie != null) {
            // Set data film ke dalam views
            textViewJudul.setText(movie.getJudul());
            textViewSinopsis.setText(movie.getSinopsis());
            textViewDurasi.setText(movie.getDurasiFilm());
            textViewTanggalRilis.setText(movie.getTanggalRilis());

            // Memuat gambar poster menggunakan Glide
            Glide.with(this)
                    .load(movie.getPoster()) // URL poster
                    .placeholder(R.drawable.placeholder) // Placeholder jika gambar belum dimuat
                    .into(imageViewPoster);

            // Set action ketika tombol video ditekan
            buttonVideo.setOnClickListener(v -> {
                String videoUrl = movie.getVideo(); // Ambil URL video dari DataItem
                if (videoUrl != null && !videoUrl.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
                    startActivity(intent); // Membuka URL video di browser atau aplikasi terkait
                } else {
                    // Menangani kasus jika URL video tidak tersedia
                    textViewSinopsis.append("\n\nVideo tidak tersedia.");
                }
            });
        } else {
            // Tangani jika objek movie null
            textViewJudul.setText("Movie data not available");
        }
    }
}

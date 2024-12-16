package com.example.listmovieconan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.listmovieconan.model.DataItem;
import java.util.List;
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<DataItem> movieList;
    private OnItemClickListener onItemClickListener;

    public MovieAdapter(Context context, List<DataItem> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        DataItem movie = movieList.get(position);

        // Menampilkan poster film menggunakan Glide
        Glide.with(context)
                .load(movie.getPoster())
                .placeholder(R.drawable.placeholder)
                .into(holder.imageViewPoster);

        // Menampilkan judul film
        holder.textViewJudul.setText(movie.getJudul());

        // Set listener untuk item klik
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewPoster;
        public TextView textViewJudul;

        public MovieViewHolder(View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewJudul = itemView.findViewById(R.id.textViewJudul);
        }
    }

    // Interface untuk mendeteksi klik item
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}

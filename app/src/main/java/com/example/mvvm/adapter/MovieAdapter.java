
package com.example.mvvm.adapter;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.databinding.ItemMovieBinding;
import com.example.mvvm.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private final List<Movie> movies = new ArrayList<>();

    private final OnMovieClickListener listener;

    public interface OnMovieClickListener {
        void onMovieClick(int position);
    }

    public MovieAdapter(OnMovieClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        ItemMovieBinding binding = ItemMovieBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(
            @NonNull MovieViewHolder holder,
            int position) {

        Movie movie = movies.get(position);

        holder.binding.tvMovieTitle.setText(movie.getTitle());
        holder.binding.tvMovieGenre.setText(movie.getGenre());

        holder.binding.tvMovieRating.setText(
                String.format(
                        Locale.US,
                        "★ %.1f",
                        movie.getRating()
                )
        );

        holder.binding.imgMovie.setImageResource(
                movie.getImage()
        );

        GradientDrawable background = new GradientDrawable();
        background.setColor(movie.getBackgroundColor());
        background.setCornerRadius(
                20 * holder.itemView.getResources()
                        .getDisplayMetrics().density
        );

        holder.binding.getRoot().setBackground(background);

        holder.binding.getRoot().setOnClickListener(v -> {

            int currentPosition = holder.getAdapterPosition();

            if (currentPosition != RecyclerView.NO_POSITION) {
                listener.onMovieClick(currentPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> newMovies) {
        movies.clear();

        if (newMovies != null) {
            movies.addAll(newMovies);
        }

        notifyDataSetChanged();
    }
}

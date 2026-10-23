
package com.example.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.databinding.ItemMovieBinding;
import com.example.mvvm.model.Movie;
import android.graphics.drawable.GradientDrawable;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private final List<Movie> movies = new ArrayList<>();

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        ItemMovieBinding binding = ItemMovieBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(
            @NonNull MovieViewHolder holder, int position) {

        Movie movie = movies.get(position);

        holder.binding.tvMovieTitle.setText(movie.getTitle());
        holder.binding.tvMovieGenre.setText(movie.getGenre());

        holder.binding.tvMovieRating.setText(
                "★ " + movie.getRating()
        );

        holder.binding.imgMovie.setImageResource(movie.getImage());
        GradientDrawable background =
                (GradientDrawable) holder.binding
                        .getRoot()
                        .getBackground()
                        .mutate();

        background.setColor(movie.getBackgroundColor());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> newMovies) {
        movies.clear();
        movies.addAll(newMovies);
        notifyDataSetChanged();
    }
}


package com.example.mvvm.adapter;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.databinding.ItemMovieBinding;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public final ItemMovieBinding binding;

    public MovieViewHolder(@NonNull ItemMovieBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}


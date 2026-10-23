
package com.example.mvvm.repository;

import android.graphics.Color;

import com.example.mvvm.R;
import com.example.mvvm.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    public List<Movie> getMovies() {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(
                "Fast & Furious Presents: Hobbs & Shaw",
                "Action",
                8.6,
                R.drawable.movie_hobbs_shaw,
                Color.rgb(131, 184, 233)
        ));









        return movies;
    }
}

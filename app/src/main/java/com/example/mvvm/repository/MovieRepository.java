
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
                R.drawable.ic_launcher_foreground,
                Color.rgb(131, 184, 233)
        ));

        movies.add(new Movie(
                "Once Upon a Time in Hollywood",
                "Comedy / Drama",
                9.4,
                R.drawable.ic_launcher_foreground,
                Color.rgb(217, 120, 193)
        ));

        movies.add(new Movie(
                "Angel Has Fallen",
                "Action / Thriller",
                7.1,
                R.drawable.ic_launcher_foreground,
                Color.rgb(244, 180, 97)
        ));

        movies.add(new Movie(
                "BoJack Horseman: Season 6",
                "Animation / Comedy",
                8.6,
                R.drawable.ic_launcher_foreground,
                Color.rgb(173, 137, 239)
        ));

        return movies;
    }
}

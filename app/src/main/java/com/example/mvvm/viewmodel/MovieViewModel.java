
package com.example.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.model.Movie;
import com.example.mvvm.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private final MovieRepository repository;

    private final MutableLiveData<List<Movie>> movies =
            new MutableLiveData<>();

    public MovieViewModel() {
        repository = new MovieRepository();
        loadMovies();
    }

    private void loadMovies() {
        movies.setValue(repository.getMovies());
    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }
}

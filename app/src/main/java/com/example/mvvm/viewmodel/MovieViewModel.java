
package com.example.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.model.Movie;
import com.example.mvvm.repository.MovieRepository;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    private final MutableLiveData<String> currentMonth =
            new MutableLiveData<>();

    private final MutableLiveData<String> currentDate =
            new MutableLiveData<>();

    private final MutableLiveData<String> currentTime =
            new MutableLiveData<>();

    public LiveData<String> getCurrentMonth() {
        return currentMonth;
    }

    public LiveData<String> getCurrentDate() {
        return currentDate;
    }

    public LiveData<String> getCurrentTime() {
        return currentTime;
    }

    public void updateDateTime() {

        Date now = new Date();

        SimpleDateFormat monthFormat =
                new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);

        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);

        SimpleDateFormat timeFormat =
                new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

        currentMonth.setValue(monthFormat.format(now));
        currentDate.setValue(dateFormat.format(now));
        currentTime.setValue(timeFormat.format(now));
    }

}

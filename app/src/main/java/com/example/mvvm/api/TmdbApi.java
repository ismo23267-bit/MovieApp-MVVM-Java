
package com.example.mvvm.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import com.example.mvvm.model.MovieResponse;

public interface TmdbApi {

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(
            @Header("Authorization") String token,
            @Query("language") String language,
            @Query("page") int page
    );
}

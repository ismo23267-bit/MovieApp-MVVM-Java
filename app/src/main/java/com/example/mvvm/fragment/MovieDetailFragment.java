
package com.example.mvvm.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.databinding.FragmentMovieDetailBinding;

import com.example.mvvm.model.Movie;
import com.example.mvvm.viewmodel.MovieViewModel;

import java.util.List;
import java.util.Locale;

public class MovieDetailFragment extends Fragment {

    private static final String ARG_POSITION = "movie_position";

    private FragmentMovieDetailBinding binding;

    public static MovieDetailFragment newInstance(int position) {
        MovieDetailFragment fragment = new MovieDetailFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        binding = FragmentMovieDetailBinding.inflate(
                inflater, container, false
        );

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        MovieViewModel viewModel =
                new ViewModelProvider(requireActivity())
                        .get(MovieViewModel.class);

        int position = requireArguments().getInt(ARG_POSITION, -1);

        viewModel.getMovies().observe(
                getViewLifecycleOwner(),
                movies -> {
                    if (movies == null ||
                            position < 0 ||
                            position >= movies.size()) {
                        return;
                    }

                    Movie movie = movies.get(position);

                    binding.tvDetailTitle.setText(movie.getTitle());
                    binding.tvDetailGenre.setText(movie.getGenre());

                    binding.tvDetailRating.setText(
                            String.format(
                                    Locale.US,
                                    "★ %.1f",
                                    movie.getRating()
                            )
                    );

                    binding.imgDetailPoster.setImageResource(
                            movie.getImage()
                    );
                }
        );

        binding.btnBack.setOnClickListener(v ->
                getParentFragmentManager().popBackStack()
        );
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}

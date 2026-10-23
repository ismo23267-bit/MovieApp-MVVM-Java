
package com.example.mvvm.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvm.adapter.MovieAdapter;
import com.example.mvvm.databinding.FragmentMovieListBinding;
import com.example.mvvm.viewmodel.MovieViewModel;
import com.example.mvvm.R;
public class MovieListFragment extends Fragment {

    private FragmentMovieListBinding binding;
    private MovieViewModel viewModel;
    private MovieAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        binding = FragmentMovieListBinding.inflate(
                inflater, container, false
        );

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        adapter = new MovieAdapter(position -> {

            MovieDetailFragment detailFragment =
                    MovieDetailFragment.newInstance(position);

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.fragmentContainer,
                            detailFragment
                    )
                    .addToBackStack(null)
                    .commit();
        });

        binding.recyclerViewMovies.setLayoutManager(
                new LinearLayoutManager(requireContext())
        );

        binding.recyclerViewMovies.setAdapter(adapter);

        viewModel = new ViewModelProvider(requireActivity())
                .get(MovieViewModel.class);

        viewModel.getMovies().observe(
                getViewLifecycleOwner(),
                movies -> {
                    if (movies != null) {
                        adapter.setMovies(movies);
                    }
                }
        );
    }

    @Override
    public void onDestroyView() {
        binding.recyclerViewMovies.setAdapter(null);
        adapter = null;
        binding = null;
        super.onDestroyView();
    }
}

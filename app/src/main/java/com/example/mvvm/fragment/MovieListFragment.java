
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
import android.os.Handler;
import android.os.Looper;
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
        viewModel.getCurrentMonth().observe(
                getViewLifecycleOwner(),
                month -> binding.tvMonth.setText(month)
        );

        viewModel.getCurrentDate().observe(
                getViewLifecycleOwner(),
                date -> binding.tvCurrentDate.setText(date)
        );

        viewModel.getCurrentTime().observe(
                getViewLifecycleOwner(),
                time -> binding.tvCurrentTime.setText(time)
        );
        clockHandler.removeCallbacks(clockRunnable);
        clockHandler.post(clockRunnable);
    }

    @Override
    public void onDestroyView() {
        clockHandler.removeCallbacks(clockRunnable);
        binding.recyclerViewMovies.setAdapter(null);
        adapter = null;
        binding = null;
        super.onDestroyView();
    }
    private final Handler clockHandler =
            new Handler(Looper.getMainLooper());

    private final Runnable clockRunnable = new Runnable() {
        @Override
        public void run() {
            if (binding != null && viewModel != null) {
                viewModel.updateDateTime();
                clockHandler.postDelayed(this, 1000);
            }
        }
    };
    @Override
    public void onStop() {
        clockHandler.removeCallbacks(clockRunnable);
        super.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();

        if (binding != null && viewModel != null) {
            clockHandler.removeCallbacks(clockRunnable);
            clockHandler.post(clockRunnable);
        }
    }
}

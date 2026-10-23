package com.example.mvvm;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvvm.fragment.MovieListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.fragmentContainer,
                            new MovieListFragment()
                    )
                    .commit();
        }
    }
}
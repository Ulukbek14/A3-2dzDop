package com.example.a3_2dzdop.ui.fragment.location;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.data.network.apiservice.LocationApiService;
import com.example.a3_2dzdop.databinding.FragmentLocationBinding;
import com.example.a3_2dzdop.ui.adapter.LocationAdapter;
import com.example.a3_2dzdop.ui.fragment.episode.EpisodeViewModel;

public class LocationFragment extends Fragment {

   private FragmentLocationBinding locationBinding;
   private LocationViewModel locationViewModel;
   private LocationAdapter locationAdapter = new LocationAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        locationBinding = FragmentLocationBinding.inflate(getLayoutInflater(), container, false);
        initialize();
        setupLocation();
        return locationBinding.getRoot();
    }

    private void initialize() {
        locationViewModel = new ViewModelProvider(this).get(LocationViewModel.class);
        setupLocationRecycler();
    }

    private void setupLocationRecycler() {
        locationBinding.rvLocation.setLayoutManager(new LinearLayoutManager(getContext()));
        locationBinding.rvLocation.setAdapter(locationAdapter);
    }

    private void setupLocation() {
        locationViewModel.fetchLocation().observe(getViewLifecycleOwner(), characters -> {
            locationAdapter.addLocation(characters.getResults());
        });
    }
}
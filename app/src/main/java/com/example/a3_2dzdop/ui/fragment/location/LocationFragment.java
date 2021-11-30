package com.example.a3_2dzdop.ui.fragment.location;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.base.BaseFragment;
import com.example.a3_2dzdop.data.network.apiservice.LocationApiService;
import com.example.a3_2dzdop.databinding.FragmentEpisodeDetailBinding;
import com.example.a3_2dzdop.databinding.FragmentLocationBinding;
import com.example.a3_2dzdop.ui.adapter.LocationAdapter;
import com.example.a3_2dzdop.ui.fragment.episode.EpisodeViewModel;

public class LocationFragment extends BaseFragment<LocationViewModel, FragmentLocationBinding> {

    private LocationAdapter adapter = new LocationAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    protected void setupLocation() {
        adapter.setOnItemClickListener(id -> {
            Navigation
                    .findNavController(requireView())
                    .navigate(LocationFragmentDirections
                            .actionNavigationLocationToLocationDetailFragment(id));
        });
    }

    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(LocationViewModel.class);
        setupEpisodeRecycler();
    }

    protected void setupObservers() {
        viewModel.fetchLocation().observe(getViewLifecycleOwner(), episodes -> {
            adapter.addLocation(episodes.getResults());
        });
    }

    private void setupEpisodeRecycler() {
        binding.rvLocation.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLocation.setAdapter(adapter);
    }
}
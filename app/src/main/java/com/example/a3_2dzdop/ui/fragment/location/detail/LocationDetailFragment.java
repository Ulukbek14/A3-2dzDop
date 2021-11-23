package com.example.a3_2dzdop.ui.fragment.location.detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.databinding.FragmentLocationDetailBinding;

public class LocationDetailFragment extends Fragment {

    private FragmentLocationDetailBinding binding;
    private LocationDetailViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationDetailBinding.inflate(inflater, container, false);
        initialize();
        setupRequest();
        setupObservers();
        return binding.getRoot();
    }

    private void setupObservers() {
        viewModel.location.observe(getViewLifecycleOwner(), location -> {
            binding.detailTvName.setText(location.getName());
            binding.detailTvUrl.setText(location.getUrl());
            binding.detailTvCreated.setText(location.getCreated());
        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(LocationDetailViewModel.class);
    }

    private void setupRequest() {
        viewModel.fetchEpisode(LocationDetailFragmentArgs.fromBundle(getArguments()).getId());
    }
}
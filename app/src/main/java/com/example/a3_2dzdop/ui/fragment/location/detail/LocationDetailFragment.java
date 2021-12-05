package com.example.a3_2dzdop.ui.fragment.location.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.base.BaseFragment;
import com.example.a3_2dzdop.databinding.FragmentLocationDetailBinding;

public class LocationDetailFragment extends BaseFragment<LocationDetailViewModel, FragmentLocationDetailBinding> {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(LocationDetailViewModel.class);
    }

    protected void setupRequest() {
        viewModel.fetchLocation(LocationDetailFragmentArgs.fromBundle(getArguments()).getId());
    }

    protected void setupObservers() {
        viewModel.fetchLocation(LocationDetailFragmentArgs.fromBundle(getArguments()).getId()).observe(getViewLifecycleOwner(), location -> {
            binding.detailTvName.setText(location.getName());
            binding.detailTvUrl.setText(location.getUrl());
            binding.detailTvCreated.setText(location.getCreated());
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
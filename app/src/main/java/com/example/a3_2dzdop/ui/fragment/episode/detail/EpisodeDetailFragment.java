package com.example.a3_2dzdop.ui.fragment.episode.detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.databinding.FragmentEpisodeBinding;
import com.example.a3_2dzdop.databinding.FragmentEpisodeDetailBinding;

public class EpisodeDetailFragment extends Fragment {

    private FragmentEpisodeDetailBinding binding;
    private EpisodeDetailViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodeDetailBinding.inflate(inflater, container, false);
        initialize();
        setupRequest();
        setupObservers();
        return binding.getRoot();
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(EpisodeDetailViewModel.class);
    }

    private void setupRequest() {
        viewModel.fetchEpisode(EpisodeDetailFragmentArgs.fromBundle(getArguments()).getId());
    }

    private void setupObservers() {
        viewModel.episode.observe(getViewLifecycleOwner(),episode ->{
            binding.detailTvName.setText(episode.getName());
            binding.detailTvUrl.setText(episode.getUrl());
            binding.detailTvCreated.setText(episode.getCreated());
        } );
    }
}
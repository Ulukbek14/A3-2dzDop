package com.example.a3_2dzdop.ui.fragment.episode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.data.network.apiservice.EpisodeApiService;
import com.example.a3_2dzdop.databinding.FragmentEpisodeBinding;
import com.example.a3_2dzdop.ui.adapter.EpisodeAdapter;

public class EpisodeFragment extends Fragment {

    private FragmentEpisodeBinding episodeBinding;
    private EpisodeViewModel episodeViewModel;
    private EpisodeAdapter episodeAdapter = new EpisodeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        episodeBinding = FragmentEpisodeBinding.inflate(getLayoutInflater(), container, false);
        initialize();
        setupEpisode();
        return episodeBinding.getRoot();
    }

    private void initialize() {
        episodeViewModel = new ViewModelProvider(this).get(EpisodeViewModel.class);
        setupEpisodeRecycler();
    }

    private void setupEpisodeRecycler() {
        episodeBinding.rvEpisode.setLayoutManager(new LinearLayoutManager(getContext()));
        episodeBinding.rvEpisode.setAdapter(episodeAdapter);
    }

    private void setupEpisode() {
        episodeViewModel.fetchEpisode().observe(getViewLifecycleOwner(), characters -> {
            episodeAdapter.addEpisode(characters.getResults());
        });
    }

}
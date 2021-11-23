package com.example.a3_2dzdop.ui.fragment.episode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.data.network.apiservice.EpisodeApiService;
import com.example.a3_2dzdop.databinding.FragmentCharacterBinding;
import com.example.a3_2dzdop.databinding.FragmentEpisodeBinding;
import com.example.a3_2dzdop.ui.adapter.CharacterAdapter;
import com.example.a3_2dzdop.ui.adapter.EpisodeAdapter;
import com.example.a3_2dzdop.ui.fragment.character.CharacterFragmentDirections;
import com.example.a3_2dzdop.ui.fragment.character.CharacterViewModel;

public class EpisodeFragment extends Fragment {

    private FragmentEpisodeBinding episodeBinding;
    private EpisodeViewModel viewModel;
    private EpisodeAdapter adapter = new EpisodeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        episodeBinding = FragmentEpisodeBinding.inflate(inflater, container, false);
        initialize();
        setupObserves();
        setupEpisode();
        return episodeBinding.getRoot();
    }

    private void setupEpisode() {
        adapter.setOnItemClickListener(id -> {
            Navigation
                    .findNavController(requireView())
                    .navigate(EpisodeFragmentDirections
                            .actionNavigationEpisodeToEpisodeDetailFragment(id)
            );
        });
    }
    
    private void initialize() {
        viewModel = new ViewModelProvider(this).get(EpisodeViewModel.class);
        setupEpisodeRecycler();
    }

    private void setupEpisodeRecycler() {
        episodeBinding.rvEpisode.setLayoutManager(new LinearLayoutManager(getContext()));
        episodeBinding.rvEpisode.setAdapter(adapter);
    }

    private void setupObserves() {
        viewModel.fetchEpisode().observe(getViewLifecycleOwner(), episodes ->{
            adapter.addEpisode(episodes.getResults());
        });
    }
}
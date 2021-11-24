package com.example.a3_2dzdop.ui.fragment.episode;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.base.BaseFragment;
import com.example.a3_2dzdop.databinding.FragmentEpisodeBinding;
import com.example.a3_2dzdop.ui.adapter.EpisodeAdapter;

public class EpisodeFragment extends BaseFragment {

    private FragmentEpisodeBinding episodeBinding;
    private EpisodeViewModel viewModel;
    private EpisodeAdapter adapter = new EpisodeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        episodeBinding = FragmentEpisodeBinding.inflate(inflater, container, false);
        return episodeBinding.getRoot();
    }

    protected void setupEpisode() {
        adapter.setOnItemClickListener(id -> {
            Navigation
                    .findNavController(requireView())
                    .navigate(EpisodeFragmentDirections
                            .actionNavigationEpisodeToEpisodeDetailFragment(id)
            );
        });
    }
    
    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(EpisodeViewModel.class);
        setupEpisodeRecycler();
    }

    private void setupEpisodeRecycler() {
        episodeBinding.rvEpisode.setLayoutManager(new LinearLayoutManager(getContext()));
        episodeBinding.rvEpisode.setAdapter(adapter);
    }

    @Override
    protected void setupObservers() {
        viewModel.fetchEpisode().observe(getViewLifecycleOwner(), episodes ->{
           adapter.addEpisode(episodes.getResults());
        });
    }
}
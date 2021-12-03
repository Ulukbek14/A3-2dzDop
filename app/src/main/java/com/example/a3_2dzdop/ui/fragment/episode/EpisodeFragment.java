package com.example.a3_2dzdop.ui.fragment.episode;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.base.BaseFragment;
import com.example.a3_2dzdop.data.network.dtos.episode.EpisodeModel;
import com.example.a3_2dzdop.databinding.FragmentEpisodeBinding;
import com.example.a3_2dzdop.databinding.FragmentEpisodeDetailBinding;
import com.example.a3_2dzdop.ui.adapter.EpisodeAdapter;

import java.util.ArrayList;

public class EpisodeFragment extends BaseFragment<EpisodeViewModel, FragmentEpisodeBinding> {

    private EpisodeAdapter adapter = new EpisodeAdapter();
    private LinearLayoutManager episodeLayout;
    private int visibleItemCount, totalItemCount, pastVisiblesItems;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(EpisodeViewModel.class);
        setupEpisodeRecycler();
    }

    @Override
    protected void setupNavigation() {
        adapter.setOnItemClickListener(id ->
                Navigation.
                        findNavController(requireView()).
                        navigate(EpisodeFragmentDirections.
                                actionNavigationEpisodeToEpisodeDetailFragment(id)));
    }

    private void onScrollPagination() {
        binding.rvEpisode.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.canScrollVertically(1) && dy > 0) {
                    visibleItemCount = episodeLayout.getChildCount();
                    totalItemCount = episodeLayout.getItemCount();
                    pastVisiblesItems = episodeLayout.findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        viewModel.page++;
                        viewModel.fetchEpisodes().observe(getViewLifecycleOwner(), episodes -> {
                            if (episodes != null) {
                                ArrayList<EpisodeModel> array = new ArrayList<>(adapter.getCurrentList());
                                array.addAll(episodes.getResults());
                                adapter.submitList(array);
                            }
                        });
                    }
                }
            }
        });
    }

    private void setupEpisodeRecycler() {
        episodeLayout = new LinearLayoutManager(getContext());
        binding.rvEpisode.setLayoutManager(episodeLayout);
        binding.rvEpisode.setAdapter(adapter);
    }

    protected void setupObservers() {
        viewModel.fetchEpisodes().observe(getViewLifecycleOwner(), episode -> {
            adapter.submitList(episode.getResults());
            onScrollPagination();
        });
    }
}
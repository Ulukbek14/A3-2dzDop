package com.example.a3_2dzdop.ui.fragment.location;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.base.BaseFragment;
import com.example.a3_2dzdop.data.network.apiservice.LocationApiService;
import com.example.a3_2dzdop.data.network.dtos.location.LocationModel;
import com.example.a3_2dzdop.databinding.FragmentEpisodeDetailBinding;
import com.example.a3_2dzdop.databinding.FragmentLocationBinding;
import com.example.a3_2dzdop.ui.adapter.LocationAdapter;
import com.example.a3_2dzdop.ui.fragment.episode.EpisodeViewModel;

import java.util.ArrayList;

public class LocationFragment extends BaseFragment<LocationViewModel, FragmentLocationBinding> {

    private LocationAdapter adapter = new LocationAdapter();
    private LinearLayoutManager locationsLayout;
    private int visibleItemCount, totalItemCount, pastVisiblesItems;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(LocationViewModel.class);
        setupEpisodeRecycler();
    }

    @Override
    protected void setupNavigation() {
        adapter.setOnItemClickListener(id ->
                Navigation.
                        findNavController(requireView()).
                        navigate(LocationFragmentDirections.
                                actionNavigationLocationToLocationDetailFragment(id)));
    }

    private void onScrollPagination() {
        binding.rvLocation.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.canScrollVertically(1) && dy > 0) {
                    visibleItemCount = locationsLayout.getChildCount();
                    totalItemCount = locationsLayout.getItemCount();
                    pastVisiblesItems = locationsLayout.findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        viewModel.page++;
                        viewModel.fetchLocation().observe(getViewLifecycleOwner(), locations -> {
                            if (locations != null) {
                                ArrayList<LocationModel> array = new ArrayList<>(adapter.getCurrentList());
                                array.addAll(locations.getResults());
                                adapter.submitList(array);
                            }
                        });
                    }
                }
            }
        });
    }

    private void setupEpisodeRecycler() {
        locationsLayout = new LinearLayoutManager(getContext());
        binding.rvLocation.setLayoutManager(locationsLayout);
        binding.rvLocation.setAdapter(adapter);
    }

    protected void setupObservers() {
        viewModel.fetchLocation().observe(getViewLifecycleOwner(), episodes -> {
            adapter.submitList(episodes.getResults());
            onScrollPagination();

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
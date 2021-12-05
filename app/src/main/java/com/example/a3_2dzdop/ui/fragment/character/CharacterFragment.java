package com.example.a3_2dzdop.ui.fragment.character;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_2dzdop.base.BaseFragment;
import com.example.a3_2dzdop.data.network.dtos.character.CharacterModel;
import com.example.a3_2dzdop.databinding.FragmentCharacterBinding;
import com.example.a3_2dzdop.ui.adapter.CharacterAdapter;

import java.util.ArrayList;

public class CharacterFragment extends BaseFragment<CharacterViewModel, FragmentCharacterBinding> {

    private CharacterAdapter adapter = new CharacterAdapter();
    private LinearLayoutManager characterLayout;
    private int visibleItemCount, totalItemCount, pastVisiblesItems;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
        setupCharactersRecycler();
    }

    protected void setupNavigation() {
        adapter.setOnItemClickListener(new CharacterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id) {
                Navigation.findNavController(requireView()).navigate(
                        CharacterFragmentDirections.actionNavigationCharactersToDetailFragment(id));
            }

            @Override
            public void onItemLongClick(int image) {
                Navigation.findNavController(requireView()).navigate(
                        CharacterFragmentDirections.actionNavigationCharactersToDialogFragment(image)
                );
            }
        });
    }

    private void onScrollPagination() {
        binding.rvCharacter.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.canScrollVertically(1) && dy > 0) {
                    visibleItemCount = characterLayout.getChildCount();
                    totalItemCount = characterLayout.getItemCount();
                    pastVisiblesItems = characterLayout.findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        viewModel.page++;
                        viewModel.fetchCharacters().observe(getViewLifecycleOwner(), characters -> {
                            if (characters != null) {
                                ArrayList<CharacterModel> array = new ArrayList<>(adapter.getCurrentList());
                                array.addAll(characters.getResults());
                                adapter.submitList(array);
                            }
                        });
                    }
                }
            }
        });
    }

    protected void setupObservers() {
        viewModel.fetchCharacters().observe(getViewLifecycleOwner(), characters -> {
            adapter.submitList(characters.getResults());
            onScrollPagination();
        });
    }

    private void setupCharactersRecycler() {
        characterLayout = new LinearLayoutManager(getContext());
        binding.rvCharacter.setLayoutManager(characterLayout);
        binding.rvCharacter.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
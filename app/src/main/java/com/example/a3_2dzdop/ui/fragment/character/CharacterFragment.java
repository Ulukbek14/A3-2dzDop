package com.example.a3_2dzdop.ui.fragment.character;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.databinding.FragmentCharacterBinding;
import com.example.a3_2dzdop.ui.adapter.CharacterAdapter;

public class CharacterFragment extends Fragment {

    private FragmentCharacterBinding characterBinding;
    private CharacterViewModel viewModel;
    private CharacterAdapter characterAdapter = new CharacterAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        characterBinding = FragmentCharacterBinding.inflate(inflater, container, false);
        initialize();
        setupObservers();
        setupCharacter();
        return characterBinding.getRoot();
    }

    private void setupCharacter() {
        characterAdapter.setOnItemClickListener(new CharacterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id) {
                Navigation.
                        findNavController(requireView()).
                        navigate(CharacterFragmentDirections.
                                actionNavigationCharactersToDetailFragment(id));
            }

            @Override
            public void onItemCharacterClick(int id) {
                Navigation.
                        findNavController(requireView()).
                        navigate(CharacterFragmentDirections.
                                actionNavigationCharactersToDialogFragment(id));
            }
        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
        setupCharactersRecycler();
    }

    private void setupCharactersRecycler() {
        characterBinding.rvCharacter.setLayoutManager(new LinearLayoutManager(getContext()));
        characterBinding.rvCharacter.setAdapter(characterAdapter);
    }

    private void setupObservers() {
        viewModel.fetchCharacter().observe(getViewLifecycleOwner(), characters -> {
            characterAdapter.addCharacter(characters.getResults());
        });
    }
}
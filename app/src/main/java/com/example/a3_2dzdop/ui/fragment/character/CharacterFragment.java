package com.example.a3_2dzdop.ui.fragment.character;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.databinding.FragmentCharacterBinding;
import com.example.a3_2dzdop.ui.adapter.CharacterAdapter;

public class CharacterFragment extends Fragment {

    private FragmentCharacterBinding characterBinding;
    private CharacterViewModel characterViewModel;
    private CharacterAdapter characterAdapter = new CharacterAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        characterBinding = FragmentCharacterBinding.inflate(getLayoutInflater(), container, false);
        initialize();
        setupCharacter();
        return characterBinding.getRoot();
    }

    private void initialize() {
        characterViewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
        setupCharacterRecycler();
    }

    private void setupCharacterRecycler() {
        characterBinding.rvCharacter.setLayoutManager(new LinearLayoutManager(getContext()));
        characterBinding.rvCharacter.setAdapter(characterAdapter);
    }

    private void setupCharacter() {
        characterViewModel.fetchCharacter().observe(getViewLifecycleOwner(), characters -> {
            characterAdapter.addCharacter(characters.getResults());
        });
    }
}
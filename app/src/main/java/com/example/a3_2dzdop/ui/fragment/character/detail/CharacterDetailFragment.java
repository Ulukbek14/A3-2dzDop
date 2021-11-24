package com.example.a3_2dzdop.ui.fragment.character.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.a3_2dzdop.R;
import com.example.a3_2dzdop.databinding.FragmentCharacterDetailBinding;

public class CharacterDetailFragment extends Fragment {

    private FragmentCharacterDetailBinding binding;
    private CharacterDetailViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false);
        initialize();
        setupRequest();
        setupCharacterDetail();
        return binding.getRoot();
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(CharacterDetailViewModel.class);
    }

    private void setupRequest() {
        viewModel.fetchCharacter(CharacterDetailFragmentArgs.fromBundle(getArguments()).getId());
    }

    private void setupCharacterDetail() {
        viewModel.character.observe(getViewLifecycleOwner(), character -> {
            Glide.with(binding.detailIv)
                    .load(character.getImage())
                    .into(binding.detailIv);
            binding.detailTvName.setText(character.getName());
            binding.detailTvStatus.setText(character.getStatus());
            binding.detailTvSpecies.setText(character.getSpecies());
            binding.detailTvGender.setText(character.getGender());
            binding.detailTvUrl.setText(character.getUrl());
            binding.detailTvCreated.setText(character.getCreated());
        });
    }
}
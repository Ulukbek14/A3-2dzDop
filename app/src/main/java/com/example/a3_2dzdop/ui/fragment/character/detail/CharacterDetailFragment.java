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
import com.example.a3_2dzdop.base.BaseFragment;
import com.example.a3_2dzdop.databinding.FragmentCharacterDetailBinding;

public class CharacterDetailFragment extends
        BaseFragment<CharacterDetailViewModel, FragmentCharacterDetailBinding> {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(CharacterDetailViewModel.class);
    }

    protected void setupRequest() {
        viewModel.fetchCharacter(CharacterDetailFragmentArgs.fromBundle(getArguments()).getId());
    }

    @Override
    protected void setupObservers() {
        viewModel.character.observe(getViewLifecycleOwner(), character -> {
            Glide.with(binding.detailIv)
                    .load(character.getImage())
                    .into(binding.detailIv);
            binding.detailTvStatus.setText(character.getStatus());
            binding.detailTvSpecies.setText(character.getSpecies());
            binding.detailTvUrl.setText(character.getUrl());
            binding.detailTvCreated.setText(character.getCreated());
        });
    }
}
package com.example.a3_2dzdop.ui.fragment.character.dialog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.a3_2dzdop.databinding.FragmentDialogBinding;
import com.example.a3_2dzdop.ui.fragment.character.detail.CharacterDetailViewModel;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    private FragmentDialogBinding binding;
    private CharacterDetailViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupObservers();
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(CharacterDetailViewModel.class);
    }

    private void setupObservers() {
        viewModel.fetchCharacter(DialogFragmentArgs.fromBundle(getArguments()).getId()).observe(getViewLifecycleOwner(), character ->
                Glide.with(binding.dialogImage)
                        .load(character.getImage())
                        .into(binding.dialogImage));
    }
}
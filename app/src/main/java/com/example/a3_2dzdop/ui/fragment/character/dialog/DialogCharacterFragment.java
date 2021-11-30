package com.example.a3_2dzdop.ui.fragment.character.dialog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.a3_2dzdop.databinding.FragmentDialogCharacterBinding;

public class DialogCharacterFragment extends AppCompatDialogFragment {

    private FragmentDialogCharacterBinding binding;
    private DialogCharacterViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupRequest();
        setupObservers();
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(DialogCharacterViewModel.class);
    }

    private void setupRequest() {
        viewModel.fetchCharacter(DialogCharacterFragmentArgs.fromBundle(getArguments()).getId());
    }

    private void setupObservers() {
        viewModel.dialog.observe(getViewLifecycleOwner(), character ->
                Glide.with(binding.ivDialog)
                        .load(character.getImage())
                        .into(binding.ivDialog));
    }
}
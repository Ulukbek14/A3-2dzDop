package com.example.a3_2dzdop.ui.fragment.character;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.a3_2dzdop.base.BaseFragment;
import com.example.a3_2dzdop.databinding.FragmentCharacterBinding;
import com.example.a3_2dzdop.ui.adapter.CharacterAdapter;

public class CharacterFragment extends BaseFragment<CharacterViewModel, FragmentCharacterBinding> {

    private CharacterAdapter characterAdapter = new CharacterAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    protected void setupCharacter() {
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
                Navigation.findNavController(requireView()).
                        navigate(CharacterFragmentDirections.
                                actionNavigationCharactersToDialogFragment(id)
                        );
            }
        });
    }

    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
        setupCharactersRecycler();
    }

    protected void setupObservers() {
        viewModel.fetchCharacter().observe(getViewLifecycleOwner(), characters -> {
            characterAdapter.addCharacter(characters.getResults());
        });
    }

    private void setupCharactersRecycler() {
        binding.rvCharacter.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCharacter.setAdapter(characterAdapter);
    }
}
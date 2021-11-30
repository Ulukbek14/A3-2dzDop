package com.example.a3_2dzdop.ui.fragment.character;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.repository.CharacterRepository;
import com.example.a3_2dzdop.model.character.CharacterModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends BaseViewModel {

    private CharacterRepository characterRepository = new CharacterRepository();

    public LiveData<RickAndMortyResponse<CharacterModel>> fetchCharacter() {
        return characterRepository.fetchCharacters();
    }
}
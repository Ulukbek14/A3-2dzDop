package com.example.a3_2dzdop.ui.fragment.character;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.repository.CharacterRepository;
import com.example.a3_2dzdop.data.network.dtos.character.CharacterModel;

public class CharacterViewModel extends BaseViewModel {

    public int page;
    private CharacterRepository characterRepository = new CharacterRepository();
    public MutableLiveData<Boolean> isCharacterLoading = new MutableLiveData<>();

    public LiveData<RickAndMortyResponse<CharacterModel>> fetchCharacters() {
        isCharacterLoading.setValue(true);
        return characterRepository.fetchCharacters(page);
    }
}
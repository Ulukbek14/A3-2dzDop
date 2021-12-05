package com.example.a3_2dzdop.ui.fragment.character.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.dtos.character.CharacterModel;
import com.example.a3_2dzdop.data.network.dtos.episode.EpisodeModel;
import com.example.a3_2dzdop.data.network.dtos.location.LocationModel;
import com.example.a3_2dzdop.data.network.repository.CharacterRepository;
import com.example.a3_2dzdop.data.network.repository.EpisodeRepository;
import com.example.a3_2dzdop.data.network.repository.LocationRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterDetailViewModel extends BaseViewModel {

    private CharacterRepository characterRepository = new CharacterRepository();

    public MutableLiveData<Boolean> isCharacterLoading = new MutableLiveData<>();

    public LiveData<CharacterModel> fetchCharacter(int id) {
        isCharacterLoading.setValue(true);
        return characterRepository.fetchCharacter(id);
    }
}
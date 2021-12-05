package com.example.a3_2dzdop.data.network.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.dtos.character.CharacterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterRepository {

    public LiveData<RickAndMortyResponse<CharacterModel>> fetchCharacters(int page) {
        MutableLiveData<RickAndMortyResponse<CharacterModel>> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacters(page).enqueue(new Callback<RickAndMortyResponse<CharacterModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<CharacterModel>> call, Response<RickAndMortyResponse<CharacterModel>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<CharacterModel>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<CharacterModel> fetchCharacter(int id) {
        MutableLiveData<CharacterModel> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacter(id).enqueue(new Callback<CharacterModel>() {
            @Override
            public void onResponse(Call<CharacterModel> call, Response<CharacterModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CharacterModel> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
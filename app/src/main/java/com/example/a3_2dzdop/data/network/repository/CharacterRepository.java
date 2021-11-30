package com.example.a3_2dzdop.data.network.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.model.character.CharacterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterRepository {

    public LiveData<RickAndMortyResponse<CharacterModel>> fetchCharacters(){

        MutableLiveData<RickAndMortyResponse<CharacterModel>> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacters().enqueue(new Callback<RickAndMortyResponse<CharacterModel>>() {
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
}
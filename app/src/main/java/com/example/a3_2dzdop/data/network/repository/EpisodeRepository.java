package com.example.a3_2dzdop.data.network.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.dtos.character.CharacterModel;
import com.example.a3_2dzdop.data.network.dtos.episode.EpisodeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeRepository {

    public LiveData<RickAndMortyResponse<EpisodeModel>> fetchEpisodes(int page) {

        MutableLiveData<RickAndMortyResponse<EpisodeModel>> data = new MutableLiveData<>();
        App.episodeApiService.fetchEpisodes(page).enqueue(new Callback<RickAndMortyResponse<EpisodeModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<EpisodeModel>> call, Response<RickAndMortyResponse<EpisodeModel>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<EpisodeModel>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<EpisodeModel> fetchEpisode(int id) {

        MutableLiveData<EpisodeModel> data = new MutableLiveData<>();
        App.episodeApiService.fetchEpisode(id).enqueue(new Callback<EpisodeModel>() {
            @Override
            public void onResponse(Call<EpisodeModel> call, Response<EpisodeModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<EpisodeModel> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
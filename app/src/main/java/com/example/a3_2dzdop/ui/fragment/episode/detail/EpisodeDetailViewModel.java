package com.example.a3_2dzdop.ui.fragment.episode.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.model.episode.EpisodeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeDetailViewModel extends BaseViewModel {

    private MutableLiveData<EpisodeModel> _episode = new MutableLiveData<>();
    public LiveData<EpisodeModel> episode = _episode;

    public void fetchEpisode(int id) {
        App.episodeApiService.fetchEpisode(id).enqueue(new Callback<EpisodeModel>() {
            @Override
            public void onResponse(Call<EpisodeModel> call, Response<EpisodeModel> response) {
                _episode.setValue(response.body());
            }

            @Override
            public void onFailure(Call<EpisodeModel> call, Throwable t) {
                _episode.setValue(null);
            }
        });
    }
}
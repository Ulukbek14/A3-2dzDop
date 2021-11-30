package com.example.a3_2dzdop.ui.fragment.episode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.repository.EpisodeRepository;
import com.example.a3_2dzdop.model.episode.EpisodeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeViewModel extends BaseViewModel {

    private EpisodeRepository episodeRepository = new EpisodeRepository();

    public LiveData<RickAndMortyResponse<EpisodeModel>> fetchEpisode() {
        return episodeRepository.fetchEpisodes();
    }
}
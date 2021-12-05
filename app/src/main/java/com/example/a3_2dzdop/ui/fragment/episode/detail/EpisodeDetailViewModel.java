package com.example.a3_2dzdop.ui.fragment.episode.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.episode.EpisodeModel;
import com.example.a3_2dzdop.data.network.repository.EpisodeRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeDetailViewModel extends BaseViewModel {

    private EpisodeRepository episodeRepository = new EpisodeRepository();


    public LiveData<EpisodeModel> fetchEpisode(int id) {
        return episodeRepository.fetchEpisode(id);
    }
}
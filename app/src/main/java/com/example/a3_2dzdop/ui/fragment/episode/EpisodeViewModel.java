package com.example.a3_2dzdop.ui.fragment.episode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.dtos.character.CharacterModel;
import com.example.a3_2dzdop.data.network.repository.CharacterRepository;
import com.example.a3_2dzdop.data.network.repository.EpisodeRepository;
import com.example.a3_2dzdop.data.network.dtos.episode.EpisodeModel;

public class EpisodeViewModel extends BaseViewModel {

    public int page = 1;
    private EpisodeRepository episodeRepository = new EpisodeRepository();
    public MutableLiveData<Boolean> isEpisodeLoading = new MutableLiveData<>();

    public LiveData<RickAndMortyResponse<EpisodeModel>> fetchEpisodes() {
        isEpisodeLoading.setValue(true);
        return episodeRepository.fetchEpisodes(page);
    }
}
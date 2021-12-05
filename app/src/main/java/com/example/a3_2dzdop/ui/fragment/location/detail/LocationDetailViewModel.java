package com.example.a3_2dzdop.ui.fragment.location.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.episode.EpisodeModel;
import com.example.a3_2dzdop.data.network.dtos.location.LocationModel;
import com.example.a3_2dzdop.data.network.repository.EpisodeRepository;
import com.example.a3_2dzdop.data.network.repository.LocationRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationDetailViewModel extends BaseViewModel {

    private LocationRepository locationRepository = new LocationRepository();


    public LiveData<LocationModel> fetchLocation(int id) {
        return locationRepository.fetchLocation(id);
    }
}
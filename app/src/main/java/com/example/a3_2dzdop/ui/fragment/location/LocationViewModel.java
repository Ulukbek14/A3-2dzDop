package com.example.a3_2dzdop.ui.fragment.location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.repository.LocationRepository;
import com.example.a3_2dzdop.model.location.LocationModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends BaseViewModel {

    private LocationRepository locationRepository = new LocationRepository();

    public LiveData<RickAndMortyResponse<LocationModel>> fetchLocation() {
        return locationRepository.fetchLocations();
    }
}
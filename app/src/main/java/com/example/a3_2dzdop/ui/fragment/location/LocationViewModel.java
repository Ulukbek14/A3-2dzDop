package com.example.a3_2dzdop.ui.fragment.location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.repository.LocationRepository;
import com.example.a3_2dzdop.data.network.dtos.location.LocationModel;

public class LocationViewModel extends BaseViewModel {

    public int page = 1;
    private LocationRepository locationRepository = new LocationRepository();
    public MutableLiveData<Boolean> isLocationLoading = new MutableLiveData<>();

    public LiveData<RickAndMortyResponse<LocationModel>> fetchLocation() {
        isLocationLoading.setValue(true);
        return locationRepository.fetchLocations(page);
    }
}
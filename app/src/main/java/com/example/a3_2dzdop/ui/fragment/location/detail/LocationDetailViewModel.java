package com.example.a3_2dzdop.ui.fragment.location.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.base.BaseViewModel;
import com.example.a3_2dzdop.model.location.LocationModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationDetailViewModel extends BaseViewModel {

    private MutableLiveData<LocationModel> _location = new MutableLiveData<>();
    public LiveData<LocationModel> location = _location;

    public void fetchEpisode(int id) {
        App.locationApiService.fetchLocation(id).enqueue(new Callback<LocationModel>() {
            @Override
            public void onResponse(Call<LocationModel> call, Response<LocationModel> response) {
                _location.setValue(response.body());
            }

            @Override
            public void onFailure(Call<LocationModel> call, Throwable t) {
                _location.setValue(null);
            }
        });
    }
}
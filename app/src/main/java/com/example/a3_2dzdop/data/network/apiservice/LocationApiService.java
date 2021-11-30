package com.example.a3_2dzdop.data.network.apiservice;

import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.model.location.LocationModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LocationApiService {

    @GET("/api/location/")
    Call<RickAndMortyResponse<LocationModel>> fetchLocations();

    @GET("/api/location/{id}")
    Call<LocationModel> fetchLocation(
            @Path("id") int id
    );
}
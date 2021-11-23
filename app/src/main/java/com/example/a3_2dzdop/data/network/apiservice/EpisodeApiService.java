package com.example.a3_2dzdop.data.network.apiservice;

import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.model.episode.EpisodeModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EpisodeApiService {

    @GET("/api/episode/")
    Call<RickAndMortyResponse<EpisodeModel>> fetchEpisodes();

    @GET("/api/episode/{id}")
    Call<EpisodeModel> fetchEpisode(
            @Path("id") int id
    );
}
package com.example.a3_2dzdop.data.network.apiservice;

import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.data.network.dtos.character.CharacterModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterApiService {

    @GET("/api/character/")
    Call<RickAndMortyResponse<CharacterModel>> fetchCharacters(@Query("page") int page);

    @GET("/api/character/{id}")
    Call<CharacterModel> fetchCharacter(
            @Path("id") int id);
}
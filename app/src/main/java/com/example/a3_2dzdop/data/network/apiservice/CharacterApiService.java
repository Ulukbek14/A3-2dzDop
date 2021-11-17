package com.example.a3_2dzdop.data.network.apiservice;

import com.example.a3_2dzdop.data.network.dtos.RickAndMortyResponse;
import com.example.a3_2dzdop.model.character.CharacterModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CharacterApiService {

    @GET("/api/character/")
    Call<RickAndMortyResponse<CharacterModel>> fetchCharacters();

    @GET("/api/character/{id}")
    Call<RickAndMortyResponse<CharacterModel>> fetchCharacter(
            @Path("id") int id
    );
}

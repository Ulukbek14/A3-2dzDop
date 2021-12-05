package com.example.a3_2dzdop.data.network;

import com.example.a3_2dzdop.data.network.apiservice.CharacterApiService;
import com.example.a3_2dzdop.data.network.apiservice.EpisodeApiService;
import com.example.a3_2dzdop.data.network.apiservice.LocationApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();


    private HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

    public CharacterApiService provideCharacterApiService() {
        return retrofit.create(CharacterApiService.class);
    }

    public EpisodeApiService provideEpisodeApiService() {
        return retrofit.create(EpisodeApiService.class);
    }

    public LocationApiService provideLocationApiService() {
        return retrofit.create(LocationApiService.class);
    }
}
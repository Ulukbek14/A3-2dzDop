package com.example.a3_2dzdop;

import android.app.Application;

import com.example.a3_2dzdop.data.network.RetrofitClient;
import com.example.a3_2dzdop.data.network.apiservice.CharacterApiService;
import com.example.a3_2dzdop.data.network.apiservice.EpisodeApiService;
import com.example.a3_2dzdop.data.network.apiservice.LocationApiService;

public class App extends Application {

    public static CharacterApiService characterApiService;
    public static EpisodeApiService episodeApiService;
    public static LocationApiService locationApiService;


    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient retrofitClient = new RetrofitClient();
        characterApiService = retrofitClient.provideCharacterApiService();
        episodeApiService = retrofitClient.provideEpisodeApiService();
        locationApiService = retrofitClient.provideLocationApiService();
    }
}

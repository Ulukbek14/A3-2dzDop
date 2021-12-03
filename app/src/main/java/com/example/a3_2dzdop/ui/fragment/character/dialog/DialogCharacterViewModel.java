package com.example.a3_2dzdop.ui.fragment.character.dialog;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_2dzdop.App;
import com.example.a3_2dzdop.data.network.dtos.character.CharacterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogCharacterViewModel extends ViewModel {

    private final MutableLiveData<CharacterModel> _dialog = new MutableLiveData<>();
    public final LiveData<CharacterModel> dialog = _dialog;

    public void fetchCharacter(int id) {
        App.characterApiService.fetchCharacter(id).enqueue(new Callback<CharacterModel>() {
            @Override
            public void onResponse(@NonNull Call<CharacterModel> call, @NonNull Response<CharacterModel> response) {
                _dialog.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<CharacterModel> call, @NonNull Throwable t) {
                _dialog.setValue(null);
            }
        });
    }
}
package com.example.a3_2dzdop.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a3_2dzdop.databinding.ItemCharacterBinding;
import com.example.a3_2dzdop.model.character.CharacterModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private ArrayList<CharacterModel> list = new ArrayList<>();

    public void addCharacter(List<CharacterModel> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(ItemCharacterBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CharacterAdapter.CharacterViewHolder holder, int position) {
        holder.characterFilling(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        private ItemCharacterBinding binding;

        public CharacterViewHolder(@NonNull ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void characterFilling(CharacterModel characterModel) {
            binding.itemTvCharacterName.setText(characterModel.getName());
            binding.itemTvCharacterStatus.setText(characterModel.getStatus());
            Glide.with(binding.itemIv).
                    load(characterModel.getImage())
                    .into(binding.itemIv);
        }
    }
}

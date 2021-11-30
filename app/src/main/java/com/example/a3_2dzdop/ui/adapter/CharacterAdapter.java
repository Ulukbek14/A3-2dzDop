package com.example.a3_2dzdop.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a3_2dzdop.databinding.ItemCharacterBinding;
import com.example.a3_2dzdop.model.character.CharacterModel;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharactersViewHolder> {

    private ArrayList<CharacterModel> list = new ArrayList<>();
    private OnItemClickListener listener;

    public void addCharacter(List<CharacterModel> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharactersViewHolder(ItemCharacterBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersViewHolder holder, int position) {
        holder.characterFilling(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharactersViewHolder extends RecyclerView.ViewHolder {
        private ItemCharacterBinding binding;

        public CharactersViewHolder(@NonNull ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void characterFilling(CharacterModel characterModel) {
            binding.itemTvCharacterName.setText(characterModel.getName());
            binding.itemTvCharacterStatus.setText(characterModel.getStatus());
            Glide
                    .with(binding.itemIv)
                    .load(characterModel.getImage())
                    .into(binding.itemIv);

            binding.getRoot().
                    setOnClickListener(v ->
                            listener.onItemClick
                                    (characterModel.getId()));

            binding.getRoot().
                    setOnLongClickListener(v -> {
                        listener.onItemCharacterClick
                                (characterModel.getId());
                        return false;
                    });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int id);
        void onItemCharacterClick(int id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
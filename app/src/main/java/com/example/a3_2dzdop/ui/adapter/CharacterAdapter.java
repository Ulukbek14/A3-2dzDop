package com.example.a3_2dzdop.ui.adapter;

import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a3_2dzdop.databinding.ItemCharacterBinding;
import com.example.a3_2dzdop.data.network.dtos.character.CharacterModel;

public class CharacterAdapter extends ListAdapter<CharacterModel, CharacterAdapter.CharactersViewHolder> {

    private OnItemClickListener listener;
    public CharacterAdapter() {
        super(new CharacterComparator());
    }

    @NonNull
    @Override
    public CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharactersViewHolder(ItemCharacterBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersViewHolder holder, int position) {
        holder.characterFilling(getItem(position));
    }

    public class CharactersViewHolder extends RecyclerView.ViewHolder {

        public void characterFilling(CharacterModel characterModel) {
            Glide.with(binding.itemIv).
                    load(characterModel.getImage())
                    .into(binding.itemIv);
            binding.itemTvCharacterName.setText(characterModel.getName());
            binding.itemTvCharacterStatus.setText(characterModel.getStatus());
            binding.itemTvCharacterSpecies.setText(characterModel.getSpecies());
            binding.itemTvCharacterGender.setText(characterModel.getGender());

            binding.getRoot().setOnClickListener(v -> {
                listener.onItemClick(characterModel.getId());
            });

            binding.getRoot().setOnLongClickListener(v -> {
                listener.
                        onItemLongClick(characterModel.getId());
                return false;
            });
        }

        private final ItemCharacterBinding binding;

        public CharactersViewHolder(@NonNull ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class CharacterComparator extends DiffUtil.ItemCallback<CharacterModel> {

        @Override
        public boolean areItemsTheSame(@NonNull CharacterModel oldItem, @NonNull CharacterModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull CharacterModel oldItem, @NonNull CharacterModel newItem) {
            return oldItem.equals(newItem);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int id);
        void onItemLongClick(int id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
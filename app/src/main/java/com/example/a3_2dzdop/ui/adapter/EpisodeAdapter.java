package com.example.a3_2dzdop.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_2dzdop.databinding.ItemEpisodeBinding;
import com.example.a3_2dzdop.data.network.dtos.episode.EpisodeModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends ListAdapter<EpisodeModel, EpisodeAdapter.EpisodeViewHolder> {

    private OnItemClickListener listener;

    public EpisodeAdapter() {
        super(new EpisodeComparator());
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EpisodeViewHolder(ItemEpisodeBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.episodeFilling(getItem(position));
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {

        public void episodeFilling(EpisodeModel episodeModel) {
            binding.itemTvEpisodeName.setText(episodeModel.getName());
            binding.itemTvEpisodeAirDate.setText(episodeModel.getAir_date());
            binding.itemTvEpisodeCharacters.setText(episodeModel.getEpisode());

            binding.getRoot().setOnClickListener(v ->
                    listener.onItemClick(episodeModel.getId()));
        }

        private final ItemEpisodeBinding binding;

        public EpisodeViewHolder(@NonNull ItemEpisodeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class EpisodeComparator extends DiffUtil.ItemCallback<EpisodeModel> {

        @Override
        public boolean areItemsTheSame(@NonNull EpisodeModel oldItem, @NonNull EpisodeModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull EpisodeModel oldItem, @NonNull EpisodeModel newItem) {
            return oldItem.equals(newItem);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
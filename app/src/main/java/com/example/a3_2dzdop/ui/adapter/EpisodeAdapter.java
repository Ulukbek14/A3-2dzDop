package com.example.a3_2dzdop.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_2dzdop.databinding.ItemEpisodeBinding;
import com.example.a3_2dzdop.model.episode.EpisodeModel;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {

    private ArrayList<EpisodeModel> list = new ArrayList<>();

    public void addEpisode(List<EpisodeModel> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EpisodeViewHolder(ItemEpisodeBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.episodeFilling(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {
        private ItemEpisodeBinding binding;

        public EpisodeViewHolder(@NonNull ItemEpisodeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void episodeFilling(EpisodeModel episodeModel) {
            binding.itemTvEpName.setText(episodeModel.getName());
            binding.itemTvEpDate.setText(episodeModel.getAir_date());
            binding.itemTvEpEpisode.setText(episodeModel.getEpisode());
        }
    }
}
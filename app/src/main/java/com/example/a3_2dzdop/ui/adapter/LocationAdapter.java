package com.example.a3_2dzdop.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_2dzdop.databinding.ItemLocationBinding;
import com.example.a3_2dzdop.data.network.dtos.location.LocationModel;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends ListAdapter<LocationModel, LocationAdapter.LocationViewHolder> {

    private OnItemClickListener listener;
    public LocationAdapter() {
        super(new LocationComparator());
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.locationFilling(getItem(position));
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder {

        public void locationFilling(LocationModel locationModel) {
            binding.itemTvLocationName.setText(locationModel.getName());
            binding.itemTvLocationType.setText(locationModel.getType());
            binding.itemTvLocationDimension.setText(locationModel.getDimension());

            binding.getRoot().setOnClickListener(v ->
                    listener.onItemClick(locationModel.getId()));
        }

        private final ItemLocationBinding binding;

        public LocationViewHolder(@NonNull ItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class LocationComparator extends DiffUtil.ItemCallback<LocationModel> {

        @Override
        public boolean areItemsTheSame(@NonNull LocationModel oldItem, @NonNull LocationModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull LocationModel oldItem, @NonNull LocationModel newItem) {
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
//public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {
//
//    private ArrayList<LocationModel> list = new ArrayList<>();
//    private OnItemClickListener listener;
//
//    public void addLocation(List<LocationModel> list) {
//        this.list.addAll(list);
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new LocationViewHolder(ItemLocationBinding.
//                inflate(LayoutInflater.from(parent.getContext()), parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
//        holder.locationFilling(list.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class LocationViewHolder extends RecyclerView.ViewHolder {
//        private ItemLocationBinding binding;
//
//        public LocationViewHolder(@NonNull ItemLocationBinding binding) {
//            super(binding.getRoot());
//            this.binding = binding;
//        }
//
//        public void locationFilling(LocationModel itemLocation) {
//            binding.itemTvLocationName.setText(itemLocation.getName());
//            binding.itemTvLocationType.setText(itemLocation.getType());
//            binding.itemTvLocationDimension.setText(itemLocation.getDimension());
//            binding.getRoot().setOnClickListener(v ->
//                    listener.onItemClick(itemLocation.getId()));
//        }
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(int id);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.listener = listener;
//    }
//}
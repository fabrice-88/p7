package com.fabrice.go4lunch.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.databinding.ItemRestaurantsBinding;
import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.ui.DetailRestaurantActivity;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private final ArrayList<Restaurant> mRestaurants;

    public RestaurantAdapter(ArrayList<Restaurant> restaurants) {
        this.mRestaurants = restaurants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemRestaurantsBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Restaurant restaurant = mRestaurants.get(position);
        Glide.with(holder.mBinding.imgRestaurantPhoto.getContext())
                .load(restaurant.getPhotoUrl())
                .into(holder.mBinding.imgRestaurantPhoto);
        holder.mBinding.imgRestaurantRating.setImageResource(R.drawable.ic_baseline_star_24);
        holder.mBinding.txtRestaurantName.setText(restaurant.getName());
        holder.mBinding.txtRestaurantDistance.setText(restaurant.getDistance());
        holder.mBinding.txtRestaurantAddress.setText(restaurant.getAddress());
        holder.mBinding.txtNbPeopleEating.setText("("+(getItemCount() +")"));
        holder.mBinding.txtOpeningHours.setText(restaurant.getOpeningHours());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailRestaurantActivity.class);
            intent.putExtra("NAME_RESTAURANT", restaurant.getName());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemRestaurantsBinding mBinding;
        public ViewHolder(@NonNull ItemRestaurantsBinding itemRestaurantsBinding) {
            super(itemRestaurantsBinding.getRoot());
            mBinding = itemRestaurantsBinding;
        }
    }
}

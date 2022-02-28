package com.fabrice.go4lunch.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import com.bumptech.glide.request.RequestOptions;
import com.fabrice.go4lunch.databinding.ItemWorkmateBinding;
import com.fabrice.go4lunch.model.User;
import com.fabrice.go4lunch.ui.DetailRestaurantActivity;

import java.util.ArrayList;

public class WorkMateAdapter extends RecyclerView.Adapter<WorkMateAdapter.ViewHolder>{

    private final ArrayList<User> mUsers;

    public WorkMateAdapter(ArrayList<User> users){
        this.mUsers = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemWorkmateBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final User user =  mUsers.get(position);
        Glide.with(holder.mBinding.imgWorkmatePhoto.getContext())
            .load(user.getPhotoUrl())
            .apply(RequestOptions.circleCropTransform())
            .into(holder.mBinding.imgWorkmatePhoto);
        holder.mBinding.txtDescriptionWorkmate.setText((user.getFirstname()) + " is eating french ");
        holder.mBinding.txtRestaurantName.setText("("+user.getRestaurantId()+")");
        holder.mBinding.txtRestaurantName.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailRestaurantActivity.class);
            intent.putExtra("NAME_RESTAURANT", user.getRestaurantId());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemWorkmateBinding mBinding;
        public ViewHolder(@NonNull ItemWorkmateBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}

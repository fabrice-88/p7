package com.fabrice.go4lunch.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.adapter.RestaurantAdapter;
import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.viewmodel.RestaurantViewModel;
import com.fabrice.go4lunch.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.Objects;

public class ListFragment extends Fragment {

    ArrayList<Restaurant> mRestaurants = new ArrayList<>();
    RestaurantViewModel mRestaurantViewModel;
    RecyclerView mRecyclerView;

    public static ListFragment newInstance() {
        return (new ListFragment());
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initData(){
        //mRestaurantViewModel = new ViewModelProvider(requireActivity()).get(RestaurantViewModel.class);
        mRestaurantViewModel = new ViewModelProvider(requireActivity(), ViewModelFactory.getInstance()).get(RestaurantViewModel.class);
        mRestaurantViewModel.initRestaurant();

        mRestaurantViewModel.getMutableLiveDataRestaurant().observe(requireActivity(), restaurants -> {
            mRestaurants.clear();
            mRestaurants.addAll(restaurants);
            Objects.requireNonNull(mRecyclerView.getAdapter()).notifyDataSetChanged();
                });
    }

    private void initViewModel(){
        RestaurantViewModel restaurantViewModel = new ViewModelProvider(this, ViewModelFactory.getInstance()).get(RestaurantViewModel.class);
        restaurantViewModel.initRestaurant();
    }

    private void initRecyclerView(View root) {
        mRecyclerView = root.findViewById(R.id.list_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        RestaurantAdapter mAdapter = new RestaurantAdapter(mRestaurants);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        initRecyclerView(root);
        initData();
        return root;
    }
}
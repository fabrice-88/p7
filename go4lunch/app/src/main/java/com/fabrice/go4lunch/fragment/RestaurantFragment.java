package com.fabrice.go4lunch.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.adapter.RestaurantAdapter;
import com.fabrice.go4lunch.model.Result;
import com.fabrice.go4lunch.viewmodel.RestaurantViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.Objects;

public class RestaurantFragment extends Fragment {

    ArrayList<Result> mResults = new ArrayList<>();
    RestaurantViewModel mRestaurantViewModel;
    RecyclerView mRecyclerView;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Location mLocation;


    public static RestaurantFragment newInstance() {
        return (new RestaurantFragment());
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initData() {
        Dexter.withContext(getActivity())
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        mFusedLocationProviderClient.getLastLocation().addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                mLocation = task.getResult();
                                if (mLocation != null) {
                                    mRestaurantViewModel.initListRestaurantMutableLiveData(mLocation);
                                    mRestaurantViewModel.mPlaceResultsMutableLiveData.observe(requireActivity(), restaurants -> {
                                        mResults.clear();
                                        mResults.addAll(restaurants);
                                        Objects.requireNonNull(mRecyclerView.getAdapter()).notifyDataSetChanged();
                                    });
                                } else {

                                }
                            }
                        });
                    }
                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */}

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */}
                }).check();

//        mRestaurantViewModel = new ViewModelProvider(requireActivity(), ViewModelFactory.getInstance()).get(RestaurantViewModel.class);
//        mRestaurantViewModel.initRestaurant();
//        mRestaurantViewModel.getMutableLiveDataRestaurant().observe(requireActivity(), restaurants -> {
//            mRestaurants.clear();
//            mRestaurants.addAll(restaurants);
//            Objects.requireNonNull(mRecyclerView.getAdapter()).notifyDataSetChanged();
//        });
    }

    private void initRecyclerView(View root) {
        mRecyclerView = root.findViewById(R.id.list_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        RestaurantAdapter mAdapter = new RestaurantAdapter(mResults);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_restaurant, container, false);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(Objects.requireNonNull(getActivity()));
        initRecyclerView(root);
        initData();
        return root;
    }
}
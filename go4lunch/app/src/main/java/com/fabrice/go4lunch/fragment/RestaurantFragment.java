package com.fabrice.go4lunch.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.fabrice.go4lunch.BuildConfig;
import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.adapter.RestaurantAdapter;
import com.fabrice.go4lunch.model.PlacesResults;
import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.model.Result;
import com.fabrice.go4lunch.service.APIClient;
import com.fabrice.go4lunch.service.GoogleMapAPI;
import com.fabrice.go4lunch.viewmodel.RestaurantViewModel;
import com.fabrice.go4lunch.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Response;

public class RestaurantFragment extends Fragment {

    private LocationManager locationManager;
    ArrayList<Restaurant> mRestaurants = new ArrayList<>();
    RestaurantViewModel mRestaurantViewModel;
    RecyclerView mRecyclerView;
    private Button buttonSearch;
    private ListView listViewPlaces;

    public static RestaurantFragment newInstance() {
        return (new RestaurantFragment());
    }

//    @SuppressLint("NotifyDataSetChanged")
//    private void initData() {
//        mRestaurantViewModel = new ViewModelProvider(requireActivity(), ViewModelFactory.getInstance()).get(RestaurantViewModel.class);
//        mRestaurantViewModel.initRestaurant();
//        mRestaurantViewModel.getMutableLiveDataRestaurant().observe(requireActivity(), restaurants -> {
//            mRestaurants.clear();
//            mRestaurants.addAll(restaurants);
//            System.out.println("VALEUR DE mRestaurants = "+ mRestaurants);
//
//            Objects.requireNonNull(mRecyclerView.getAdapter()).notifyDataSetChanged();
//        });
//    }

//    private void initRecyclerView(View root) {
//        mRecyclerView = root.findViewById(R.id.list_rv);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        mRecyclerView.setLayoutManager(layoutManager);
//        //RestaurantAdapter mAdapter = new RestaurantAdapter(mRestaurants);
//        RestaurantAdapter mAdapter = new RestaurantAdapter(mResults);
//        mRecyclerView.setAdapter(mAdapter);
//    }

    private void initView() {
        buttonSearch = buttonSearch.findViewById(R.id.buttonShowLocation);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSearch_onClick(view);
            }
        });
        listViewPlaces = listViewPlaces.findViewById(R.id.list_rv);
    }

    private void buttonSearch_onClick(View view) {

//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2 * 1000, 1, locationListener);
//        } else {
//            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 12);
//            }
//            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 13);
//            }
//        }

    }

    private LocationListener locationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
//            String key = getText(BuildConfig.MAPS_API_KEY);
//            String currentLocation = location.getLatitude() + "," + location.getLongitude();
//            int radius = 1500;
//            String type = spinnerType.getSelectedItem().toString();
//            GoogleMapAPI googleMapAPI = APIClient.getGoogleMapAPI().create(GoogleMapAPI.class);
//            googleMapAPI.getNearBy(currentLocation, radius, type, keyword, key).enqueue(new Callback<PlacesResults>() {
//                @Override
//                public void onResponse(Call<PlacesResults> call, Response<PlacesResults> response) {
//                    if (response.isSuccessful()) {
//                        List<Result> results = response.body().getResults();
//                        PlacesListAdapter placesListAdapter = new RestaurantAdapter(getActivity(), results);
//                        listViewPlaces.setAdapter(RestaurantAdapter);
//                    } else {
//                        Toast.makeText(getContext(), "Failed", Toast.LENGTH_LONG).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<PlacesResults> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            });
//        }
//
//        @Override
//        public void onStatusChanged(String s, int i, Bundle bundle) {
//
//        }
//
//        @Override
//        public void onProviderEnabled(String s) {
//
//        }
//
//        @Override
//        public void onProviderDisabled(String s) {

        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_restaurant, container, false);
//        initRecyclerView(root);
//        initData();
        return root;
    }
}
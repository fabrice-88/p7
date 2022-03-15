package com.fabrice.go4lunch.fragment;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.model.Result;
import com.fabrice.go4lunch.repository.RetrofitRepository;
import com.fabrice.go4lunch.service.APIClient;
import com.fabrice.go4lunch.viewmodel.RestaurantViewModel;
import com.fabrice.go4lunch.viewmodel.ViewModelFactory;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.Objects;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private Location mLocation;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private GoogleMap mMap;
    private RestaurantViewModel mRestaurantViewModel;
    private final RetrofitRepository mRetrofitRepository = new RetrofitRepository(APIClient.getGoogleMapAPI());
    private static final float DEFAULT_ZOOM = 15;
    private final LatLng mDefaultLocation = new LatLng(-33.8523341, 151.2106085);

    public static MapFragment newInstance() {
        return (new MapFragment());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mRestaurantViewModel = new ViewModelProvider(requireActivity(), ViewModelFactory.getInstance()).get(RestaurantViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(Objects.requireNonNull(getActivity()));
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab_location);
        floatingActionButton.setOnClickListener(v -> getCurrentLocation());
    }

    private void getCurrentLocation() {
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
                                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLocation.getLatitude(), mLocation.getLongitude()), DEFAULT_ZOOM));

                                    mRetrofitRepository.getPlaceResultsLiveData(mLocation).observe(requireActivity(), restaurants -> {
                                        System.out.println("VALEUR DE LOCATION = " + mLocation);

                                        try {
                                            mMap.clear();
                                            for (Result r : restaurants) {
                                                double lat = r.getGeometry().getLocation().getLat();
                                                System.out.println("VALEUR DE LATITUDE = " + lat);
                                                double lng = r.getGeometry().getLocation().getLng();
                                                System.out.println("VALEUR DE LONGITUDE = " + lng);
                                                String name = r.getName();
                                                System.out.println("VALEUR DE NAME = " + name);
                                                MarkerOptions markerOptions = new MarkerOptions();
                                                LatLng latLng = new LatLng(lat, lng);
                                                markerOptions.position(latLng);
                                                markerOptions.title(name);
                                                mMap.addMarker(markerOptions);
                                            }
                                        } catch (Exception e) {
                                            Log.d("onResponse", "There is an error");
                                            e.printStackTrace();
                                        }
                                    });
                                } else {
                                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mDefaultLocation, DEFAULT_ZOOM));
                                    mMap.getUiSettings().setMyLocationButtonEnabled(false);

                                }
                            }
                        });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */}

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */}
                }).check();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {


        mMap = googleMap;
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = mMap.setMapStyle(
                  MapStyleOptions.loadRawResourceStyle(
                            getContext(), R.raw.mapstyle));
            if (!success) {
                Log.e("MapFragment", "Style parsing failed.");
            }


        } catch (Resources.NotFoundException e) {
            Log.e("MapFragment", "Can't find style. Error: ", e);
        }
        getCurrentLocation();
    }
}
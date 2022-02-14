package com.fabrice.go4lunch.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.di.DI;
import com.fabrice.go4lunch.service.ApiService;
import com.fabrice.go4lunch.model.Restaurant;

import java.util.List;

public class ListFragment extends Fragment {

    ApiService mListApiService;
    List<Restaurant> mRestaurants;

    public static ListFragment newInstance() {
        return (new ListFragment());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListApiService = DI.getApiService();
        mRestaurants = mListApiService.getRestau();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}
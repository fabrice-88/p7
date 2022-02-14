package com.fabrice.go4lunch.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.di.DI;
import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.model.User;
import com.fabrice.go4lunch.service.ApiService;

import java.util.List;


public class WorkMateFragment extends Fragment {

    ApiService mWorkmateApiService;
    List<User> mUsers;

    public static WorkMateFragment newInstance() {
        return (new WorkMateFragment());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWorkmateApiService = DI.getApiService();
        mUsers = mWorkmateApiService.getUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_work_mate, container, false);
    }
}
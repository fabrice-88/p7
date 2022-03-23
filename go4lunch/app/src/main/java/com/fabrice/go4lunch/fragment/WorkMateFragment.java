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
import com.fabrice.go4lunch.adapter.WorkMateAdapter;
import com.fabrice.go4lunch.viewmodel.WorkmateViewModel;
import com.fabrice.go4lunch.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.Objects;


public class WorkMateFragment extends Fragment {

//    ArrayList<User> mUsers = new ArrayList<>();
    WorkmateViewModel mWorkmateViewModel;
    RecyclerView mRecyclerView;

    public static WorkMateFragment newInstance() {
        return (new WorkMateFragment());
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initData(){
//        mWorkmateViewModel = new ViewModelProvider(requireActivity(), ViewModelFactory.getInstance()).get(WorkmateViewModel.class);
//        mWorkmateViewModel.initUser();
//        mWorkmateViewModel.getMutableLiveDataUser().observe(requireActivity(), users -> {
//            mUsers.clear();
//            mUsers.addAll(users);
//            Objects.requireNonNull(mRecyclerView.getAdapter()).notifyDataSetChanged();
//        });
    }

    private void initRecyclerView(View root) {
//        mRecyclerView = root.findViewById(R.id.rvWorkmates);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        mRecyclerView.setLayoutManager(layoutManager);
//        WorkMateAdapter mAdapter = new WorkMateAdapter(mUsers);
//        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workmate, container, false);
//        initRecyclerView(root);
//        initData();
        return root;
    }
}
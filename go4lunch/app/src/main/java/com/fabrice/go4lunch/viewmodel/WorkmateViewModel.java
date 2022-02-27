package com.fabrice.go4lunch.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fabrice.go4lunch.model.User;
import com.fabrice.go4lunch.repository.Repository;

import java.util.ArrayList;

public class UserViewModel extends ViewModel {

    Repository mRepository;
    MutableLiveData<ArrayList<User>> mUser;

    public MutableLiveData<ArrayList<User>> getMutableLiveDataUser() {
        return mUser;
    }

    public UserViewModel(Repository repository){
        mRepository = repository;
        mUser = new MutableLiveData<>();
    }

    public void initUser(){
        ArrayList<User> users = mRepository.getUser();
        mUser.setValue(users);
    }
}

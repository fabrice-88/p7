package com.fabrice.go4lunch.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.fabrice.go4lunch.repository.Repository;
import com.fabrice.go4lunch.repository.RetrofitRepository;
import com.fabrice.go4lunch.service.ApiRetroService;
import com.fabrice.go4lunch.service.FakeApiService;
import com.fabrice.go4lunch.service.RetrofitService;
import com.google.android.gms.location.LocationServices;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static ViewModelFactory factory;
    private final RetrofitService mRetrofitService;
    private final RetrofitRepository mRetrofitRepository;

    public static ViewModelFactory getInstance() {
        if (factory == null) {
            synchronized (ViewModelFactory.class) {
                if (factory == null) {
                    factory = new ViewModelFactory();
                }
            }
        }
        return factory;
    }

    private final Repository mRepository = new Repository(new FakeApiService());

    private ViewModelFactory() {
        mRetrofitService = new RetrofitService();
        mRetrofitRepository = new RetrofitRepository(mRetrofitService);
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RestaurantViewModel.class)) {
            return (T) new RestaurantViewModel(mRepository, mRetrofitRepository);
        } else if (modelClass.isAssignableFrom(WorkmateViewModel.class)) {
            return (T) new WorkmateViewModel(mRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

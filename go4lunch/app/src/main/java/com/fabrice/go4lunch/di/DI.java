package com.fabrice.go4lunch.di;

import com.fabrice.go4lunch.service.ApiService;
import com.fabrice.go4lunch.service.FakeApiService;

public class DI {

    private static final ApiService service = new FakeApiService();

    public static ApiService getApiService() {
        return service;
    }

    public static ApiService getNewApiService() {
        return new FakeApiService();
    }

}

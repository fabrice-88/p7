package com.fabrice.go4lunch.ui;

import androidx.appcompat.app.AppCompatActivity;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.databinding.ActivityDetailRestaurantBinding;

import android.os.Bundle;

public class DetailRestaurant extends AppCompatActivity {

    ActivityDetailRestaurantBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_restaurant);
    }
}
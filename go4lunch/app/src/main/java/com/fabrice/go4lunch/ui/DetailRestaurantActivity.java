package com.fabrice.go4lunch.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.fabrice.go4lunch.databinding.ActivityDetailRestaurantBinding;

import android.os.Bundle;
import android.view.View;



public class DetailRestaurantActivity extends AppCompatActivity {

    ActivityDetailRestaurantBinding mBinding;
    String restaurantId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDetailRestaurantBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        restaurantId = getIntent().getStringExtra("EXTRA_RESTAURANT_ID");
    }
}
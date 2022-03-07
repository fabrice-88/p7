package com.fabrice.go4lunch.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.databinding.ActivityMainBinding;
import com.fabrice.go4lunch.fragment.RestaurantFragment;
import com.fabrice.go4lunch.fragment.MapFragment;
import com.fabrice.go4lunch.fragment.WorkMateFragment;
import com.firebase.ui.auth.AuthUI;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ActivityMainBinding mBinding;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        configureToolBar();
        configureDrawerLayout();
        configureNavigationView();
        configureBottomView();
        replaceFragment(MapFragment.newInstance());
    }

    private void configureBottomView() {
        mBinding.bottomNavigation.setOnItemSelectedListener(item -> updateMainFragment(item.getItemId()));
    }

    @SuppressLint("NonConstantResourceId")
    private Boolean updateMainFragment(Integer id) {
        switch (id) {
            case R.id.map:
                mBinding.activityMainToolbar.setTitle("I'm Hungry!");
                replaceFragment(MapFragment.newInstance());
                break;
            case R.id.list:
                mBinding.activityMainToolbar.setTitle("I'm Hungry!");
                replaceFragment(RestaurantFragment.newInstance());
                break;
            case R.id.workmates:
                mBinding.activityMainToolbar.setTitle("Available workmates");
                replaceFragment(WorkMateFragment.newInstance());
        }
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
    }

    private void configureToolBar(){
        this.mToolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(mToolbar);
    }

    private void configureDrawerLayout(){
        this.mDrawerLayout = findViewById(R.id.activity_main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configureNavigationView(){
        NavigationView navigationView = findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.activity_main_drawer_yourLunch:
                break;
            case R.id.activity_main_drawer_settings:
                break;
            case R.id.activity_main_drawer_logout:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(task -> {
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            finish();
                        });
                break;
        }

        this.mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
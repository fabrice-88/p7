package com.fabrice.go4lunch.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.databinding.ActivityMainBinding;
import com.fabrice.go4lunch.fragment.ListFragment;
import com.fabrice.go4lunch.fragment.MapFragment;
import com.fabrice.go4lunch.fragment.WorkMateFragment;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        replaceFragment(MapFragment.newInstance());
        configureBottomView();
    }


    private void configureBottomView(){
        mBinding.bottomNavigation.setOnItemSelectedListener(item -> updateMainFragment(item.getItemId()));
    }


    @SuppressLint("NonConstantResourceId")
    private Boolean updateMainFragment(Integer id){
        switch (id) {
            case R.id.map:
                replaceFragment(MapFragment.newInstance());
                break;
            case R.id.list:
                replaceFragment(ListFragment.newInstance());
                break;
            case R.id.workmates:
                replaceFragment(WorkMateFragment.newInstance());
        }
        return true;
    }


   /* public void onClick(View v) {
        if (v.getId() == R.id.sign_out) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(task -> {
                        // user is now signed out
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                    });
        }
    }*/


    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
    }

}
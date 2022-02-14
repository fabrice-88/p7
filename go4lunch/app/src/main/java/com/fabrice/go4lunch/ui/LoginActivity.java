package com.fabrice.go4lunch.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.databinding.ActivityLoginBinding;
import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        startSignIn();
    }


    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            (result) -> {
                if (result.getResultCode() == RESULT_OK) {
                   startActivity(new Intent(this, MainActivity.class));
                    finish();
                    Toast.makeText(this, "success de connexion", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "error de connexion", Toast.LENGTH_SHORT).show();
                }
            });


    private void startSignIn() {
        AuthMethodPickerLayout customLayout = new AuthMethodPickerLayout
                .Builder(R.layout.activity_login)
                .setGoogleButtonId(R.id.btn_google)
                .setFacebookButtonId(R.id.btn_fb)
                .build();
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.FacebookBuilder().build(),
                        new AuthUI.IdpConfig.GoogleBuilder().build()))
                .setAuthMethodPickerLayout(customLayout)
                .build();
        signInLauncher.launch(signInIntent);
    }
}
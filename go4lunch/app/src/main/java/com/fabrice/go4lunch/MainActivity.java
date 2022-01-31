package com.fabrice.go4lunch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.fabrice.go4lunch.R;
import com.fabrice.go4lunch.databinding.ActivityMainBinding;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        startSignIn();
    }


    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            (result) -> {
                if (result.getResultCode() == RESULT_OK) {
                   startActivity(new Intent(this, SignedInActivity.class));
                    finish();
                    Toast.makeText(this, "succes de connexion", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "erreur de connexion", Toast.LENGTH_SHORT).show();
                }
            });



    private void startSignIn() {
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.FacebookBuilder().build(),
                        new AuthUI.IdpConfig.GoogleBuilder().build()))
                .build();
        signInLauncher.launch(signInIntent);
    }
}
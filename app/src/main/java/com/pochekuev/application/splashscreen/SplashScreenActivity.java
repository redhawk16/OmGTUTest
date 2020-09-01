package com.pochekuev.application.splashscreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pochekuev.application.PreferencesManager;
import com.pochekuev.application.Variables;
import com.pochekuev.application.login.LoginActivity;
import com.pochekuev.application.main.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    PreferencesManager preferencesManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferencesManager = PreferencesManager.getInstance(this);

        if(isUserLogged()) {
            startActivity(MainActivity.class);
        } else {
            startActivity(LoginActivity.class);
        }

    }

    private boolean isUserLogged() {
        return preferencesManager.getValue(Variables.FNPP_USER) > 0;

    }

    private void startActivity(Class<?> activity) {
        Intent loginActivity = new Intent(this, activity);
        startActivity(loginActivity);
        finish();
    }
}

package com.haysarodrigues.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.haysarodrigues.tvshow.R;

/**
 * Created by Haysa on 07/08/17.
 */

public class SplashScreenActivity extends AppCompatActivity implements Runnable {

    private static final String TAG = SplashScreenActivity.class.getSimpleName();


    int TIME_SPLASH = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(this, TIME_SPLASH);

    }

    @Override
    public void run() {

        startActivity(new Intent(this, MainActivity.class));
        finish();

    }
}

package com.example.buspass_v1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.buspass_v1.R;
public class SplashActivity extends AppCompatActivity {
    ImageView imageBusLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        imageBusLogo = findViewById(R.id.imageBusLogo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bus_animation);
        imageBusLogo.startAnimation(animation);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);


                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
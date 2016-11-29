package com.acusgazerock.splashscreenapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by beuuuhh on 29/11/2016.
 */
public class SplashActivity extends AppCompatActivity {
    private Thread splashTread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting layout,
        // the icon background in
        // drawable/background_splash.xml
        // init from manifest

        setContentView(R.layout.activity_splash);
        startAnimations();
    }


    private void startAnimations() {
        // start thread for pause time
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time,
                    // here if you want add initial
                    // ex: database, check connection internet
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashActivity.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashActivity.this.finish();
                }

            }
        };
        splashTread.start();

    }
}

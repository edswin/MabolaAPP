package com.example.keithgabmikay.mabolaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        new CountDownTimer(7000, 3000) {
            @Override
            public void onTick(long millisUntilFinished) {

                }

            @Override
            public void onFinish() {
                Intent dashboard = new Intent(MainActivity.this,Bottomnavi.class);
                startActivity(dashboard);
            }
        }.start();
        }

    }

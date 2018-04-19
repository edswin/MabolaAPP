package com.example.keithgabmikay.mabolaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        CountDownTimer start = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                ImageView mbl = (ImageView) findViewById(R.id.mbllogoimageView);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.mytransition);
                mbl.startAnimation(anim);
                mbl.setVisibility(View.VISIBLE);
                Intent dashboard = new Intent(MainActivity.this, Bottomnavi.class);
                startActivity(dashboard);
                finish();
            }
        }.start();
    }

    }

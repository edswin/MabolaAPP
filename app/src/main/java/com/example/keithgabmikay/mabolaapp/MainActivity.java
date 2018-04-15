package com.example.keithgabmikay.mabolaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

    //public Button btnContinue;
    private static int SPLASH_TIME_OUT = 3000;
   // public void init() {
   //     btnContinue = (Button) findViewById(R.id.btnContinue);
   //     btnContinue.setOnClickListener(new View.OnClickListener() {
   //         @Override
   //         public void onClick(View v) {
   //             Intent dashboard = new Intent(MainActivity.this, DashBoard.class);
   //             startActivity(dashboard);
   //         }
   //     });
   // }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dashboard = new Intent(MainActivity.this, DashBoard.class);
                startActivity(dashboard);
                finish();
                Intent gamesdashboard = new Intent(MainActivity.this, GamesFragment.class);
                startActivity(gamesdashboard);
            }
        }, SPLASH_TIME_OUT);


    }
}

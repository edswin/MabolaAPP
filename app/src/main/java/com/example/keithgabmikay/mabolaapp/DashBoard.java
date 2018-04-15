package com.example.keithgabmikay.mabolaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.Window;

public class DashBoard extends Activity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.app.Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.title_games:
                    Intent gamesdashboard = new Intent(DashBoard.this, GamesFragment.class);
                    startActivity(gamesdashboard);
                    return true;
                case R.id.title_latest:
                    return true;
                case R.id.title_standings:

                    return true;
                case R.id.title_schedule:

                    return true;
                case R.id.title_rules:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}

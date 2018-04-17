package com.example.keithgabmikay.mabolaapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Bottomnavi extends Activity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManger = getFragmentManager();
            android.app.FragmentTransaction transaction = fragmentManger.beginTransaction();
            switch (item.getItemId()) {
                case R.id.title_games:

                    transaction.replace(R.id.fragment_container,new GamesFragment()).commit();
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
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bottomnavi);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

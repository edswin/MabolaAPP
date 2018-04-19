package com.example.keithgabmikay.mabolaapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
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
                    transaction.replace(R.id.fragment_container,new LatestFragment()).commit();
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
        navigation.setSelectedItemId(R.id.title_games);
        ListView listView=(ListView) findViewById(R.id.gameslistview);
    }

    class CustomAdapter extends BaseAdapter {

          @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}

package com.example.keithgabmikay.mabolaapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;


public class GamesFragment extends Activity {

    private TextView theDate;

    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_games);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        theDate = findViewById(R.id.gamesCalendartextView);
        theDate.setText(currentDate);
    }

}
package com.example.keithgabmikay.mabolaapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemAdapter extends  BaseAdapter {

        LayoutInflater mInflator;
        Map<String, String> map;
        List<String> teamNameA;
        List<String> teamNameB;

        public ItemAdapter(Context c, Map m) {
            mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            map = m;
            teamNameA = new ArrayList<String>(map.keySet());
            teamNameB = new ArrayList<String>(map.keySet());

        }
        @Override
        public int getCount() {
            return map.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            @SuppressLint("ViewHolder") View v = mInflator.inflate(R.layout.fragment_itemgames,null);
            TextView teamA = (TextView) v.findViewById(R.id.teamatextview);
            TextView teamB = (TextView) v.findViewById(R.id.teambtext);

            teamA.setText(teamNameA.get(position));
            teamB.setText(teamNameB.get(position));
            return v;
        }
    }



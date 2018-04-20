package com.example.keithgabmikay.mabolaapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bottomnavi extends Activity {

    ItemAdapter itemAdapter;
    Context thisContext;
    ListView myListView;
    TextView textAView;
    TextView textBView;
    TextView dateView;
    TextView timeView;
    TextView ScoreBView;
    TextView ScoreAView;
    Map<String, String> teams = new LinkedHashMap<String, String>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManger = getFragmentManager();
            android.app.FragmentTransaction transaction = fragmentManger.beginTransaction();
            switch (item.getItemId()) {
                case R.id.title_games:
                    transaction.replace(R.id.fragment_container, new GamesFragment()).commit();
                    ListView hidelist = (ListView) findViewById(R.id.gameslistview);
                    hidelist.setVisibility(View.VISIBLE);
                    GetData retrieveData = new GetData();
                    retrieveData.execute("");
                    return true;
                case R.id.title_latest:
                    ListView latesthide = (ListView) findViewById(R.id.gameslistview);
                    latesthide.setVisibility(View.GONE);
                    transaction.replace(R.id.fragment_container, new LatestFragment()).commit();


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
        myListView = (ListView) findViewById(R.id.gameslistview);
        thisContext = this;


    }
    private class GetData extends AsyncTask<String, String, String> {
        String msg="";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://" +
        MySQLString.DATABASE_URL + "/" +
        MySQLString.DATABASE_NAME;

        @Override
        protected String doInBackground(String... strings) {
            Connection conn = null;
            Statement stmt = null;

            try {
                Class.forName(JDBC_DRIVER);
                conn = (Connection) DriverManager.getConnection(DB_URL,MySQLString.USERNAME,MySQLString.PASSWORD);
                stmt = (Statement) conn.createStatement();
                String sql = "Select * from mbl_game_schedule where mbl_game_datesched = '2018-04-21' ";
                 //conn.clientPrepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String mbl_game_teamA = rs.getString("mbl_game_teamA");
                    String mbl_game_teamB = rs.getString("mbl_game_teamA");
                    teams.put(mbl_game_teamB,"EDWIN");
                }

                rs.close();
                stmt.close();
                conn.close();

            } catch (ClassNotFoundException e) {
                msg = "An class exception was thrown";
                e.printStackTrace();
            } catch (SQLException connError) {
                msg = "An exception was thrown for JDBC";
                connError.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected  void onPostExecute(String msg) {
            if (teams.size() > 0) {
                itemAdapter = new ItemAdapter(thisContext,teams);
                myListView.setAdapter(itemAdapter);
            }
        }
    }

} //END


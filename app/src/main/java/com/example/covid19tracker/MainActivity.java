package com.example.covid19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    //UI Views
    private TextView titleTv;
    private ImageButton refreshBtn;
    private BottomNavigationView navigationView;
    //Fragments
    private Fragment homeFragment,statsFragments;
    private Fragment activeFragment;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init UI views
        titleTv = findViewById(R.id.titleTv);
        refreshBtn = findViewById(R.id.refreshBtn);
        navigationView = findViewById(R.id.navigationView);
        initFragments();
        //refresh button view
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        navigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initFragments() {
        homeFragment = new HomeFragment();
        statsFragments = new StatsFragment();

        fragmentManager = getSupportFragmentManager();
        activeFragment = homeFragment;

        fragmentManager.beginTransaction()
                .add(R.id.frame, homeFragment, "homeFragment")
                .commit();
        fragmentManager.beginTransaction()
                .add(R.id.frame, statsFragments, "statsFragment")
                .hide(statsFragments)
                .commit();
    }
    private void loadHomeFragment(){
        titleTv.setText("Home");
        fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
        activeFragment = homeFragment;
    } private void loadStatsFragment(){
        titleTv.setText("Stats");
        fragmentManager.beginTransaction().hide(activeFragment).show(statsFragments).commit();
        activeFragment = statsFragments;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //handle bottom nav item clicks
        switch (item.getItemId()){
            case R.id.nav_home:
                loadHomeFragment();
                //loadhome data
                return true;
            case R.id.nav_stats:
                loadStatsFragment();
                //loadstat data
                return true;
        }
        return false;
    }
}
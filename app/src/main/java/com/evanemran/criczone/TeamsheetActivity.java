package com.evanemran.criczone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.evanemran.criczone.Adapters.ViewPagerAdapter;
import com.evanemran.criczone.Fragments.TeamSheetsFragment;
import com.evanemran.criczone.Models.LiveScores.TeamSheets;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;

public class TeamsheetActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TeamSheets teamSheets;
    String home,away;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamsheet);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Team Sheet");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        teamSheets = (TeamSheets) getIntent().getSerializableExtra("teamsheet");
        home = getIntent().getStringExtra("home");
        away = getIntent().getStringExtra("away");


        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        TeamSheetsFragment homeTeamSheetFragment = new TeamSheetsFragment();
        TeamSheetsFragment awayTeamSheetFragment = new TeamSheetsFragment();

        Bundle first_bundle = new Bundle();
        first_bundle.putSerializable("teamsheet", (Serializable) teamSheets.getHome());
        homeTeamSheetFragment.setArguments(first_bundle);
        viewPagerAdapter.addFragment(homeTeamSheetFragment, home);

        Bundle second_bundle = new Bundle();
        second_bundle.putSerializable("teamsheet", (Serializable) teamSheets.getAway());
        awayTeamSheetFragment.setArguments(second_bundle);
        viewPagerAdapter.addFragment(awayTeamSheetFragment, away);

        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
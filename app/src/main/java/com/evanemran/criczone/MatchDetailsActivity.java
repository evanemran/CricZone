package com.evanemran.criczone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.evanemran.criczone.Adapters.LastOversAdapter;
import com.evanemran.criczone.Adapters.ViewPagerAdapter;
import com.evanemran.criczone.Fragments.FirstInningsFragment;
import com.evanemran.criczone.Fragments.SecondInningsFragment;
import com.evanemran.criczone.Listeners.OnFetchDataListener;
import com.evanemran.criczone.Models.Fixtures.FixturesResult;
import com.evanemran.criczone.Models.LiveScores.APIResponse;
import com.evanemran.criczone.Models.LiveScores.Scorecard;
import com.evanemran.criczone.Models.LiveScores.TeamSheets;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MatchDetailsActivity extends AppCompatActivity {
    RequestManager manager;
    TabLayout tabLayout;
    ViewPager viewPager;
    FixturesResult result;
    ProgressDialog dialog;
    ScrollView details_container;
    LastOversAdapter lastOversAdapter;
    RecyclerView recycler_innings_last_three_overs;
    Scorecard first_scorecard, second_scorecard;
    ImageView imageView_flag1, imageView_flag2;
    Boolean isFirstInnings = false;
    TeamSheets teamSheets;
    String home, away;
    SwipeRefreshLayout swipe_layout;
    TextView textView_match_officials;
    TextView textView_match_name, textView_match_venue, textView_match_date, textView_series_name, textView_teamsheets, textView_country_name_one, textView_match_status, textView_country_name_two, textView_match_result, textView_match_toss, textView_team1_score, textView_team2_score;
    TextView textView_team1_runrate, textView_partnership_one, textView_partnership_two, textView_partnership_runs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);

//        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Match Details");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        textView_match_name = findViewById(R.id.textView_match_name);
        textView_match_venue = findViewById(R.id.textView_match_venue);
        textView_match_date = findViewById(R.id.textView_match_date);
        textView_country_name_one = findViewById(R.id.textView_country_name_one);
        textView_series_name = findViewById(R.id.textView_series_name);
        textView_match_status = findViewById(R.id.textView_match_status);
        textView_country_name_two = findViewById(R.id.textView_country_name_two);
        textView_match_result = findViewById(R.id.textView_match_result);
        textView_match_toss = findViewById(R.id.textView_match_toss);
        textView_teamsheets = findViewById(R.id.textView_teamsheets);
        textView_team1_score = findViewById(R.id.textView_team1_score);
        textView_team2_score = findViewById(R.id.textView_team2_score);
        recycler_innings_last_three_overs = findViewById(R.id.recycler_innings_last_three_overs);
        imageView_flag1 = findViewById(R.id.imageView_flag1);
        imageView_flag2 = findViewById(R.id.imageView_flag2);
        details_container = findViewById(R.id.details_container);
        swipe_layout = findViewById(R.id.swipe_layout);
        textView_team1_runrate = findViewById(R.id.textView_team1_runrate);
        textView_partnership_one = findViewById(R.id.textView_partnership_one);
        textView_partnership_two = findViewById(R.id.textView_partnership_two);
        textView_partnership_runs = findViewById(R.id.textView_partnership_runs);
        textView_match_officials = findViewById(R.id.textView_match_officials);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading...");
        dialog.show();

        try {
            result = (FixturesResult) getIntent().getSerializableExtra("data");
        }catch (Exception e){
            e.printStackTrace();
        }

        manager = new RequestManager(MatchDetailsActivity.this);
        manager.getLiveScores(listener, String.valueOf(result.getId()));

        textView_teamsheets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MatchDetailsActivity.this, TeamsheetActivity.class);
                intent.putExtra("teamsheet", teamSheets);
                intent.putExtra("home", home);
                intent.putExtra("away", away);
                startActivity(intent);
            }
        });

        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                manager.getLiveScores(listener, String.valueOf(result.getId()));
                swipe_layout.setRefreshing(false);
            }
        });

//        setupViewPager(viewPager);
//        tabLayout.setupWithViewPager(viewPager);
    }

    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            dialog.dismiss();
            if (apiResponse==null){
                Toast.makeText(MatchDetailsActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                showResult(apiResponse);

                teamSheets = apiResponse.getResults().getLive_details().getTeamsheets();
                home = apiResponse.getResults().getFixture().getHome().getName();
                away = apiResponse.getResults().getFixture().getAway().getName();

                details_container.setVisibility(View.VISIBLE);
                if (apiResponse.getResults().getLive_details().getScorecard().size()==1){
                    first_scorecard = apiResponse.getResults().getLive_details().getScorecard().get(0);
                    isFirstInnings = true;
                }
                else{
                    first_scorecard = apiResponse.getResults().getLive_details().getScorecard().get(0);
                    second_scorecard = apiResponse.getResults().getLive_details().getScorecard().get(1);
                    isFirstInnings = false;
                }
                setupViewPager(viewPager, isFirstInnings);
                tabLayout.setupWithViewPager(viewPager);
            }catch (Exception e){
                Toast.makeText(MatchDetailsActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MatchDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showResult(APIResponse apiResponse) {
        textView_match_name.setText(apiResponse.getResults().getFixture().getMatch_title());
        textView_match_venue.setText(apiResponse.getResults().getFixture().getVenue());
        textView_match_officials.setText("Umpire 1: "+apiResponse.getResults().getLive_details().getOfficials().getUmpire_1()+
                " Umpire 2: "+apiResponse.getResults().getLive_details().getOfficials().getUmpire_2()+
                " Umpire TV: "+apiResponse.getResults().getLive_details().getOfficials().getUmpire_tv()+
                " Referee: "+apiResponse.getResults().getLive_details().getOfficials().getReferee()+
                " Umpire reserved: : "+apiResponse.getResults().getLive_details().getOfficials().getUmpire_reserve());
        textView_match_officials.setSelected(true);

        Picasso.get().load("https://assets.thebasetrip.com/api/v2/countries/flags/"+apiResponse.getResults().getFixture().getHome().getName().toLowerCase().trim() + ".png").placeholder(R.drawable.placeholder_flag).into(imageView_flag1);
        Picasso.get().load("https://assets.thebasetrip.com/api/v2/countries/flags/"+apiResponse.getResults().getFixture().getAway().getName().toLowerCase().trim() + ".png").placeholder(R.drawable.placeholder_flag).into(imageView_flag2);

        DateFormat date_formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        DateFormat final_formatter = new SimpleDateFormat("EEEE, MMM d, yyyy");
        try {
            Date date = date_formatter.parse(apiResponse.getResults().getFixture().getStart_date());
            String final_date = final_formatter.format(date);
            textView_match_date.setText(final_date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        textView_country_name_one.setText(apiResponse.getResults().getFixture().getHome().getCode());
        textView_country_name_two.setText(apiResponse.getResults().getFixture().getAway().getCode());
        textView_series_name.setText(apiResponse.getResults().getFixture().getSeries().getSeries_name() + " " + apiResponse.getResults().getFixture().getSeries().getSeason());
        String match_status = "";
        int status_color = getColor(R.color.white);
        if (apiResponse.getResults().getLive_details().getMatch_summary().getIn_play().equals("Yes")){
            match_status = "LIVE";
            status_color = getColor(R.color.green);
        }
        else if (apiResponse.getResults().getLive_details().getMatch_summary().getResult().equals("Yes")){
            match_status = "Completed";
            status_color = getColor(R.color.red);
        }
        else match_status = "Upcoming";
        textView_match_status.setText(match_status);
        textView_match_status.setTextColor(status_color);
        textView_match_result.setText(apiResponse.getResults().getLive_details().getMatch_summary().getStatus());
        textView_match_toss.setText(apiResponse.getResults().getLive_details().getMatch_summary().getToss());
        textView_team1_score.setText(apiResponse.getResults().getFixture().getHome().getName() + ": " + apiResponse.getResults().getLive_details().getMatch_summary().getHome_scores());
        textView_team2_score.setText(apiResponse.getResults().getFixture().getAway().getName() + ": " + apiResponse.getResults().getLive_details().getMatch_summary().getAway_scores());

        textView_team1_runrate.setText("Run Rate: "+apiResponse.getResults().getLive_details().getStats().getCurrent_run_rate());
        textView_partnership_one.setText(apiResponse.getResults().getLive_details().getStats().getPartnership_player_1()+": "+
                apiResponse.getResults().getLive_details().getStats().getPartnership_player_1_runs()+"("+
                apiResponse.getResults().getLive_details().getStats().getPartnership_player_1_balls()+")");
        textView_partnership_two.setText(apiResponse.getResults().getLive_details().getStats().getPartnership_player_2()+": "+
                apiResponse.getResults().getLive_details().getStats().getPartnership_player_2_runs()+"("+
                apiResponse.getResults().getLive_details().getStats().getPartnership_player_2_balls()+")");
        textView_partnership_runs.setText("Partnership "+apiResponse.getResults().getLive_details().getStats().getPartnership_runs()+" runs in "+apiResponse.getResults().getLive_details().getStats().getPartnership_overs()+" overs.");

        //last_3_overs
        recycler_innings_last_three_overs.setHasFixedSize(true);
        recycler_innings_last_three_overs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        lastOversAdapter = new LastOversAdapter(this, apiResponse.getResults().getLive_details().getStats().getLast_18_balls());
        recycler_innings_last_three_overs.setAdapter(lastOversAdapter);

    }

    private void setupViewPager(ViewPager viewPager, Boolean isFirstInnings){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        FirstInningsFragment firstInningsFragment = new FirstInningsFragment();
        SecondInningsFragment secondInningsFragment = new SecondInningsFragment();

        if (isFirstInnings){
            Bundle first_bundle = new Bundle();
            first_bundle.putSerializable("innings", first_scorecard);
            firstInningsFragment.setArguments(first_bundle);
            viewPagerAdapter.addFragment(firstInningsFragment, "1st Innings");
        }
        else{
            Bundle first_bundle = new Bundle();
            first_bundle.putSerializable("innings", first_scorecard);
            firstInningsFragment.setArguments(first_bundle);
            viewPagerAdapter.addFragment(firstInningsFragment, "1st Innings");
            Bundle second_bundle = new Bundle();
            second_bundle.putSerializable("innings", second_scorecard);
            secondInningsFragment.setArguments(second_bundle);
            viewPagerAdapter.addFragment(secondInningsFragment, "2nd Innings");
        }
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
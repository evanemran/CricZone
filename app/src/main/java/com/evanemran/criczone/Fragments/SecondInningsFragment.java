package com.evanemran.criczone.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.Adapters.BattingAdapter;
import com.evanemran.criczone.Adapters.BowlingAdapter;
import com.evanemran.criczone.Adapters.LastOversAdapter;
import com.evanemran.criczone.Adapters.StillToBatAdapter;
import com.evanemran.criczone.Models.LiveScores.Scorecard;
import com.evanemran.criczone.R;

public class SecondInningsFragment extends Fragment {
    View view;
    Scorecard scorecard;
    LinearLayout batting_container, bowling_container;
    LastOversAdapter lastOversAdapter;
    BattingAdapter battingAdapter;
    StillToBatAdapter stillToBatAdapter;
    BowlingAdapter bowlingAdapter;
    TextView textView_innings_title, textView_innings_runs, textView_innings_overs, textView_innings_wickets, textView_innings_extras, textView_innings_fow, textView_innings_extras_details;
    Button button_batting, button_bowling;
    RecyclerView recycler_innings_batting, recycler_innings_still_to_bat, recycler_innings_bowling;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second_innings, container, false);

        textView_innings_title = view.findViewById(R.id.textView_innings_title);
        textView_innings_runs = view.findViewById(R.id.textView_innings_runs);
        textView_innings_overs = view.findViewById(R.id.textView_innings_overs);
        textView_innings_wickets = view.findViewById(R.id.textView_innings_wickets);
        textView_innings_extras = view.findViewById(R.id.textView_innings_extras);
        textView_innings_fow = view.findViewById(R.id.textView_innings_fow);
        textView_innings_extras_details = view.findViewById(R.id.textView_innings_extras_details);
        button_batting = view.findViewById(R.id.button_batting);
        button_bowling = view.findViewById(R.id.button_bowling);
        recycler_innings_batting = view.findViewById(R.id.recycler_innings_batting);
        recycler_innings_still_to_bat = view.findViewById(R.id.recycler_innings_still_to_bat);
        recycler_innings_bowling = view.findViewById(R.id.recycler_innings_bowling);
        bowling_container = view.findViewById(R.id.bowling_container);
        batting_container = view.findViewById(R.id.batting_container);

        button_batting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bowling_container.setVisibility(View.GONE);
                batting_container.setVisibility(View.VISIBLE);
                button_batting.setBackgroundColor(getContext().getColor(R.color.green));
                button_bowling.setBackgroundColor(getContext().getColor(R.color.black));

            }
        });
        button_bowling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                batting_container.setVisibility(View.GONE);
                bowling_container.setVisibility(View.VISIBLE);
                button_bowling.setBackgroundColor(getContext().getColor(R.color.green));
                button_batting.setBackgroundColor(getContext().getColor(R.color.black));
            }
        });

        scorecard = (Scorecard) getArguments().getSerializable("innings");

        showData(scorecard);
        return view;
    }

    private void showData(Scorecard scorecard) {
        textView_innings_title.setText(scorecard.getTitle());
        textView_innings_runs.setText(String.valueOf(scorecard.getRuns()));
        textView_innings_overs.setText(scorecard.getOvers());
        textView_innings_wickets.setText(scorecard.getWickets());
        textView_innings_extras.setText(String.valueOf(scorecard.getExtras()));
        textView_innings_fow.setText(scorecard.getFow());
        textView_innings_extras_details.setText(scorecard.getExtras_detail());
        textView_innings_fow.setText(scorecard.getFow());
        textView_innings_fow.setText(scorecard.getFow());
        textView_innings_fow.setText(scorecard.getFow());

        //batting
        recycler_innings_batting.setHasFixedSize(true);
        recycler_innings_batting.setLayoutManager(new GridLayoutManager(getContext(), 1));
        battingAdapter = new BattingAdapter(getContext(), scorecard.getBatting());
        recycler_innings_batting.setAdapter(battingAdapter);

        //still_to_bat
        recycler_innings_still_to_bat.setHasFixedSize(true);
        recycler_innings_still_to_bat.setLayoutManager(new GridLayoutManager(getContext(), 1));
        stillToBatAdapter = new StillToBatAdapter(getContext(), scorecard.getStill_to_bat());
        recycler_innings_still_to_bat.setAdapter(stillToBatAdapter);

        //bowling
        recycler_innings_bowling.setHasFixedSize(true);
        recycler_innings_bowling.setLayoutManager(new GridLayoutManager(getContext(), 1));
        bowlingAdapter = new BowlingAdapter(getContext(), scorecard.getBowling());
        recycler_innings_bowling.setAdapter(bowlingAdapter);
    }
}

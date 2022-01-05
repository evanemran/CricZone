package com.evanemran.criczone.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.Adapters.TeamsheetAdapter;
import com.evanemran.criczone.Models.LiveScores.HomeTeam;
import com.evanemran.criczone.R;

import java.util.List;

public class TeamSheetsFragment extends Fragment {
    View view;
    RecyclerView recycler_teamsheets;
    TeamsheetAdapter teamsheetAdapter;
    List<HomeTeam> teams;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_teamsheets, container, false);
        recycler_teamsheets = view.findViewById(R.id.recycler_teamsheets);

        teams = (List<HomeTeam>) getArguments().getSerializable("teamsheet");

        recycler_teamsheets.setHasFixedSize(true);
        recycler_teamsheets.setLayoutManager(new GridLayoutManager(getContext(), 1));
        teamsheetAdapter = new TeamsheetAdapter(getContext(), teams);
        recycler_teamsheets.setAdapter(teamsheetAdapter);

        return view;
    }
}

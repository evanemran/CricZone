package com.evanemran.criczone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.Models.LiveScores.HomeTeam;
import com.evanemran.criczone.R;

import java.util.List;

public class TeamsheetAdapter extends RecyclerView.Adapter<TeamSheetViewHolder> {
    Context context;
    List<HomeTeam> list;

    public TeamsheetAdapter(Context context, List<HomeTeam> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TeamSheetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeamSheetViewHolder(LayoutInflater.from(context).inflate(R.layout.list_teamsheet, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull TeamSheetViewHolder holder, int position) {
        holder.textView_player_name.setText(list.get(position).getPlayer_name());
        holder.textView_player_position.setText(list.get(position).getPosition());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

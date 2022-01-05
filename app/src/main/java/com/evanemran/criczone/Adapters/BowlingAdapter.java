package com.evanemran.criczone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.Models.LiveScores.Bowling;
import com.evanemran.criczone.R;

import java.util.List;

public class BowlingAdapter extends RecyclerView.Adapter<BowlingViewHolder> {
    Context context;
    List<Bowling> list;

    public BowlingAdapter(Context context, List<Bowling> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BowlingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BowlingViewHolder(LayoutInflater.from(context).inflate(R.layout.list_bowling, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull BowlingViewHolder holder, int position) {
        holder.textView_bowler_name.setText(list.get(position).getPlayer_name());
        holder.textView_bowler_runs.setText(String.valueOf(list.get(position).getRuns_conceded()));
        holder.textView_bowler_overs.setText(list.get(position).getOvers() + "(" + list.get(position).getRuns_conceded() + ")");
        holder.textView_bowler_maidens.setText(String.valueOf(list.get(position).getMaidens()));
        holder.textView_bowler_wickets.setText(String.valueOf(list.get(position).getWickets()));
        holder.textView_bowler_dots.setText(String.valueOf(list.get(position).getDot_balls()));
        holder.textView_bowler_extras.setText(String.valueOf(list.get(position).getExtras()));
        holder.textView_bowler_fours.setText(String.valueOf(list.get(position).getFours()));
        holder.textView_bowler_sixes.setText(String.valueOf(list.get(position).getSixes()));
        holder.textView_bowler_economy.setText(list.get(position).getEconomy());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

package com.evanemran.criczone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.Models.LiveScores.Batting;
import com.evanemran.criczone.R;

import java.util.List;

public class BattingAdapter extends RecyclerView.Adapter<BattingViewHolder> {
    Context context;
    List<Batting> list;

    public BattingAdapter(Context context, List<Batting> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BattingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BattingViewHolder(LayoutInflater.from(context).inflate(R.layout.list_batting, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull BattingViewHolder holder, int position) {
        holder.textView_batsman_name.setText(list.get(position).getBat_order() +": "+ list.get(position).getPlayer_name());
        holder.textView_batsman_runs.setText(String.valueOf(list.get(position).getRuns()) + "(" + String.valueOf(list.get(position).getBalls()) + ")");
        holder.textView_batsman_boundaries.setText("4s: " + list.get(position).getFours() + " " + "6s: " + list.get(position).getSixes());
        holder.textView_batsman_dismissal.setText(list.get(position).getHow_out());
        holder.textView_batsman_strike_rate.setText(list.get(position).getStrike_rate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

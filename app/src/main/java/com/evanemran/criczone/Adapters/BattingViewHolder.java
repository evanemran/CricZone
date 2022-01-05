package com.evanemran.criczone.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.R;

public class BattingViewHolder extends RecyclerView.ViewHolder {
    TextView textView_batsman_name, textView_batsman_runs, textView_batsman_boundaries, textView_batsman_dismissal, textView_batsman_strike_rate;
    public BattingViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_batsman_name = itemView.findViewById(R.id.textView_batsman_name);
        textView_batsman_runs = itemView.findViewById(R.id.textView_batsman_runs);
        textView_batsman_boundaries = itemView.findViewById(R.id.textView_batsman_boundaries);
        textView_batsman_dismissal = itemView.findViewById(R.id.textView_batsman_dismissal);
        textView_batsman_strike_rate = itemView.findViewById(R.id.textView_batsman_strike_rate);
    }
}

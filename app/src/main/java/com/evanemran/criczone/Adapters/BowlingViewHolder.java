package com.evanemran.criczone.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.R;

public class BowlingViewHolder extends RecyclerView.ViewHolder {
    TextView textView_bowler_name, textView_bowler_overs, textView_bowler_runs, textView_bowler_maidens, textView_bowler_wickets, textView_bowler_dots, textView_bowler_extras, textView_bowler_fours, textView_bowler_sixes, textView_bowler_economy;
    public BowlingViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_bowler_name = itemView.findViewById(R.id.textView_bowler_name);
        textView_bowler_runs = itemView.findViewById(R.id.textView_bowler_runs);
        textView_bowler_overs = itemView.findViewById(R.id.textView_bowler_overs);
        textView_bowler_maidens = itemView.findViewById(R.id.textView_bowler_maidens);
        textView_bowler_wickets = itemView.findViewById(R.id.textView_bowler_wickets);
        textView_bowler_dots = itemView.findViewById(R.id.textView_bowler_dots);
        textView_bowler_extras = itemView.findViewById(R.id.textView_bowler_extras);
        textView_bowler_fours = itemView.findViewById(R.id.textView_bowler_fours);
        textView_bowler_sixes = itemView.findViewById(R.id.textView_bowler_sixes);
        textView_bowler_economy = itemView.findViewById(R.id.textView_bowler_economy);
    }
}

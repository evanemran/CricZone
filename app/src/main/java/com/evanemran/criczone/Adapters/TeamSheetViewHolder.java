package com.evanemran.criczone.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.R;

public class TeamSheetViewHolder extends RecyclerView.ViewHolder {
    TextView textView_player_name, textView_player_position;
    public TeamSheetViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_player_name = itemView.findViewById(R.id.textView_player_name);
        textView_player_position = itemView.findViewById(R.id.textView_player_position);
    }
}

package com.evanemran.criczone.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.R;

public class StillToBatViewHolder extends RecyclerView.ViewHolder {
    TextView textView_batsman_name;
    public StillToBatViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_batsman_name = itemView.findViewById(R.id.textView_batsman_name);
    }
}

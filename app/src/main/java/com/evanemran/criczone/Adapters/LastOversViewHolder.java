package com.evanemran.criczone.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.R;

public class LastOversViewHolder extends RecyclerView.ViewHolder {
    TextView textView_last_result, textView_last_ball;
    public LastOversViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_last_result = itemView.findViewById(R.id.textView_last_result);
        textView_last_ball = itemView.findViewById(R.id.textView_last_ball);
    }
}

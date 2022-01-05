package com.evanemran.criczone.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.Models.LiveScores.Last_Three_Overs;
import com.evanemran.criczone.R;

import java.util.List;

public class LastOversAdapter extends RecyclerView.Adapter<LastOversViewHolder> {

    Context context;
    List<Last_Three_Overs> list;

    public LastOversAdapter(Context context, List<Last_Three_Overs> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LastOversViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LastOversViewHolder(LayoutInflater.from(context).inflate(R.layout.list_last_overs, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LastOversViewHolder holder, int position) {
        if (list.get(position).isDismissal()){
            holder.textView_last_result.setText("W");
            holder.textView_last_result.setTextColor(Color.RED);
        }
        else if (list.get(position).isBoundary()){
            holder.textView_last_result.setText(String.valueOf(list.get(position).getRuns()));
            holder.textView_last_result.setTextColor(Color.GREEN);
        }
        else if (list.get(position).isWide()){
            holder.textView_last_result.setText("WD");
        }
        else if (list.get(position).isNoBall()){
            holder.textView_last_result.setText("NB");
        }
        else if (list.get(position).isBye()){
            holder.textView_last_result.setText(list.get(position).getRuns() + "b");
        }
        else if (list.get(position).isLegBye()){
            holder.textView_last_result.setText(list.get(position).getRuns() + "lb");
        }
        else {
            holder.textView_last_result.setText(String.valueOf(list.get(position).getRuns()));
        }

        holder.textView_last_ball.setText(list.get(position).getCurrentOver()+"."+list.get(position).getCurrentOverBall());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

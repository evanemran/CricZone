package com.evanemran.criczone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.Models.LiveScores.Still_to_bat;
import com.evanemran.criczone.R;

import java.util.List;

public class StillToBatAdapter extends RecyclerView.Adapter<StillToBatViewHolder> {
    Context context;
    List<Still_to_bat> list;

    public StillToBatAdapter(Context context, List<Still_to_bat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StillToBatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StillToBatViewHolder(LayoutInflater.from(context).inflate(R.layout.list_still_to_bat, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull StillToBatViewHolder holder, int position) {
        holder.textView_batsman_name.setText(list.get(position).getPlayer_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

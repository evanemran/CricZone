package com.evanemran.criczone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.Listeners.OnFixtureClickListener;
import com.evanemran.criczone.Models.Fixtures.FixturesResult;
import com.evanemran.criczone.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FixturesRecyclerAdapter extends RecyclerView.Adapter<FixturesViewHolder> {
    Context context;
    List<FixturesResult> list;
    OnFixtureClickListener listener;

    public FixturesRecyclerAdapter(Context context, List<FixturesResult> list, OnFixtureClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FixturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FixturesViewHolder(LayoutInflater.from(context).inflate(R.layout.list_fixture, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull FixturesViewHolder holder, int position) {

        DateFormat date_formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        DateFormat final_formatter = new SimpleDateFormat("EEEE, MMM d, yyyy");
        try {
//            String parsed_date = date_formatter.parse(list.get(position).getDate());
            Date date = date_formatter.parse(list.get(position).getDate());
            String final_date = final_formatter.format(date);
            holder.textView_time.setText(final_date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.textView_country_name_one.setText(list.get(position).getHome().getCode());
        holder.textView_country_name_two.setText(list.get(position).getAway().getCode());
        holder.textView_status.setText(list.get(position).getStatus());
        holder.textView_status.setSelected(true);
//        holder.textView_time.setText(list.get(position).getDate());
        holder.textView_time.setSelected(true);
        holder.textView_venue.setText(list.get(position).getVenue());
        holder.textView_venue.setSelected(true);
        holder.textView_result.setText(list.get(position).getResult());
        holder.textView_result.setSelected(true);
        holder.textView_match_title.setText(list.get(position).getMatch_title());
        holder.textView_match_title.setSelected(true);

        Picasso.get().load("https://assets.thebasetrip.com/api/v2/countries/flags/"+list.get(position).getHome().getName().toLowerCase().trim() + ".png").placeholder(R.drawable.placeholder_flag).into(holder.imageView_flag1);
        Picasso.get().load("https://assets.thebasetrip.com/api/v2/countries/flags/"+list.get(position).getAway().getName().toLowerCase().trim() + ".png").placeholder(R.drawable.placeholder_flag).into(holder.imageView_flag2);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

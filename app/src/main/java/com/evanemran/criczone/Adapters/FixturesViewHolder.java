package com.evanemran.criczone.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.criczone.R;

public class FixturesViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    TextView textView_match_title, textView_country_name_one, textView_country_name_two, textView_status,textView_time, textView_venue, textView_result;
    ImageView imageView_flag1,imageView_flag2;
    public FixturesViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_country_name_one = itemView.findViewById(R.id.textView_country_name_one);
        textView_country_name_two = itemView.findViewById(R.id.textView_country_name_two);
        textView_status = itemView.findViewById(R.id.textView_status);
        textView_time = itemView.findViewById(R.id.textView_time);
        textView_venue = itemView.findViewById(R.id.textView_venue);
        textView_result = itemView.findViewById(R.id.textView_result);
        imageView_flag1 = itemView.findViewById(R.id.imageView_flag1);
        imageView_flag2 = itemView.findViewById(R.id.imageView_flag2);
        textView_match_title = itemView.findViewById(R.id.textView_match_title);
        cardView = itemView.findViewById(R.id.cardView);
    }
}

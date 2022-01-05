package com.evanemran.criczone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.evanemran.criczone.Adapters.FixturesRecyclerAdapter;
import com.evanemran.criczone.Listeners.OnFixtureClickListener;
import com.evanemran.criczone.Listeners.OnFixturesFetchDataListener;
import com.evanemran.criczone.Models.Fixtures.FixtureAPIResponse;
import com.evanemran.criczone.Models.Fixtures.FixturesResult;

public class MainActivity extends AppCompatActivity implements OnFixtureClickListener {
    RecyclerView recyclerView;
    ProgressDialog dialog;
    FixturesRecyclerAdapter fixturesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        recyclerView = findViewById(R.id.recycler_match_fixture);
        dialog.setTitle("Loading...");
        dialog.show();

        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getMatchesBySeries(listener, "894" /*t20 worldcup code*/);
    }

    private final OnFixturesFetchDataListener listener = new OnFixturesFetchDataListener() {
        @Override
        public void onFetchData(FixtureAPIResponse apiResponse, String message) {
            dialog.dismiss();
            if (apiResponse==null){
                Toast.makeText(MainActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
                return;
            }
            showResult(apiResponse);

        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showResult(FixtureAPIResponse apiResponse) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        fixturesRecyclerAdapter = new FixturesRecyclerAdapter(this, apiResponse.getResults(), this);
        recyclerView.setAdapter(fixturesRecyclerAdapter);
    }

    @Override
    public void onClick(FixturesResult result) {
        if (!result.getResult().equals("")){
            Intent intent = new Intent(MainActivity.this, MatchDetailsActivity.class);
            intent.putExtra("data", result);
            startActivity(intent);
        }else{
//            Toast.makeText(this, "Upcoming!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MatchDetailsActivity.class);
            intent.putExtra("data", result);
            startActivity(intent);
        }
    }
}
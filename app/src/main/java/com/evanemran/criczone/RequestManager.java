package com.evanemran.criczone;

import android.content.Context;
import android.widget.Toast;

import com.evanemran.criczone.Listeners.OnFetchDataListener;
import com.evanemran.criczone.Listeners.OnFixturesFetchDataListener;
import com.evanemran.criczone.Models.Fixtures.FixtureAPIResponse;
import com.evanemran.criczone.Models.LiveScores.APIResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RequestManager {
    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://cricket-live-data.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getLiveScores(OnFetchDataListener listener, String matchId){
        getMatchScore callLiveScore = retrofit.create(getMatchScore.class);
        Call<APIResponse> call =callLiveScore.getScore(matchId);

        try{
            call.enqueue(new Callback<APIResponse>() {
                @Override
                public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context, "Max request limit reached! Contact developer to upgrade the plan.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body(), response.message());
                }

                @Override
                public void onFailure(Call<APIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }

            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Error Occurred!!", Toast.LENGTH_SHORT).show();
        }

    }
    public void getMatchesBySeries(OnFixturesFetchDataListener listener, String seriesId){
        getMatchBySeries callFixtureBySeries = retrofit.create(getMatchBySeries.class);
        Call<FixtureAPIResponse> call =callFixtureBySeries.getFixtureBySeries(seriesId);

        try{
            call.enqueue(new Callback<FixtureAPIResponse>() {
                @Override
                public void onResponse(Call<FixtureAPIResponse> call, Response<FixtureAPIResponse> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context, "Max request limit reached! Contact developer to upgrade the plan.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body(), response.message());
                }

                @Override
                public void onFailure(Call<FixtureAPIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }

            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Error Occurred!!", Toast.LENGTH_SHORT).show();
        }

    }
    public void getFixtures(OnFixturesFetchDataListener listener){
        getMatchFixtures callFixtures = retrofit.create(getMatchFixtures.class);
        Call<FixtureAPIResponse> call =callFixtures.getFixtures();

        try{
            call.enqueue(new Callback<FixtureAPIResponse>() {
                @Override
                public void onResponse(Call<FixtureAPIResponse> call, Response<FixtureAPIResponse> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context, "Max request limit reached! Contact developer to upgrade the plan.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body(), response.message());
                }

                @Override
                public void onFailure(Call<FixtureAPIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }

            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Error Occurred!!", Toast.LENGTH_SHORT).show();
        }

    }
    public void getResults(OnFixturesFetchDataListener listener){
        getMatchResults callResults = retrofit.create(getMatchResults.class);
        Call<FixtureAPIResponse> call =callResults.getResults();

        try{
            call.enqueue(new Callback<FixtureAPIResponse>() {
                @Override
                public void onResponse(Call<FixtureAPIResponse> call, Response<FixtureAPIResponse> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context, "Max request limit reached! Contact developer to upgrade the plan.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body(), response.message());
                }

                @Override
                public void onFailure(Call<FixtureAPIResponse> call, Throwable t) {
                    listener.onError("Request Failed!");
                }

            });
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Error Occurred!!", Toast.LENGTH_SHORT).show();
        }

    }

    public interface getMatchScore {
        @Headers({
                "Accept: application/json",
                "x-rapidapi-host: cricket-live-data.p.rapidapi.com",
                "x-rapidapi-key: fc089b1732mshc6d17a22dd56501p1781fcjsn111633acbf95"
        })
        @GET("match/{matchId}")
        Call<APIResponse> getScore(
                @Path("matchId") String matchId
        );
    }

    public interface getMatchFixtures {
        @Headers({
                "Accept: application/json",
                "x-rapidapi-host: cricket-live-data.p.rapidapi.com",
                "x-rapidapi-key: fc089b1732mshc6d17a22dd56501p1781fcjsn111633acbf95"
        })
        @GET("fixtures")
        Call<FixtureAPIResponse> getFixtures();
    }

    public interface getMatchResults {
        @Headers({
                "Accept: application/json",
                "x-rapidapi-host: cricket-live-data.p.rapidapi.com",
                "x-rapidapi-key: fc089b1732mshc6d17a22dd56501p1781fcjsn111633acbf95"
        })
        @GET("results")
        Call<FixtureAPIResponse> getResults();
    }

    public interface getMatchBySeries {
        @Headers({
                "Accept: application/json",
                "x-rapidapi-host: cricket-live-data.p.rapidapi.com",
                "x-rapidapi-key: fc089b1732mshc6d17a22dd56501p1781fcjsn111633acbf95"
        })
        @GET("fixtures-by-series/{seriesId}")
        Call<FixtureAPIResponse> getFixtureBySeries(
                @Path("seriesId") String seriesId
        );
    }

}

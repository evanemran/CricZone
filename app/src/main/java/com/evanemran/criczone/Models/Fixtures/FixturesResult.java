package com.evanemran.criczone.Models.Fixtures;

import com.evanemran.criczone.Models.LiveScores.Away;
import com.evanemran.criczone.Models.LiveScores.Home;

import java.io.Serializable;

public class FixturesResult implements Serializable {
    int id = 0;
    int series_id = 0;
    String venue = "";
    String date = "";
    String status = "";
    String result = "";
    String match_title = "";
    String match_subtitle = "";
    Home home;
    Away away;

    public int getId() {
        return id;
    }

    public int getSeries_id() {
        return series_id;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    public String getMatch_title() {
        return match_title;
    }

    public String getMatch_subtitle() {
        return match_subtitle;
    }

    public Home getHome() {
        return home;
    }

    public Away getAway() {
        return away;
    }
}

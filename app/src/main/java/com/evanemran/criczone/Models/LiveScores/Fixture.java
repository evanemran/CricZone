package com.evanemran.criczone.Models.LiveScores;

import java.util.List;

public class Fixture {
    int id = 0;
    int series_id = 0;
    String match_title = "";
    String venue = "";
    String start_date = "";
    String end_date = "";
    List<Dates> dates;
    Home home;
    Away away;
    Series series;

    public int getId() {
        return id;
    }

    public int getSeries_id() {
        return series_id;
    }

    public String getMatch_title() {
        return match_title;
    }

    public String getVenue() {
        return venue;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public List<Dates> getDates() {
        return dates;
    }

    public Home getHome() {
        return home;
    }

    public Away getAway() {
        return away;
    }

    public Series getSeries() {
        return series;
    }
}

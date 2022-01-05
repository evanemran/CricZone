package com.evanemran.criczone.Models.LiveScores;

public class Series {
    int series_id = 0;
    String series_name = "";
    String status = "";
    String season = "";
    String updated_at = "";

    public int getSeries_id() {
        return series_id;
    }

    public String getSeries_name() {
        return series_name;
    }

    public String getStatus() {
        return status;
    }

    public String getSeason() {
        return season;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}

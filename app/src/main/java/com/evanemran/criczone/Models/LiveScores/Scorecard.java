package com.evanemran.criczone.Models.LiveScores;

import java.io.Serializable;
import java.util.List;

public class Scorecard implements Serializable {
    int innings_number = 0;
    boolean current = false;
    String title = "";
    String overs = "";
    int runs = 0;
    String wickets = "";
    int extras = 0;
    String extras_detail = "";
    String fow = "";
    List<Batting> batting;
    List<Still_to_bat> still_to_bat;
    List<Bowling> bowling;

    public int getInnings_number() {
        return innings_number;
    }

    public boolean isCurrent() {
        return current;
    }

    public String getTitle() {
        return title;
    }

    public String getOvers() {
        return overs;
    }

    public int getRuns() {
        return runs;
    }

    public String getWickets() {
        return wickets;
    }

    public int getExtras() {
        return extras;
    }

    public String getExtras_detail() {
        return extras_detail;
    }

    public String getFow() {
        return fow;
    }

    public List<Batting> getBatting() {
        return batting;
    }

    public List<Still_to_bat> getStill_to_bat() {
        return still_to_bat;
    }

    public List<Bowling> getBowling() {
        return bowling;
    }
}

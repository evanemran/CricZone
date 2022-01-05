package com.evanemran.criczone.Models.LiveScores;

import java.io.Serializable;

public class Bowling implements Serializable {
    int player_id = 0;
    String player_name = "";
    String overs = "";
    int maidens = 0;
    int runs_conceded = 0;
    int wickets = 0;
    String economy = "";
    int dot_balls = 0;
    int fours = 0;
    int sixes = 0;
    int extras = 0;

    public int getPlayer_id() {
        return player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getOvers() {
        return overs;
    }

    public int getMaidens() {
        return maidens;
    }

    public int getRuns_conceded() {
        return runs_conceded;
    }

    public int getWickets() {
        return wickets;
    }

    public String getEconomy() {
        return economy;
    }

    public int getDot_balls() {
        return dot_balls;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    public int getExtras() {
        return extras;
    }
}

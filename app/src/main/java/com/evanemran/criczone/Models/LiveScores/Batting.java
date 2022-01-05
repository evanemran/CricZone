package com.evanemran.criczone.Models.LiveScores;

import java.io.Serializable;

public class Batting implements Serializable {
    int bat_order = 0;
    int player_id = 0;
    String player_name = "";
    String how_out = "";
    String minutes = "";
    int runs = 0;
    int balls = 0;
    int fours = 0;
    int sixes = 0;
    String strike_rate = "";

    public int getBat_order() {
        return bat_order;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getHow_out() {
        return how_out;
    }

    public String getMinutes() {
        return minutes;
    }

    public int getRuns() {
        return runs;
    }

    public int getBalls() {
        return balls;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    public String getStrike_rate() {
        return strike_rate;
    }
}

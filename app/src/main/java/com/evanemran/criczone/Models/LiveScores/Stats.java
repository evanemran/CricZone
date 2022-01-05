package com.evanemran.criczone.Models.LiveScores;

import java.util.List;

public class Stats {
    String current_run_rate = "";
    String min_remaining_overs = "";
    String partnership_player_1 = "";
    int partnership_player_1_runs = 0;
    int partnership_player_1_balls = 0;
    String partnership_player_2 = "";
    int partnership_player_2_runs = 0;
    int partnership_player_2_balls = 0;
    String partnership_run_rate = "";
    String partnership_overs = "";
    int partnership_runs = 0;
    List<Last_Three_Overs> last_18_balls;
    String last_update = "";

    public String getCurrent_run_rate() {
        return current_run_rate;
    }

    public String getMin_remaining_overs() {
        return min_remaining_overs;
    }

    public String getPartnership_player_1() {
        return partnership_player_1;
    }

    public int getPartnership_player_1_runs() {
        return partnership_player_1_runs;
    }

    public int getPartnership_player_1_balls() {
        return partnership_player_1_balls;
    }

    public String getPartnership_player_2() {
        return partnership_player_2;
    }

    public int getPartnership_player_2_runs() {
        return partnership_player_2_runs;
    }

    public int getPartnership_player_2_balls() {
        return partnership_player_2_balls;
    }

    public String getPartnership_run_rate() {
        return partnership_run_rate;
    }

    public String getPartnership_overs() {
        return partnership_overs;
    }

    public int getPartnership_runs() {
        return partnership_runs;
    }

    public List<Last_Three_Overs> getLast_18_balls() {
        return last_18_balls;
    }

    public String getLast_update() {
        return last_update;
    }
}

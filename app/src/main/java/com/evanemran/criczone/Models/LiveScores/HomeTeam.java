package com.evanemran.criczone.Models.LiveScores;

import java.io.Serializable;

public class HomeTeam implements Serializable {
    int player_id = 0;
    String player_name = "";
    String position = "";

    public int getPlayer_id() {
        return player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getPosition() {
        return position;
    }
}

package com.evanemran.criczone.Models.LiveScores;

import java.io.Serializable;
import java.util.List;

public class TeamSheets implements Serializable {
    List<HomeTeam> home;
    List<HomeTeam> away;

    public List<HomeTeam> getHome() {
        return home;
    }

    public List<HomeTeam> getAway() {
        return away;
    }
}

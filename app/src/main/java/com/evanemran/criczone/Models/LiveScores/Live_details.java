package com.evanemran.criczone.Models.LiveScores;

import java.util.List;

public class Live_details {
    Match_Summary match_summary;
    Officials officials;
    List<Scorecard> scorecard;
    Stats stats;
    TeamSheets teamsheets;

    public Match_Summary getMatch_summary() {
        return match_summary;
    }

    public Officials getOfficials() {
        return officials;
    }

    public List<Scorecard> getScorecard() {
        return scorecard;
    }

    public Stats getStats() {
        return stats;
    }

    public TeamSheets getTeamsheets() {
        return teamsheets;
    }
}

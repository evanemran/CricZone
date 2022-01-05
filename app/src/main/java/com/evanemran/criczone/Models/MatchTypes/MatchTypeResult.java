package com.evanemran.criczone.Models.MatchTypes;

import com.evanemran.criczone.Models.LiveScores.Series;

public class MatchTypeResult {
    String type = "";
    Series series;

    public String getType() {
        return type;
    }

    public Series getSeries() {
        return series;
    }
}

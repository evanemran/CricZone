package com.evanemran.criczone.Models.MatchTypes;

import java.util.List;

public class APIResponseMatchType {
    Meta meta;
    List<MatchTypeResult> results;

    public Meta getMeta() {
        return meta;
    }

    public List<MatchTypeResult> getResults() {
        return results;
    }
}

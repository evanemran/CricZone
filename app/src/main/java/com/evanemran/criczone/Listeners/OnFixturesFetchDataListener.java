package com.evanemran.criczone.Listeners;

import com.evanemran.criczone.Models.Fixtures.FixtureAPIResponse;

public interface OnFixturesFetchDataListener {
    void onFetchData(FixtureAPIResponse apiResponse, String message);
    void onError(String message);
}

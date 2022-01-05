package com.evanemran.criczone.Listeners;

import com.evanemran.criczone.Models.LiveScores.APIResponse;

public interface OnFetchDataListener {
    void onFetchData(APIResponse apiResponse, String message);
    void onError(String message);
}

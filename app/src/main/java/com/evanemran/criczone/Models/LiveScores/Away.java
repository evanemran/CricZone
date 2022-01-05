package com.evanemran.criczone.Models.LiveScores;

import java.io.Serializable;

public class Away implements Serializable {
    int id = 0;
    String name = "";
    String code = "";

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}

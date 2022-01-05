package com.evanemran.criczone.Models.LiveScores;

public class Last_Three_Overs {
    boolean isDismissal = false;
    boolean isBoundary = false;
    boolean isWide = false;
    boolean isMaiden = false;
    boolean isNoBall = false;
    boolean isBye = false;
    boolean isOverEnd = false;
    int currentOver = 0;
    int runs = 0;
    boolean isLegBye = false;
    int currentOverBall = 0;

    public boolean isDismissal() {
        return isDismissal;
    }

    public boolean isBoundary() {
        return isBoundary;
    }

    public boolean isWide() {
        return isWide;
    }

    public boolean isMaiden() {
        return isMaiden;
    }

    public boolean isNoBall() {
        return isNoBall;
    }

    public boolean isBye() {
        return isBye;
    }

    public boolean isOverEnd() {
        return isOverEnd;
    }

    public int getCurrentOver() {
        return currentOver;
    }

    public int getRuns() {
        return runs;
    }

    public boolean isLegBye() {
        return isLegBye;
    }

    public int getCurrentOverBall() {
        return currentOverBall;
    }
}

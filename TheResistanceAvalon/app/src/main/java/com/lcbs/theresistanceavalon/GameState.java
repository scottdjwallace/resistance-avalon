package com.lcbs.theresistanceavalon;

public class GameState {

    private static GameState instance = null;
    private int NUM_OF_PLAYERS;
    private int NUM_GOOD_PLAYERS;
    private int NUM_BAD_PLAYERS;

    protected GameState() {
        NUM_OF_PLAYERS = 5; // default for now
    }

    public static GameState getInstance() {
        if (instance == null) instance = new GameState();
        return instance;
    }

    public int getNUM_OF_PLAYERS() {
        return NUM_OF_PLAYERS;
    }

    public void setNUM_OF_PLAYERS(int num) {
        NUM_OF_PLAYERS = num;
    }


}

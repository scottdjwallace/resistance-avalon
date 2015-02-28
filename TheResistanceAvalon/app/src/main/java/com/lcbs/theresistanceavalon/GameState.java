package com.lcbs.theresistanceavalon;

public class GameState {

    private static GameState instance = null;
    private int NUMBER_OF_PLAYERS;

    protected GameState() {
        NUMBER_OF_PLAYERS = 5; // default for now
    }

    public static GameState getInstance() {
        if (instance == null) instance = new GameState();
        return instance;
    }

    public int getNUMBER_OF_PLAYERS() {
        return NUMBER_OF_PLAYERS;
    }

    public void setNUMBER_OF_PLAYERS(int num) {
        NUMBER_OF_PLAYERS = num;
    }


}

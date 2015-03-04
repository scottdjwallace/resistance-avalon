package com.lcbs.theresistanceavalon;

import java.util.Random;

public class GameState {

    private static GameState instance = null;
    private int NUM_OF_PLAYERS;
    private int NUM_GOOD_PLAYERS;
    private int NUM_BAD_PLAYERS;
    private Player[] players;

    protected GameState() {
        // Default Values
        NUM_OF_PLAYERS = 5;
        NUM_GOOD_PLAYERS = 3;
        NUM_BAD_PLAYERS = 2;
        players = new Player[10];
    }

    public static GameState getInstance() {
        if (instance == null) instance = new GameState();
        return instance;
    }

    // Accessors
    public int getNumPLayers() {
        return NUM_OF_PLAYERS;
    }
    public int getNumGoodPlayers() { return NUM_GOOD_PLAYERS; }
    public int getNumBadPlayers() { return NUM_BAD_PLAYERS; }
    public Player[] getPlayers() { return players; }

    // Mutators
    public void setNumPlayers(int num) {
        NUM_OF_PLAYERS = num;
        setGoodBad(NUM_OF_PLAYERS);
    }

    private void setGoodBad(int num) {
        switch (num) {
            case 5:
                NUM_GOOD_PLAYERS = 3;
                NUM_BAD_PLAYERS = 2;
                break;
            case 6:
                NUM_GOOD_PLAYERS = 4;
                NUM_BAD_PLAYERS = 2;
                break;
            case 7:
                NUM_GOOD_PLAYERS = 4;
                NUM_BAD_PLAYERS = 3;
                break;
            case 8:
                NUM_GOOD_PLAYERS = 5;
                NUM_BAD_PLAYERS = 3;
                break;
            case 9:
                NUM_GOOD_PLAYERS = 6;
                NUM_BAD_PLAYERS = 3;
                break;
            case 10:
                NUM_GOOD_PLAYERS = 6;
                NUM_BAD_PLAYERS = 4;
                break;
            default:
                NUM_GOOD_PLAYERS = 3;
                NUM_BAD_PLAYERS = 2;
        }
    }

    public void createPlayers(String[] names) {
        int good = 0;
        int bad = 0;
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            int motive = randInt(0,1);
            if (motive == 0 && bad < NUM_BAD_PLAYERS) { // evil and still need evil
                bad++;
            }
            else if (motive == 0 && bad == NUM_BAD_PLAYERS) { // evil and we don't need evil
                motive = 1;
                good++;
            }
            else if (motive == 1 && good < NUM_GOOD_PLAYERS) { // good and we need good
                good++;
            }
            else { // good and we don't need good
                motive = 0;
                bad++;
            }
            players[i] = new Player(names[i], motive);
        }
    }

    private int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}

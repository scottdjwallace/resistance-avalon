package com.lcbs.theresistanceavalon;

import java.util.Random;

public class GameState {

    // Class variables
    private static GameState instance = null;
    private int NUM_OF_PLAYERS;
    private int NUM_GOOD_PLAYERS;
    private int NUM_BAD_PLAYERS;
    private int REJECTED_ROUNDS;
    private int ROUND;
    private int GOOD_SCORE;
    private int BAD_SCORE;
    private int NEXT_PLAYER;
    private Player[] players;
    private int[][] PLAYERS_PER_ROUND;
    private Player[] TEAM_THIS_ROUND;

    // protected constructor
    protected GameState() {
        // Default Values
        ROUND = 1;
        GOOD_SCORE = 0;
        BAD_SCORE = 0;
        NUM_OF_PLAYERS = 5;
        NUM_GOOD_PLAYERS = 3;
        NUM_BAD_PLAYERS = 2;
        REJECTED_ROUNDS = 0;
        players = new Player[10];
        NEXT_PLAYER = 0;
        PLAYERS_PER_ROUND = new int[][]{{2,3,2,3,3}, {2,3,4,3,4}, {2,3,3,4,4}, {3,4,4,5,5}, {3,4,4,5,5}, {3,4,4,5,5}, }; // [num players][round]
    } // end GameState

    // getInstance -- singleton class
    public static GameState getInstance() {
        if (instance == null) instance = new GameState();
        return instance;
    } // end getInstance

    // Resets entire game
    public void resetGame() {
        ROUND = 1;
        GOOD_SCORE = 0;
        BAD_SCORE = 0;
        NUM_OF_PLAYERS = 5;
        NUM_GOOD_PLAYERS = 3;
        NUM_BAD_PLAYERS = 2;
        REJECTED_ROUNDS = 0;
        players = new Player[10];
    } // end resetGame

    // accessors for private variables
    public int getNumPlayers() {
        return NUM_OF_PLAYERS;
    }
    public int getNumGoodPlayers() { return NUM_GOOD_PLAYERS; }
    public int getNumBadPlayers() { return NUM_BAD_PLAYERS; }
    public Player[] getPlayers() { return players; }
    public int getRejectedRounds() { return REJECTED_ROUNDS; }
    public int getRound() { return ROUND; }
    public int getBadScore() { return BAD_SCORE; }
    public int getGoodScore() { return GOOD_SCORE; }
    public int getNumPlayersThisRound() { return PLAYERS_PER_ROUND[NUM_OF_PLAYERS][ROUND];  }
    // end accessors

    // sets number of player in the game
    public void setNumPlayers(int num) {
        NUM_OF_PLAYERS = num;
        setGoodBad(NUM_OF_PLAYERS);
    } // setNumPlayers

    // sets number of good and bad players in the game, called in setNumPlayers
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
        } // end switch
    } // end setGoodBad

    // increments REJECTED_ROUNDS when a quest team has been voted no on
    public void newRejectedRound() {
        REJECTED_ROUNDS++;
    } // end newRejectedRound

    // resets REJECTED_ROUNDS
    public void resetRejectedRounds() {
        REJECTED_ROUNDS = 0;
    } // end resetRejectedRounds

    // increments round counter
    public void newRound() {
        ROUND++;
    } // end newRound

    // increments scores after a round has completed
    public void roundWin(String team) {
        if (team == "good") {
            GOOD_SCORE++;
        } else {
            BAD_SCORE++;
        }
    } // end roundWin

    // takes list of user inputted names and creates a player object with a motive
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
    } // end createPlayers

    // creates a random Int
    private int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    } // end randInt

    public String getTeamCaptain() {
        int i = NEXT_PLAYER;
        if (i > NUM_OF_PLAYERS - 1) {
            i = 0;
            NEXT_PLAYER = 1;
        } else {
            NEXT_PLAYER++;
        }
        return players[i].getName();
    }

    public void setTeamThisRound(Player[] selected) {
        TEAM_THIS_ROUND = selected;
    }
    public Player[] getTeamThisRound() { return TEAM_THIS_ROUND; }

} // end GameState.java
package com.lcbs.theresistanceavalon;
import java.util.Random;

/**
 * Created by ecosse_18 on 15-04-02.
 */

public class Game {

    // Singleton Variable
    private static Game instance = null;

    // Class Variables
    private int numberOfPlayers;
    private int numberOfGoodPlayers;
    private int numberOfBadPlayers;
    private int numberOfRejectedRounds;
    private int currentRound;
    private int goodScore;
    private int badScore;
    private int nextTeamCaptain;
    private Player[] players;
    private Player[] teamThisRound;
                                               // Round  1 2 3 4 5
    final private int[][] playersPerRound = new int[][]{{2,3,2,3,3}, // 5 players
                                                        {2,3,4,3,4}, // 6 players
                                                        {2,3,3,4,4}, // 7 players
                                                        {3,4,4,5,5}, // 8 players
                                                        {3,4,4,5,5}, // 9 players
                                                        {3,4,4,5,5}, // 10 players
                                                        };

    // Game constructor, protected
    protected Game() {
        currentRound = 1;
        goodScore = 0;
        badScore = 0;
        numberOfPlayers = 0;
        numberOfGoodPlayers = 0;
        numberOfBadPlayers = 0;
        numberOfRejectedRounds = 0;
        nextTeamCaptain = 0;
        players = new Player[10];
        teamThisRound = new Player[10];
    } // end Game constructor

    // getInstance returns the instance of our singleton class
    public static Game getInstance() {
        if (instance == null) instance = new Game();
        return instance;
    } // end getInstance

    // Resets all game's values
    public void resetGame() { instance = null; }

    // accessors for private variables
    public int getNumberOfPlayers() { return numberOfPlayers; }
    public int getNumberOfGoodPlayers() { return numberOfGoodPlayers; }
    public int getNumberOfBadPlayers() { return numberOfBadPlayers; }
    public int getNumberOfRejectedRounds() { return numberOfRejectedRounds; }
    public int getCurrentRound() { return currentRound; }
    public int getBadScore() { return badScore; }
    public int getGoodScore() { return goodScore; }
    public int getNumberOfPlayersThisRound() { return playersPerRound[numberOfPlayers - 5][currentRound - 1]; }
    public Player[] getPlayers() { return players; }
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

    public void setTeamThisRound(String[] selected) {
        TEAM_THIS_ROUND = selected;
    }
    public String[] getTeamThisRound() { return TEAM_THIS_ROUND; }

    public boolean gameOver() {
        if (REJECTED_ROUNDS == 5) {
            return true;
        }
        if (GOOD_SCORE == 3) {
            return true;
        }
        if (BAD_SCORE == 3){
            return true;
        }
        return false;
    }

    public String listEvilPlayers() {
        String p = "";
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            if (players[i].getMotive() == "Evil"){
                p += players[i].getName() + "   ";
            }
        }
        return p;
    }

    public String listEvilPlayers(Player player) {
        String p = "";
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            if (players[i].getMotive() == "Evil"){
                if (players[i].getName() != player.getName()){
                    p += players[i].getName() + "   ";
                }
            }
        }
        return p;
    }

} // end GameState.java

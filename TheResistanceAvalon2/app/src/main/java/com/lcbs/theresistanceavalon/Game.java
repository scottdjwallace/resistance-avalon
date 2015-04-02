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


    // Resets all variables in game
    public void resetGame() { instance = null; }


    // creates a random Int between min & max
    private int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    } // end randInt


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
    public Player[] getTeamThisRound() { return teamThisRound; }
    // end accessors


    // sets number of player in the game, and how many good/bad players there are
    // # of Players     Good    Evil
    //          5       3       2
    //          6       4       2
    //          7       4       3
    //          8       5       3
    //          9       6       3
    //         10       6       4
    public void setNumberOfPlayers(int n) {
        numberOfPlayers = n;
        if (n % 2 == 0) {
            int half = n / 2;
            numberOfGoodPlayers = half + 1;
            numberOfBadPlayers = half - 1;
        } else {
            int half = (n+1) / 2;
            numberOfGoodPlayers = half;
            numberOfBadPlayers = half - 1;
        }
        if (n == 9) { numberOfBadPlayers = 3; numberOfGoodPlayers = 6; }
    } // setNumberOfPlayers


    // if a team gets rejected this will increment
    public void addRejectedRound() { numberOfRejectedRounds++; }


    // increments to next round, and updates score
    public void finishRound(String winner) {
        currentRound++;
        if (winner == "good") {
            goodScore++;
        } else {
            badScore++;
        }
    } // finishRound


    // takes list of user inputted names and creates a player object with a motive
    public void createPlayers(String[] givenNames) {
        int good = 0;
        int evil = 0;

        for (int i = 0; i < numberOfPlayers; i++) {
            int team = randInt(0,1);
            if (team == 0 && evil < numberOfBadPlayers) { // evil && need evil
                evil++;
            }
            else if (team == 1 && good < numberOfGoodPlayers) { // good && need good
                good++;
            }
            else if (team == 0 && evil == numberOfBadPlayers) { // evil but need good
                team = 1;
                good++;
            } else { // good but need evil
                team = 0;
                evil++;
            }
            players[i] = new Player(givenNames[i], team);
        } // end for loop
    } // end createPlayers


    // picks a team captain to propose a team
    public String pickTeamCaptain() {
        int i = nextTeamCaptain;
        if (i > numberOfPlayers - 1) {
            i = 0;
            nextTeamCaptain = 1;
        } else {
            nextTeamCaptain++;
        }
        return players[i].getName();
    } // end pickTeamCaptain


    // sets the selected team this round
    public void pickTeamThisRound(Player[] selected) {
        teamThisRound = selected;
    } // end pickTeamThisRound


    // checks to see if game is over
    public boolean isGameOver() {
        if (numberOfRejectedRounds == 5)
            return true;
        if (goodScore == 3)
            return true;
        if (badScore == 3)
            return true;
        return false;
    } // end isGameOver


    // lists all evil players
    public String listAllEvilPlayers() {
        String allEvil = "";
        int added = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i].getTeamInt() == 0){
                if (added == numberOfBadPlayers){
                    allEvil += players[i].getName();
                } else {
                    allEvil += players[i].getName() + ",  ";
                    added++;
                } // end if
            } // end if
        } // end for loop
        return allEvil;
    } // end listAllEvilPlayers


    // lists all other evil players and excludes doNotList
    public String listOtherEvilPlayers(Player doNotList) {
        String allEvil = "";
        int added = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i].getTeamInt() == 0){
                if (players[i].getName() != doNotList.getName()) {
                    if (added == numberOfBadPlayers) {
                        allEvil += players[i].getName();
                    } else {
                        allEvil += players[i].getName() + ",  ";
                        added++;
                    } // end if
                } // end if
            } // end if
        } // end for loop
        return allEvil;
    }

} // end Game.java

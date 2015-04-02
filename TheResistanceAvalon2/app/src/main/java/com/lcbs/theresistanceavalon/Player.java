package com.lcbs.theresistanceavalon;

/**
 * Created by ecosse_18 on 15-04-02.
 */
// Player class holds player information such as name and which team they are one
public class Player {

    private String name;
    private int team;
    // good == 1, bad == 0

    public Player ()
    {
        this.name = "Player";
        this.team = -1;
    }


    // creates new Player
    public Player (String name, int team)
    {
        this.name = name;
        this.team = team;
    } // end Player constructor


    // accesses Player's name
    public String getName()
    {
        if (name != null)
            return name;
        return "null";
    } // end getName


    // accesses Player's Team as a string
    public String getTeamString()
    {
        if (team == 1) return "Good";
        return "Evil";
    } // end getTeamString


    // accesses Player's Team as an int
    public int getTeamInt(){
        return team;
    }

} // end Game

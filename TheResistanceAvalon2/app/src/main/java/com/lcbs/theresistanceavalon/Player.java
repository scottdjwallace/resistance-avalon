package com.lcbs.theresistanceavalon;

/**
 * Created by ecosse_18 on 15-04-02.
 */
// Player class holds player information such as name and which team they are one
public class Player {

    private String name;
    private int team;
    // good == 1, bad == 0

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
    } // end getMotive

    // accesses Player's Motive
    public String getMotive()
    {
        if (team == 1) return "Good";
        return "Evil";
    } // end getMotive

} // end Game

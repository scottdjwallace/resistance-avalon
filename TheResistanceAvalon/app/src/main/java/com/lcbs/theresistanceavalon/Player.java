package com.lcbs.theresistanceavalon;

public class Player {

    private String name;
    private int motive; // good == 1, bad == 0

    public Player (String name, int motive) {
        this.name = name;
        this.motive = motive;
    }

    public String getName() { return name; }
    public int getMotive() { return motive; }

}

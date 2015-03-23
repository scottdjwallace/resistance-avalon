package com.lcbs.theresistanceavalon;

public class Player {

    private String name;
    private int motive; // good == 1, bad == 0

    public Player (String name, int motive) {
        this.name = name;
        this.motive = motive;
    }

    public String getName() {
        if (name != null) {
            return name;
        }
        return "null";
    }

    public String getMotive() {
        if (motive == 1) return "Good";
        return "Evil";
    }

}

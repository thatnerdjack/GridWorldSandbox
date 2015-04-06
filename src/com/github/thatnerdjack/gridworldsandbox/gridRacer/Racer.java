package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Critter;

/**
 * Created by block7 on 3/26/15.
 */
public class Racer extends Critter {
    private final int acceleration;
    private final int handling;

    private int health = 100;
    private int fuel = 100;

    public Racer() {
        acceleration = (int)(Math.random() * 10);
        handling = (int)(Math.random() * 10);
    }

    public Racer(int acceleration, int handling) {
        this.acceleration = acceleration;
        this.handling = handling;
    }

//    public void act() {
//        Location loc = getLocation();
//        loc.getAdjacentLocation(Location.WEST);
//        makeMove(loc);
//    }
}

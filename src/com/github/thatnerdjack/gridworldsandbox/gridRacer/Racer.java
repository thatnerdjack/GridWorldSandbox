package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Actor;

/**
 * Created by block7 on 3/26/15.
 */
public class Racer extends Actor {
    private final int intel;
    private final int acceleration;
    private final int handling;
    private int health = 100;

    public Racer() {
        intel = (int)(Math.random() * 10);
        acceleration = (int)(Math.random() * 10);
        //START HERE: FIGURE OUT HOW TO GET HANDLING FROM INTEL AND ACCEL
    }
}

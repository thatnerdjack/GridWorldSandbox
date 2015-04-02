package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Critter;

/**
 * Created by block7 on 3/26/15.
 */
public class Racer extends Critter {
    private final int intel;
    private final int acceleration;
    private final int handling;

    private int health = 100;

    public Racer() {
        intel = (int)(Math.random() * 10);
        acceleration = (int)(Math.random() * 10);
        handling = Math.round(((intel / 2) + (acceleration / -2)));
    }

    public Racer(int acceleration, int intel, int handling) {
        this.acceleration = acceleration;
        this.intel = intel;
        this.handling = handling;
    }

    public void act() {

    }
}

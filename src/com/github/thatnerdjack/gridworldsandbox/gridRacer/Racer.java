package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by block7 on 3/26/15.
 */
public class Racer extends Critter {
    private final int acceleration;
    private final int handling;

    private int health = 100;
    private int fuel = 100;
    private int movingDirection = Location.WEST;

    public Racer() {
        acceleration = (int)(Math.random() * 10);
        handling = (int)(Math.random() * 10);
    }

    public Racer(int acceleration, int handling) {
        this.acceleration = acceleration;
        this.handling = handling;
    }

    public void act() {
        Integer turnFlag = Racetrack.getInstance().turnFlags.get(getLocation());
        if(turnFlag != null){
            movingDirection = turnFlag;
        }

        Location moveLoc = getLocation().getAdjacentLocation(movingDirection);
        makeMove(moveLoc);
    }
}

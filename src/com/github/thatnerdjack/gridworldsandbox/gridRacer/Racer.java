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
        if(this.getGrid() != null) {
            ArrayList actors = this.getActors();
            this.processActors(actors);
            Location loc = this.getLocation();
            Location moveLoc = loc.getAdjacentLocation(movingDirection);
            this.makeMove(moveLoc);
        }
    }

    public void processActors(ArrayList<Actor> actors) {
        Iterator i$ = actors.iterator();

        while(i$.hasNext()) {
            Actor a = (Actor)i$.next();
            if(!(a instanceof Obstacle) && !(a instanceof Racer)) {
                a.removeSelfFromGrid();
            }
        }

    }
}

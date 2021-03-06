package com.github.thatnerdjack.gridworldsandbox.firstClassProject;

/**
 * Created by block7 on 3/23/15.
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Iterator;

public class LSRHSCritter extends Critter {
    private int health;
    private final int CRITTER_HEALTH_DAMAGE_VALUE = 5;
    private final int FLOWER_HEALTH_GAIN_VALUE = 1;

    public LSRHSCritter(int health) {
        this.health = health;
    }

    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors) {
        Iterator i$ = actors.iterator();

        while(i$.hasNext()) {
            Actor a = (Actor)i$.next();
            if(!(a instanceof Rock)) {
                if(a instanceof Critter) {
                    a.removeSelfFromGrid();
                    health = health - CRITTER_HEALTH_DAMAGE_VALUE;
                    break;
                } else if(!(a instanceof Critter)) {
                    a.removeSelfFromGrid();
                    health = health + FLOWER_HEALTH_GAIN_VALUE;
                    break;
                }
            }
            healthSetColor();
        }
    }

    private void healthSetColor() {
        setColor(getColor().darker());
    }

    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc) {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
}

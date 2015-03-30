package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Rock;

/**
 * Created by block7 on 3/26/15.
 */
public abstract class TrackObject extends Rock{
    boolean isSolid;
    private final int X, Y;

    public TrackObject(boolean isSolid, int x, int y) {
        this.isSolid = isSolid;
        this.X = x;
        this.Y = y;
    }
}

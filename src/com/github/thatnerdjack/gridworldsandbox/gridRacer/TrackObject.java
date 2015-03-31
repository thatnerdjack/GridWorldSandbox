package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Rock;

/**
 * Created by block7 on 3/26/15.
 */
public abstract class TrackObject extends Rock{
    boolean isSolid;

    public TrackObject(boolean isSolid) {
        this.isSolid = isSolid;
    }
}

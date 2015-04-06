package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Actor;

/**
 * Created by block7 on 3/26/15.
 */
public abstract class TrackObject extends Actor{
    boolean isSolid;

    public TrackObject(boolean isSolid) {
        this.isSolid = isSolid;
    }
}

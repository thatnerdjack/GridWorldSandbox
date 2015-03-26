package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;

/**
 * Created by block7 on 3/26/15.
 */
public class Racetrack extends ActorWorld {
    private int trackHeight;
    private int trackWidth;
    private final int DEFAULT_TRACK_HEIGHT = 50;
    private final int DEFAULT_TRACK_WIDTH = 100;
    private final BoundedGrid grid;
    final ActorWorld track;

    public Racetrack() {
        trackHeight = DEFAULT_TRACK_HEIGHT;
        trackWidth = DEFAULT_TRACK_WIDTH;
        grid = new BoundedGrid(trackHeight, trackWidth);
        track = new ActorWorld(grid);
    }

    public Racetrack(int trackHeight, int trackWidth) {
        this.trackHeight = trackHeight;
        this.trackWidth = trackWidth;
        grid = new BoundedGrid(trackHeight, trackWidth);
        track = new ActorWorld(grid);
    }

    public void generateTrack() {

    }

    /* Getters */
    public int getTrackHeight() {
        return trackHeight;
    }

    public int getTrackWidth() {
        return trackWidth;
    }
}

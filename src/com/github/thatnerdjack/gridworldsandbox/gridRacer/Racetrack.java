package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

/**
 * Created by block7 on 3/26/15.
 */
public class Racetrack extends ActorWorld {
    private final int TRACK_HEIGHT;
    private final int TRACK_WIDTH;
    private final int DEFAULT_TRACK_HEIGHT = 50;
    private final int DEFAULT_TRACK_WIDTH = 100;
    private final BoundedGrid grid;
    final ActorWorld track;

    public Racetrack() {
        TRACK_HEIGHT = DEFAULT_TRACK_HEIGHT;
        TRACK_WIDTH = DEFAULT_TRACK_WIDTH;
        grid = new BoundedGrid(TRACK_HEIGHT, TRACK_WIDTH);
        track = new ActorWorld(grid);
    }

    public Racetrack(int trackHeight, int trackWidth) {
        this.TRACK_HEIGHT = trackHeight;
        this.TRACK_WIDTH = trackWidth;
        grid = new BoundedGrid(trackHeight, trackWidth);
        track = new ActorWorld(grid);
    }

    public void generateTrack() {
        for(int i = 0; i < TRACK_WIDTH; i++) { //upper wall
            Location loc = new Location(0, i);
            track.add(loc, new Wall(loc.getRow(), loc.getCol()));
        }
        for(int i = 0; i < TRACK_HEIGHT; i++) { //left wall
            Location loc = new Location(i, 0);
            track.add(loc, new Wall(loc.getRow(), loc.getCol()));
        }
        for(int i = 0; i < TRACK_WIDTH - 1; i++) { //lower wall
            Location loc = new Location(TRACK_HEIGHT - 1, i);
            track.add(loc, new Wall(loc.getRow(), loc.getCol()));
        }
        for(int i = 0; i < TRACK_HEIGHT; i++) { //right wall
            Location loc = new Location(i, TRACK_WIDTH - 1);
            track.add(loc, new Wall(loc.getRow(), loc.getCol()));
        }
    }

    public void showWorld() {
        track.show();
    }

    /* Getters */
    public int getTRACK_HEIGHT() {
        return TRACK_HEIGHT;
    }

    public int getTRACK_WIDTH() {
        return TRACK_WIDTH;
    }
}

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
        generateTrack();
    }

    public Racetrack(int trackHeight, int trackWidth) {
        this.TRACK_HEIGHT = trackHeight;
        this.TRACK_WIDTH = trackWidth;
        grid = new BoundedGrid(trackHeight, trackWidth);
        track = new ActorWorld(grid);
        generateTrack();
    }

    public void generateTrack() {
        for(int i = 0; i < TRACK_WIDTH; i++) { //upper outer wall
            Location loc = new Location(0, i);
            track.add(loc, new Wall());
        }
        for(int i = 0; i < TRACK_HEIGHT; i++) { //left outer wall
            Location loc = new Location(i, 0);
            track.add(loc, new Wall());
        }
        for(int i = 0; i < TRACK_WIDTH - 1; i++) { //lower outer wall
            Location loc = new Location(TRACK_HEIGHT - 1, i);
            track.add(loc, new Wall());
        }
        for(int i = 0; i < TRACK_HEIGHT; i++) { //right outer wall
            Location loc = new Location(i, TRACK_WIDTH - 1);
            track.add(loc, new Wall());
        }
        for(int i = 10; i < 40; i++) { //left inner wall
            Location loc = new Location(i, 10);
            track.add(loc, new Wall());
        }
        for(int i = 10; i < 40; i++) { //right inner wall
            Location loc = new Location(i, 89);
            track.add(loc, new Wall());
        }
        for(int i = 11; i < 89; i++) { //upper inner wall
            Location loc = new Location(10, i);
            track.add(loc, new Wall());
        }
        for(int i = 11; i < 89; i++) { //lower inner wall
            Location loc = new Location(39, i);
            track.add(loc, new Wall());
        }
    }

    public void makeWall(int length, int constantCoord, int firstVarCoord, boolean isVertical) {
        if(isVertical) {
            for(int i = firstVarCoord; i < length; i++) {
                Location loc = new Location(i, constantCoord);
                track.add(loc, new Wall());
            }
        } else {
            for(int i = firstVarCoord; i < length; i++) {
                Location loc = new Location(0, i);
                track.add(loc, new Wall());
            }
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

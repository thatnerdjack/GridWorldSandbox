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
    private final ActorWorld track;

    public Racetrack() {
        TRACK_HEIGHT = DEFAULT_TRACK_HEIGHT;
        TRACK_WIDTH = DEFAULT_TRACK_WIDTH;
        grid = new BoundedGrid(TRACK_HEIGHT, TRACK_WIDTH);
        track = new ActorWorld(grid);
        generateTrack();
    }

//    public Racetrack(int trackHeight, int trackWidth) {
//        this.TRACK_HEIGHT = trackHeight;
//        this.TRACK_WIDTH = trackWidth;
//        grid = new BoundedGrid(trackHeight, trackWidth);
//        track = new ActorWorld(grid);
//        generateTrack();
//    }

    public void generateTrack() {
        fillWithWalls(new Location(0,0), new Location(0,99)); //upper outer wall
        fillWithWalls(new Location(0,0), new Location(49,0)); //left outer wall
        fillWithWalls(new Location(49,0), new Location(49,99)); //lower outer wall
        fillWithWalls(new Location(0,99), new Location(49,99)); //right outer wall
        fillWithWalls(new Location(10,10), new Location(39,10)); //left inner wall
        fillWithWalls(new Location(10,89), new Location(39,89)); //right inner wall
        fillWithWalls(new Location(10,10), new Location(10,89)); //upper inner wall
        fillWithWalls(new Location(39,10), new Location(39,20)); //left lower inner wall
        fillWithWalls(new Location(39,26), new Location(39,73)); //center lower inner wall
        fillWithWalls(new Location(39,79), new Location(39,89)); //right lower inner wall
        fillWithWalls(new Location(35,26), new Location(35,73)); //lower pit wall
        fillWithWalls(new Location(30,20), new Location(30,79)); //upper pit wall
        fillWithWalls(new Location(30,20), new Location(38,20)); //left outer pit wall
        fillWithWalls(new Location(30,79), new Location(38,79)); //right outer pit wall
        fillWithWalls(new Location(35,26), new Location(38,26)); //left inner pit wall
        fillWithWalls(new Location(35,73), new Location(38,73)); //right outer pit wall
    }

    public void fillWithWalls(Location startLoc, Location endLoc){
        int x = startLoc.getCol();
        int y = startLoc.getRow();

        while(true){
            track.add(new Location(y, x), new Wall());

            if(x == endLoc.getCol() && y == endLoc.getRow()){
                break;
            }

            if(x == endLoc.getCol()){
                x = startLoc.getCol();

                if(startLoc.getRow() - endLoc.getRow() > 0){
                    y -= 1;
                } else {
                    y += 1;
                }
            } else {
                x++;
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

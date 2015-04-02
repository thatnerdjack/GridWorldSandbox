package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        fillWithWallsRectangle(new Location(0,0), new Location(49,99));
        fillWithWallsRectangle(new Location(10,10), new Location(39,89), Location.SOUTH);
        fillWithWallsRectangle(new Location(39,10), new Location(39,20), Location.NORTH, Location.WEST);
        //START HERE REPLACING WALLS WITH NEW METHOD
        fillWithWalls(new Location(35, 26), new Location(35, 73)); //lower pit wall
        fillWithWalls(new Location(30, 20), new Location(30, 79)); //upper pit wall
        fillWithWalls(new Location(30,20), new Location(38,20)); //left outer pit wall
        fillWithWalls(new Location(30,79), new Location(38,79)); //right outer pit wall
        fillWithWalls(new Location(35,26), new Location(38,26)); //left inner pit wall
        fillWithWalls(new Location(35,73), new Location(38,73)); //right outer pit wall
    }

    public void fillWithWallsRectangle(Location topLeft, Location bottomRight) {
        fillWithWallsRectangle(topLeft, bottomRight, new Integer[]{});
    }

    public void fillWithWallsRectangle(Location topLeft, Location bottomRight, Integer... exclude){
        List<Integer> excludeList = new ArrayList<Integer>();

        if(exclude != null){
            excludeList = Arrays.asList(exclude);
        }

        //Top
        if(!excludeList.contains(Location.NORTH)) {
            fillWithWalls(new Location(topLeft.getRow(), topLeft.getCol()), new Location(topLeft.getRow(), bottomRight.getCol()));
        }

        //Bottom
        if(!excludeList.contains(Location.SOUTH)) {
            fillWithWalls(new Location(bottomRight.getRow(), topLeft.getCol()), new Location(bottomRight.getRow(), bottomRight.getCol()));
        }

        //Left
        if(!excludeList.contains(Location.WEST)) {
            fillWithWalls(new Location(topLeft.getRow(), topLeft.getCol()), new Location(bottomRight.getRow(), topLeft.getCol()));
        }

        //Right
        if(!excludeList.contains(Location.EAST)) {
            fillWithWalls(new Location(topLeft.getRow(), bottomRight.getCol()), new Location(bottomRight.getRow(), bottomRight.getCol()));
        }
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

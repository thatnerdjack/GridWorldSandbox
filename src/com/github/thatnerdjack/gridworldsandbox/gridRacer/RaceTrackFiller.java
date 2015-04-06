//for future use

package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by block7 on 4/2/15.
 */
public abstract class RaceTrackFiller {
    private ActorWorld world;

    public RaceTrackFiller(ActorWorld world) {
        this.world = world;
    }

    public abstract Actor getActor(Location location);

    public void fillWithActorsRectangle(Location topLeft, Location bottomRight) {
        fillWithActorsRectangle(topLeft, bottomRight, new Integer[]{});
    }

    public void fillWithActorsRectangle(Location topLeft, Location bottomRight, Integer... exclude){
        List<Integer> excludeList = new ArrayList<Integer>();

        if(exclude != null){
            excludeList = Arrays.asList(exclude);
        }

        //Top
        if(!excludeList.contains(Location.NORTH)) {
            fillWithActors(new Location(topLeft.getRow(), topLeft.getCol()), new Location(topLeft.getRow(), bottomRight.getCol()));
        }

        //Bottom
        if(!excludeList.contains(Location.SOUTH)) {
            fillWithActors(new Location(bottomRight.getRow(), topLeft.getCol()), new Location(bottomRight.getRow(), bottomRight.getCol()));
        }

        //Left
        if(!excludeList.contains(Location.WEST)) {
            fillWithActors(new Location(topLeft.getRow(), topLeft.getCol()), new Location(bottomRight.getRow(), topLeft.getCol()));
        }

        //Right
        if(!excludeList.contains(Location.EAST)) {
            fillWithActors(new Location(topLeft.getRow(), bottomRight.getCol()), new Location(bottomRight.getRow(), bottomRight.getCol()));
        }
    }

    public void fillWithActors(Location startLoc, Location endLoc){
        int x = startLoc.getCol();
        int y = startLoc.getRow();

        while(true){
            world.add(new Location(y, x), getActor(new Location(y, x)));

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
}

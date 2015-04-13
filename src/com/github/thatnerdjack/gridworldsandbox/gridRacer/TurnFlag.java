package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Created by block7 on 4/13/15.
 */
public class TurnFlag extends TrackMarking {
    private final int TURNING_DIRECTION;
    private final int MAX_ROW;
    private final int MAX_COL;

    public TurnFlag(int TURNING_DIRECTION) {
        this.TURNING_DIRECTION = TURNING_DIRECTION;
        switch(TURNING_DIRECTION) {
            case Location.NORTH:
                MAX_ROW = 40;
                MAX_COL = 9;
                break;
            case Location.EAST:
                MAX_ROW = 9;
                MAX_COL = 9;
                break;
            case Location.SOUTH:
                MAX_ROW = 9;
                MAX_COL = 90;
                break;
            case Location.WEST:
                MAX_ROW = 40;
                MAX_COL = 90;
                break;
            default:
                MAX_ROW = -1;
                MAX_COL = -1;
        }
    }

    @Override
    public void act() {
        ArrayList<Location> emptyAdjacentLocations = getGrid().getEmptyAdjacentLocations(getLocation());
        for(Location location : emptyAdjacentLocations) {
            switch(TURNING_DIRECTION) {
                case Location.NORTH:
                case Location.WEST:
                    if((location.getRow() > MAX_ROW) && (location.getCol() < MAX_COL))
                        Racetrack.getInstance().add(location, new TurnFlag(TURNING_DIRECTION));
                    break;
                case Location.EAST:
                case Location.SOUTH:
                    if((location.getRow() < MAX_ROW) && (location.getCol() > MAX_COL))
                        Racetrack.getInstance().add(location, new TurnFlag(TURNING_DIRECTION));
                    break;
            }
        }
    }

    public int getTURNING_DIRECTION() {
        return TURNING_DIRECTION;
    }
}

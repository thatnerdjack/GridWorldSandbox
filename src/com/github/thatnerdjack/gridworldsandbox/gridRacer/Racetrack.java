package com.github.thatnerdjack.gridworldsandbox.gridRacer;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by block7 on 3/26/15.
 */
public class Racetrack extends ActorWorld {
    private final int TRACK_HEIGHT;
    private final int TRACK_WIDTH;
    private final int DEFAULT_TRACK_HEIGHT = 50;
    private final int DEFAULT_TRACK_WIDTH = 100;

    public static int _CURRENT_TURN_FLAG_DIRECTION = 0;

    private static Racetrack ourInstance = new Racetrack();

    HashMap<Location, Integer> turnFlags;

    public static Racetrack getInstance(){
        if(ourInstance == null){
            ourInstance = new Racetrack();
        }

        return ourInstance;
    }

    private Racetrack() {
        TRACK_HEIGHT = DEFAULT_TRACK_HEIGHT;
        TRACK_WIDTH = DEFAULT_TRACK_WIDTH;
        this.setGrid(new BoundedGrid(TRACK_HEIGHT, TRACK_WIDTH));
        this.turnFlags = new HashMap<Location, Integer>();
    }

//    public Racetrack(int trackHeight, int trackWidth) {
//        this.TRACK_HEIGHT = trackHeight;
//        this.TRACK_WIDTH = trackWidth;
//        this.setGrid(new BoundedGrid(trackHeight, trackWidth));
//        generateTrack();
//    }

    public void generateTrack() {
        //walls
        RaceTrackFiller wallFiller = new RaceTrackFiller(Racetrack.getInstance()) {
            @Override
            public Actor getActor(Location location) {
                return new Wall();
            }
        };

        wallFiller.fillWithActorsRectangle(new Location(0, 0), new Location(49, 99));
        wallFiller.fillWithActorsRectangle(new Location(10, 10), new Location(39, 89), Location.SOUTH);
        wallFiller.fillWithActorsRectangle(new Location(39, 10), new Location(39, 20), Location.NORTH, Location.WEST);
        wallFiller.fillWithActorsRectangle(new Location(35, 26), new Location(39, 73)); //lower pit wall section
        wallFiller.fillWithActorsRectangle(new Location(30, 20), new Location(39, 79), Location.SOUTH);
        wallFiller.fillWithActorsRectangle(new Location(39, 80), new Location(39, 88));

        RaceTrackFiller turnFlagFiller =  new RaceTrackFiller(getInstance()) {
            @Override
            public void addActor(Location location, Actor actor) {

            }

            @Override
            public Actor getActor(Location location) {
                turnFlags.put(location, _CURRENT_TURN_FLAG_DIRECTION);
                return new Actor();
            }
        };


        _CURRENT_TURN_FLAG_DIRECTION = Location.NORTH;
        turnFlagFiller.fillWithActorsDiagonalLine(new Location(48, 1), new Location(40, 9));


        _CURRENT_TURN_FLAG_DIRECTION = Location.EAST;
        turnFlagFiller.fillWithActorsDiagonalLine(new Location(1, 1), new Location(9, 9));

        _CURRENT_TURN_FLAG_DIRECTION = Location.SOUTH;
        turnFlagFiller.fillWithActorsDiagonalLine(new Location(9, 90), new Location(1, 98));

        _CURRENT_TURN_FLAG_DIRECTION = Location.WEST;
        turnFlagFiller.fillWithActorsDiagonalLine(new Location(40, 90), new Location(48, 98));
    }

    public static void startRace() {
        Racetrack.getInstance().add(new Location(40, 50), new Racer());
        Racetrack.getInstance().add(new Location(41, 50), new Racer());
        Racetrack.getInstance().add(new Location(42, 50), new Racer());
        Racetrack.getInstance().add(new Location(43, 50), new Racer());
        Racetrack.getInstance().add(new Location(44, 50), new Racer());
        Racetrack.getInstance().add(new Location(45, 50), new Racer());
        Racetrack.getInstance().add(new Location(46, 50), new Racer());
        Racetrack.getInstance().add(new Location(47, 50), new Racer());
        Racetrack.getInstance().add(new Location(48, 50), new Racer());
    }

    /* Getters */
    public int getTRACK_HEIGHT() {
        return TRACK_HEIGHT;
    }

    public int getTRACK_WIDTH() {
        return TRACK_WIDTH;
    }
}

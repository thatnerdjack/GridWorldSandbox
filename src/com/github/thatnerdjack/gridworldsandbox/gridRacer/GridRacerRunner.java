package com.github.thatnerdjack.gridworldsandbox.gridRacer;

/**
 * Created by block7 on 3/26/15.
 */
public class GridRacerRunner {

    public static void main(String args[]) {
        Racetrack.getInstance().generateTrack();
        Racetrack.getInstance().addOccupantClass(Racer.class.getName());
        Racetrack.getInstance().add(new Racer(1));
        Racetrack.getInstance().show();
    }

}

package com.github.thatnerdjack.gridworldsandbox.firstClassProject;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.awt.*;

/**
 * Created by block7 on 3/23/15.
 */
public class LSRHSRunner {

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Location(7, 8), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(2, 8), new Flower(Color.BLUE));
        world.add(new Location(5, 5), new Flower(Color.PINK));
        world.add(new Location(1, 5), new Rock(Color.RED));
        world.add(new Location(7, 2), new Rock(Color.YELLOW));
        world.add(new Location(4, 4), new LSRHSCritter());
        world.add(new Location(5, 8), new LSRHSCritter());
        world.add(new Location(1, 1), new Critter());
        world.show();
    }
}

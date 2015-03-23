package com.github.thatnerdjack.gridworldsandbox.firstClassProject;

import info.gridworld.actor.*;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.*;

/**
 * Created by block7 on 3/23/15.
 */
public class LSRHSRunner {
    public static final int WIDTH = 40;
    public static final int HEIGHT = 30;

    static BoundedGrid<Actor> grid = new BoundedGrid<Actor>(HEIGHT, WIDTH);
    static ActorWorld world = new ActorWorld(grid);

    public static int randomInt(int size) {
        return (int)(Math.random() * size);
    }

    public static Color randomColor() {
        return new Color(randomInt(256), randomInt(256), randomInt(256));
    }

    public static void addFlowers(int numFlowers) {
        while(numFlowers-- > 0) {
            Location loc = new Location(randomInt(HEIGHT), randomInt(WIDTH));
            Actor occupant = grid.get(loc);
            if(occupant == null) {
                world.add(loc, new Flower(randomColor()));
            }
        }
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld(grid);
        addFlowers(2);
        world.add(new Location(4, 4), new LSRHSCritter());
        world.show();
    }
}

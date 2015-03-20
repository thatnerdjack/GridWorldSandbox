package com.github.thatnerdjack.gridworldsandbox.tickTackToe;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;

/**
 * Created by block7 on 3/20/15.
 */
public class TickTackToe {

    public static void main(String args[]) {
        BoundedGrid grid = new BoundedGrid(3, 3);
        ActorWorld world = new ActorWorld(grid);
        world.show();
    }

}

package com.bacm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class LabyrintheTest {
    @Test
    void empty() {
        Boolean[][] entry = new Boolean[0][0];
        Maze maze = new Maze();
        List<Point> points = maze.echappeToi(entry);

        Assertions.assertEquals(0, points.size());
    }

    @Test
    void oneSquare() {
        Boolean[][] entry = new Boolean[][]{
                new Boolean[]{false}
        };

        Maze maze = new Maze();
        List<Point> points = maze.echappeToi(entry);
        Assertions.assertEquals(1, points.size());
    }

    @Test
    void fourSquareWithNoWall() {
        Boolean[][] entry = new Boolean[][]{
                new Boolean[]{false, false},
                new Boolean[]{false, false},
        };

        Maze maze = new Maze();
        List<Point> points = maze.echappeToi(entry);
        Assertions.assertEquals(3, points.size());
    }

    // 1|1|0|0
    // 1|1|0|1
    // 1|1|0|1
    // 0|0|0|1
    @Test
    void withSinglePath() {
        Boolean[][] entry = new Boolean[][]{
                new Boolean[]{true, true, true, false},
                new Boolean[]{true, true, true, false},
                new Boolean[]{false, false, false, false},
                new Boolean[]{false, true, true, true},
        };

        Maze maze = new Maze();
        List<Point> points = maze.echappeToi(entry);
        Assertions.assertEquals(7, points.size());
    }

    // 1|0
    // 0|1
    @Test
    void withNoSolution() {
        Boolean[][] entry = new Boolean[][]{
                new Boolean[]{true, false},
                new Boolean[]{false, true},
        };

        Maze maze = new Maze();
        List<Point> points = maze.echappeToi(entry);
        Assertions.assertEquals(0, points.size());
    }

    // 1|0|0|0|0
    // 1|0|1|1|1
    // 1|0|0|0|0
    // 1|1|1|1|0
    // 0|0|0|0|0
    @Test
    void withSnakePath() {
        Boolean[][] entry = new Boolean[][]{
                new Boolean[]{true, true, true, true, false},
                new Boolean[]{false, false, false, true, false},
                new Boolean[]{false, true, false, true, false},
                new Boolean[]{false, true, false, true, false},
                new Boolean[]{false, true, false, false, false},
        };

        Maze maze = new Maze();
        List<Point> points = maze.echappeToi(entry);
        Assertions.assertEquals(15, points.size());
    }

    // 1|1|0|0
    // 0|1|0|1
    // 0|1|0|1
    // 0|0|0|1
    @Test
    void withDeadEndFromStartAndSingleRightPath() {
        Boolean[][] entry = new Boolean[][]{
                new Boolean[]{true, false, false, false},
                new Boolean[]{true, true, true, false},
                new Boolean[]{false, false, false, false},
                new Boolean[]{false, true, true, true},
        };

        Maze maze = new Maze();
        List<Point> points = maze.echappeToi(entry);
        Assertions.assertEquals(7, points.size());
    }

    // 1|1|1|1|0
    // 1|1|1|1|0
    // 0|0|0|1|0
    // 0|1|0|1|0
    // 0|0|0|0|0
    @Test
    void withOneCyclicPath() {
        Boolean[][] entry = new Boolean[][]{
                new Boolean[]{true, true, false, false, false},
                new Boolean[]{true, true, false, true, false},
                new Boolean[]{true, true, false, false, false},
                new Boolean[]{true, true, true, true, false},
                new Boolean[]{false, false, false, false, false},
        };

        Maze maze = new Maze();
        List<Point> points = maze.echappeToi(entry);
        Assertions.assertEquals(9, points.size());
    }

    // 0|0|0|0|0
    // 0|1|0|1|1
    // 0|1|0|0|0
    // 0|1|1|1|0
    // 0|0|0|0|0
    @Test
    void shortestPath() {
        Boolean[][] entry = new Boolean[][]{
                new Boolean[]{false, false, false, false, false},
                new Boolean[]{false, true, true, true, false},
                new Boolean[]{false, false, false, true, false},
                new Boolean[]{false, true, false, true, false},
                new Boolean[]{false, true, false, false, false},
        };

        Maze maze = new Maze();
        List<Point> points = maze.echappeToi(entry);
        Assertions.assertEquals(9, points.size());
    }
}

package com.bacm;

import java.util.*;

// Based on Breadth-first search (BFS)
public class Maze {

    static class Node {
        Point p;
        LinkedList<Point> pointsFromOrigin;

        public Node(Point p, LinkedList<Point> pointsFromOrigin) {
            this.p = p;
            this.pointsFromOrigin = pointsFromOrigin;
        }
    }

    static boolean isValid(int N, int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static boolean isEnd(int N, int x, int y) {
        return x == N - 1 && y == 0;
    }

    // For all the directions, right, top, bottom and left
    private static int[][] Direction = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };

    public List<Point> echappeToi(Boolean[][] labyrinthe) {
        int N = labyrinthe.length;

        if (N == 0) {
            return new ArrayList<>();
        }

        boolean [][]visited = new boolean[N][N];

        // origin is marked as visited
        visited[0][N-1] = true;

        // create the queue for BFS
        Queue<Node> queue = new LinkedList<>();

        // origin is added to the queue
        Point origin = new Point(0, N-1);
        LinkedList<Point> pointsFromOrigin = new LinkedList<>();
        pointsFromOrigin.add(origin);
        Node n = new Node(origin, pointsFromOrigin);
        queue.add(n);

        // start the BFS
        while (!queue.isEmpty()) {
            Node current = queue.peek();
            Point point = current.p;

            // have we reached the end
            if (isEnd(N, point.x, point.y)) {
                return current.pointsFromOrigin;
            }

            queue.remove();

            // start moving
            for (int i = 0; i < 4; i++) {
                int x = point.x + Direction[i][0];
                int y = point.y + Direction[i][1];

                if (isValid(N, x, y) && !labyrinthe[x][y] && !visited[x][y]) {
                    visited[x][y] = true;
                    Point p = new Point(x, y);

                    LinkedList<Point> list = new LinkedList<>();
                    list.addAll(current.pointsFromOrigin);
                    list.add(p);

                    Node adjacent = new Node(p, list);
                    queue.add(adjacent);
                }
            }
        }

        return new ArrayList<>();
    }
}

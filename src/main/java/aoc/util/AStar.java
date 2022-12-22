package aoc.util;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.ml.distance.ManhattanDistance;

import java.util.*;

public class AStar {
    private static final ManhattanDistance MANHATTAN_DISTANCE = new ManhattanDistance();

    public static <T> List<Vector2D> findShortestPath(final Map2D<T> map, final Vector2D start, final Vector2D goal) {
        final var gScore = new HashMap<Vector2D, Integer>();
        final var fScore = new HashMap<Vector2D, Integer>();
        final var cameFrom = new HashMap<Vector2D, Vector2D>();
        final var openSet = new PriorityQueue<Vector2D>(Comparator.comparingInt(o -> fScore.getOrDefault(o, Integer.MAX_VALUE)));
        openSet.add(start);
        gScore.put(start, 0);
        fScore.put(start, h(start, goal));

        while (!openSet.isEmpty()) {
            var current = openSet.remove();
            if (current.equals(goal)) {
                return reconstructPath(cameFrom, current);
            }
            for (var neighbour : map.getNeighbours(current)) {
                var tentativeGScore = gScore.getOrDefault(current, Integer.MAX_VALUE) + map.getDistance(current, neighbour);
                if (tentativeGScore < gScore.getOrDefault(neighbour, Integer.MAX_VALUE)) {
                    cameFrom.put(neighbour, current);
                    gScore.put(neighbour, tentativeGScore);
                    fScore.put(neighbour, tentativeGScore + h(neighbour, goal));
                    if (!openSet.contains(neighbour)) {
                        openSet.add(neighbour);
                    }
                }
            }
        }
        return List.of();
    }

    private static List<Vector2D> reconstructPath(final Map<Vector2D, Vector2D> cameFrom, final Vector2D goal) {
        final var result = new ArrayList<Vector2D>();
        var current = goal;
        result.add(current);
        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            result.add(0, current);
        }
        return result;
    }

    private static int h(final Vector2D from, final Vector2D to) {
        return (int) MANHATTAN_DISTANCE.compute(from.toArray(), to.toArray());
    }

}

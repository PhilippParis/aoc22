package aoc.day12;

import aoc.util.AStar;

import java.util.List;

public class Day12 {

    public long part1(final List<String> input) {
        final var map = new ElevationMap(input);
        return AStar.findShortestPath(map, map.getStart(), map.getEnd()).size() - 1;
    }
}

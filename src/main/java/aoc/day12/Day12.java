package aoc.day12;

import aoc.util.AStar;

import java.util.List;

public class Day12 {

    public long part1(final List<String> input) {
        final var map = new ElevationMap(input);
        return AStar.findShortestPath(map, map.getStart(), map.getEnd()).size() - 1;
    }

    public long part2(final List<String> input) {
        final var map = new ElevationMap(input);
        return map.findAll(0).stream()
                .mapToLong(start -> AStar.findShortestPath(map, start, map.getEnd()).size() - 1)
                .filter(i -> i > 0)
                .min()
                .orElse(-1);
    }
}

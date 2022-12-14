package aoc.day09;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day09 {

    public static final Vector2D ORIGIN = new Vector2D(0, 0);

    public static final Vector2D RIGHT = new Vector2D(1, 0);
    public static final Vector2D LEFT = new Vector2D(-1, 0);
    public static final Vector2D DOWN = new Vector2D(0, 1);
    public static final Vector2D UP = new Vector2D(0, -1);

    public long part1(final List<String> input) {
        return exec(input, 2);
    }

    public long part2(final List<String> input) {
        return exec(input, 10);
    }

    public long exec(final List<String> input, final int count) {
        final var tailPositions = new HashSet<Vector2D>();
        final var directions = input.stream().flatMap(i -> parse(i).stream()).collect(Collectors.toList());

        final var rope = new Rope(ORIGIN, count);
        for (Vector2D dir : directions) {
            rope.moveHead(dir);
            tailPositions.add(rope.getTail());
        }
        return tailPositions.size();
    }

    private List<Vector2D> parse(String input) {
        final var split = input.split(" ");
        return IntStream.range(0, Integer.parseInt(split[1])).mapToObj(i -> parseDir(split[0])).collect(Collectors.toList());
    }

    private Vector2D parseDir(final String dir) {
        return switch (dir) {
            case "R" -> RIGHT;
            case "L" -> LEFT;
            case "U" -> UP;
            case "D" -> DOWN;
            default -> throw new IllegalStateException();
        };
    }

}

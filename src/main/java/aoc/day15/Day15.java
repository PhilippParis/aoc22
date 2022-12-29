package aoc.day15;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.ml.distance.ManhattanDistance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day15 {

    private static final ManhattanDistance DISTANCE = new ManhattanDistance();
    private static final Pattern PATTERN = Pattern.compile("x=(?<x1>-?\\d+), y=(?<y1>-?\\d+):.*x=(?<x2>-?\\d+), y=(?<y2>-?\\d+)");

    public long part1(final List<String> input, final long row) {
        final var sensors = input.stream().map(this::parse).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
        return sensors.entrySet().stream()
                .flatMap(i -> getCoveredPositions(i.getKey(), i.getValue(), row).stream().filter(k -> !sensors.containsValue(k)))
                .distinct().count();
    }

    private long getDistance(Vector2D from, Vector2D to) {
        return (long) DISTANCE.compute(from.toArray(), to.toArray());
    }

    private Set<Vector2D> getCoveredPositions(final Vector2D sensor, final Vector2D beacon, final long row) {
        final var result = new HashSet<Vector2D>();
        final var distance = getDistance(sensor, beacon);
        for (var x = sensor.getX() - distance; x < sensor.getX() + distance; x++) {
            final var pos = new Vector2D(x, row);
            if (getDistance(sensor, pos) <= distance) {
                result.add(pos);
            }
        }
        return result;
    }

    private Pair<Vector2D, Vector2D> parse(final String input) {
        final var matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            return Pair.of( new Vector2D(Long.parseLong(matcher.group("x1")), Long.parseLong(matcher.group("y1"))),
                            new Vector2D(Long.parseLong(matcher.group("x2")), Long.parseLong(matcher.group("y2"))));
        }
        throw new IllegalArgumentException();
    }

}

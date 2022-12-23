package aoc.day14;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day14 {

    public long part1(final List<String> input) {
        final var lines = input.stream().flatMap(i -> parse(i).stream()).collect(Collectors.toList());
        final var map = new CaveMap(1000, 1000);
        lines.forEach(i -> map.drawStraightLine(i.getLeft(), i.getRight(), CaveMap.ROCK));
        while (map.step()) {
            // do nothing
        }
        return map.count(CaveMap.SAND);
    }

    public long part2(final List<String> input) {
        final var lines = input.stream().flatMap(i -> parse(i).stream()).collect(Collectors.toList());
        final var height = lines.stream().mapToInt(i -> (int) Math.max(i.getLeft().getY(), i.getRight().getY())).max().orElse(-1) + 3;
        final var map = new CaveMap(1000, height);
        lines.forEach(i -> map.drawStraightLine(i.getLeft(), i.getRight(), CaveMap.ROCK));
        map.drawStraightLine(new Vector2D(0, height - 1), new Vector2D(999, height - 1), CaveMap.ROCK);
        while (map.step()) {
            // do nothing
        }
        return map.count(CaveMap.SAND);
    }

    private List<Pair<Vector2D, Vector2D>> parse(final String input) {
        final var result = new ArrayList<Pair<Vector2D, Vector2D>>();
        final var split = input.split(" -> ");
        var prev = toVector2D(split[0]);
        for (var i = 1; i < split.length; i++) {
            final var current = toVector2D(split[i]);
            result.add(Pair.of(prev, current));
            prev = current;
        }
        return result;
    }

    private Vector2D toVector2D(final String value) {
        final var split = value.split(",");
        return new Vector2D(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
    }
}

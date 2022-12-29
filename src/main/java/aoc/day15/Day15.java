package aoc.day15;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.ml.distance.ManhattanDistance;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Day15 {

    private static final ManhattanDistance DISTANCE = new ManhattanDistance();
    private static final Pattern PATTERN = Pattern.compile("x=(?<x1>-?\\d+), y=(?<y1>-?\\d+):.*x=(?<x2>-?\\d+), y=(?<y2>-?\\d+)");

    public long part1(final List<String> input, final long row) {
        final var sensors = input.stream().map(this::parse).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
        final var sensorCount = sensors.values().stream().filter(i -> i.getY() == row).distinct().count();
        return getCoveredRanges(sensors, row).asRanges().stream().mapToLong(i -> i.upperEndpoint() - i.lowerEndpoint() + 1).sum() - sensorCount;
    }

    public long part2(final List<String> input, final long min, final long max) {
        final var range = Range.closed(min, max);
        final var sensors = input.stream().map(this::parse).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
        for (var y = min; y <= max; y++) {
            final var notCovered = getCoveredRanges(sensors, y).complement().subRangeSet(range);
            if (!notCovered.isEmpty()) {
                return LongStream.rangeClosed(min, max).filter(notCovered::contains).findFirst().orElse(-1) * 4000000 + y;
            }
        }
        return -1;
    }

    private long getDistance(Vector2D from, Vector2D to) {
        return (long) DISTANCE.compute(from.toArray(), to.toArray());
    }

    private RangeSet<Long> getCoveredRanges(final Map<Vector2D, Vector2D> sensors, final long row) {
        return TreeRangeSet.create(sensors.entrySet().stream()
                .map(i -> getCoveredRange(i.getKey(), i.getValue(), row))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet()));
    }

    private Optional<Range<Long>> getCoveredRange(final Vector2D sensor, final Vector2D beacon, final long row) {
        final var xDist = getDistance(sensor, beacon) - Math.abs(row - sensor.getY());
        if (xDist <= 0) {
            return Optional.empty();
        }
        return Optional.of(Range.closed((long) (sensor.getX() - xDist), (long) (sensor.getX() + xDist)));
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

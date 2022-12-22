package aoc.day12;

import aoc.util.Map2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;
import java.util.stream.Collectors;

public class ElevationMap extends Map2D<Integer> {

    private final Vector2D start;
    private final Vector2D end;

    public ElevationMap(List<String> input) {
        super(input, i -> i.chars().map(j -> j - (int)'a').boxed().collect(Collectors.toList()));
        start = find('S' - 'a').orElseThrow(() -> new IllegalArgumentException("start not found"));
        end = find('E' - 'a').orElseThrow(() -> new IllegalArgumentException("end not found"));
        set(start, 0);
        set(end, 25);
    }

    @Override
    public List<Vector2D> getNeighbours(final Vector2D current) {
        return DIRECTIONS.stream().map(current::add).filter(i -> isReachable(current, i)).collect(Collectors.toList());
    }

    private boolean isReachable(final Vector2D from, final Vector2D to) {
        return isInBounds(to) && get(from) >= get(to) - 1;
    }

    @Override
    protected Class<Integer> getTypeClass() {
        return Integer.class;
    }

    public Vector2D getStart() {
        return start;
    }

    public Vector2D getEnd() {
        return end;
    }
}

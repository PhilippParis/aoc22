package aoc.day14;

import aoc.util.Map2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class CaveMap extends Map2D<Character> {

    public static final char AIR = '.';
    public static final char ROCK = '#';
    public static final char SAND = 'o';
    public static final Vector2D SOURCE = new Vector2D(500, 0);

    public CaveMap(int width, int height) {
        super(width, height);
        setAll(AIR);
    }

    public boolean step() {
        var current = SOURCE;
        var prev = current;
        do {
            if (!isInBounds(current.add(Map2D.DOWN))) {
                return false;
            }
            prev = current;
            current = move(current);
        } while (!current.equals(prev));
        set(current, SAND);
        return true;
    }

    public Vector2D move(final Vector2D pos) {
        var below = pos.add(Map2D.DOWN);
        if (!isBlocked(below)) {
            return below;
        }
        var left = below.add(LEFT);
        if (!isBlocked(left)) {
            return left;
        }
        var right = below.add(RIGHT);
        if (!isBlocked(right)) {
            return right;
        }
        return pos;
    }

    private boolean isBlocked(final Vector2D pos) {
        final var value = get(pos);
        return value == ROCK || value == SAND;
    }

    @Override
    protected Class<Character> getTypeClass() {
        return Character.class;
    }
}

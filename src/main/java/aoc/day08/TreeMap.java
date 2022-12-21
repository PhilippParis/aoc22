package aoc.day08;

import aoc.util.Map2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeMap extends Map2D<Integer> {

    public static final Vector2D RIGHT = new Vector2D(1, 0);
    public static final Vector2D LEFT = new Vector2D(-1, 0);
    public static final Vector2D DOWN = new Vector2D(0, 1);
    public static final Vector2D UP = new Vector2D(0, -1);

    public TreeMap(List<String> input) {
        super(input, i -> i.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList()));
    }

    public long getVisibleCount() {
        return positions.stream().filter(this::isVisible).count();
    }

    public long getHighestScenicScore() {
        return positions.stream().mapToLong(this::getScenicScore).max().orElse(-1);
    }

    private long getScenicScore(final Vector2D pos) {
        return getViewingDistance(pos, RIGHT) *
                getViewingDistance(pos, LEFT) *
                getViewingDistance(pos, DOWN) *
                getViewingDistance(pos, UP);
    }

    private long getViewingDistance(final Vector2D pos, final Vector2D dir) {
        var treeHeight = get(pos);
        for (int i = 1; i <= Math.max(width, height); i++) {
            final var otherTree = dir.scalarMultiply(i).add(pos);
            if (!isInBounds(otherTree)) {
                return i - 1;
            }
            if (get(otherTree) >= treeHeight) {
                return i;
            }
        }
        return 1;
    }

    private boolean isVisible(final Vector2D pos) {
        var x = (int) pos.getX();
        var y = (int) pos.getY();
        var treeHeight = get(x, y);
        if (IntStream.range(0, x).map(i -> get(i, y)).max().orElse(-1) < treeHeight) {
            return true;
        }
        if (IntStream.range(x + 1, width).map(i -> get(i, y)).max().orElse(-1) < treeHeight) {
            return true;
        }
        if (IntStream.range(0, y).map(i -> get(x, i)).max().orElse(-1) < treeHeight) {
            return true;
        }
        if (IntStream.range(y + 1, height).map(i -> get(x, i)).max().orElse(-1) < treeHeight) {
            return true;
        }
        return false;
    }

    @Override
    protected Class<Integer> getTypeClass() {
        return Integer.class;
    }

}

package aoc.day08;

import aoc.util.Map2D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeMap extends Map2D<Integer> {

    public TreeMap(List<String> input) {
        super(input, i -> i.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList()));
    }

    public long getVisibleCount() {
        return positions.stream().filter(this::isVisible).count();
    }

    private boolean isVisible(Vector2D pos) {
        int x = (int) pos.getX();
        int y = (int) pos.getY();
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

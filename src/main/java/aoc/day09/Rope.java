package aoc.day09;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Rope {

    private final List<Vector2D> knots = new ArrayList<>();

    public Rope(final Vector2D start, final int count) {
        IntStream.range(0, count).forEach(i -> knots.add(new Vector2D(start.getX(), start.getY())));
    }

    public void moveHead(final Vector2D dir) {
        knots.set(0, getHead().add(dir));
        for (int i = 1; i < knots.size(); i++) {
            knots.set(i, move(knots.get(i - 1), knots.get(i)));
        }
    }

    private Vector2D move(final Vector2D head, final Vector2D knot) {
        var x = knot.getX();
        var y = knot.getY();
        if (knot.distanceSq(head) > 2) {
            if (head.getX() > knot.getX()) x++;
            if (head.getX() < knot.getX()) x--;
            if (head.getY() > knot.getY()) y++;
            if (head.getY() < knot.getY()) y--;
        }
        return new Vector2D(x, y);
    }

    public Vector2D getHead() {
        return knots.get(0);
    }

    public Vector2D getTail() {
        return knots.get(knots.size() - 1);
    }
}

package aoc.day09;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Rope {

    private final Vector2D head;
    private final Vector2D tail;

    public Rope(final Vector2D head, final Vector2D tail) {
        this.head = head;
        this.tail = tail;
    }

    public Rope move(final Vector2D dir) {
        final var newHead = head.add(dir);
        final var newTail = moveTail(newHead);
        return new Rope(newHead, newTail);
    }

    private Vector2D moveTail(final Vector2D newHead) {
        var x = tail.getX();
        var y = tail.getY();
        if (tail.distanceSq(newHead) > 2) {
            if (newHead.getX() > tail.getX()) x++;
            if (newHead.getX() < tail.getX()) x--;
            if (newHead.getY() > tail.getY()) y++;
            if (newHead.getY() < tail.getY()) y--;
        }
        return new Vector2D(x, y);
    }

    public Vector2D getTail() {
        return tail;
    }
}

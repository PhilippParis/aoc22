package aoc.day04;

public class Assignment {

    private final int min;
    private final int max;

    public static Assignment parse(final String input) {
        final var split = input.split("-");
        return new Assignment(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    public Assignment(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(Assignment other) {
        return min <= other.min && max >= other.max;
    }

    public boolean overlaps(Assignment other) {
        return min <= other.max && max >= other.min;
    }

}

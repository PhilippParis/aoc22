package aoc.day04;

public class Assignment {

    private final int minSection;
    private final int maxSection;

    public static Assignment parse(final String input) {
        final var split = input.split("-");
        return new Assignment(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    public Assignment(int minSection, int maxSection) {
        this.minSection = minSection;
        this.maxSection = maxSection;
    }

    public boolean contains(Assignment other) {
        return this.minSection <= other.minSection && this.maxSection >= other.maxSection;
    }

}

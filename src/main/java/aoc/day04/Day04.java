package aoc.day04;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class Day04 {

    public long part1(final List<String> input) {
        return input.stream().map(this::parse)
                .filter(i -> i.getRight().contains(i.getLeft()) || i.getLeft().contains(i.getRight()))
                .count();
    }

    public long part2(final List<String> input) {
        return input.stream().map(this::parse).filter(i -> i.getLeft().overlaps(i.getRight())).count();
    }

    public Pair<Assignment, Assignment> parse(final String input) {
        final var assignments = input.split(",");
        return Pair.of(Assignment.parse(assignments[0]), Assignment.parse(assignments[1]));
    }

}

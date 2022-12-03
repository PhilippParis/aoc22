package aoc.day03;

import org.apache.commons.collections4.ListUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day03 {

    private final Set<Integer> TYPES = IntStream.rangeClosed(1, 52).boxed().collect(Collectors.toSet());

    public long part1(final List<String> input) {
        return input.stream().map(this::split).mapToLong(this::getCommonType).sum();
    }

    public long part2(final List<String> input) {
        final var bags = input.stream().map(this::toItemTypes).collect(Collectors.toList());
        return ListUtils.partition(bags, 3).stream().mapToLong(this::getCommonType).sum();
    }

    private Integer getCommonType(final List<Set<Integer>> container) {
        return TYPES.stream().filter(i -> container.stream().allMatch(j -> j.contains(i))).findFirst().orElse(-1);
    }

    private Set<Integer> toItemTypes(final String input) {
        return input.chars().mapToObj(this::getType).collect(Collectors.toSet());
    }

    private List<Set<Integer>> split(final String input) {
        final var mid = input.length() / 2;
        return List.of(toItemTypes(input.substring(0, mid)), toItemTypes(input.substring(mid)));
    }

    private int getType(final int value) {
        if (value <= 90) {
            return value - 65 + 27;
        }
        return value - 97 + 1;
    }

}

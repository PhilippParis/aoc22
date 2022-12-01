package aoc.day01;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day01 {

    public long part1(final List<String> input) {
        return getCalories(input).stream().mapToInt(i -> i).max().orElse(0);
    }

    public long part2(final List<String> input) {
        return getCalories(input).stream().sorted(Collections.reverseOrder()).limit(3).mapToLong(i -> i).sum();
    }

    private List<Integer> getCalories(final List<String> input) {
        return split(input).stream().map(i -> i.stream().mapToInt(Integer::parseInt).sum()).collect(Collectors.toList());
    }

    private List<List<String>> split(final List<String> input) {
        final var result = new ArrayList<List<String>>();
        var current = new ArrayList<String>();
        for (var value : input) {
            if (value.equals(StringUtils.EMPTY)) {
                result.add(current);
                current = new ArrayList<>();
            } else {
                current.add(value);
            }
        }
        result.add(current);
        return result;
    }

}

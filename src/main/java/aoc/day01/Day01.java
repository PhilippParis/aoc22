package aoc.day01;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Day01 {

    public long part1(final List<String> input) {
        return split(input).stream().mapToLong(i -> i.stream().mapToInt(Integer::parseInt).sum()).max().orElse(0);
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
        return result;
    }

}

package aoc.day01;

import aoc.util.Util;
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
        return Util.split(input, StringUtils.EMPTY).stream().map(i -> i.stream().mapToInt(Integer::parseInt).sum()).collect(Collectors.toList());
    }

}

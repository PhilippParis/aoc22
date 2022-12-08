package aoc.day08;

import java.util.List;

public class Day08 {

    public long part1(final List<String> input) {
        return new TreeMap(input).getVisibleCount();
    }

}

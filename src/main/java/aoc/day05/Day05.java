package aoc.day05;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Day05 {

    public String part1(final List<String> input) {
        final var split = split(input, input.indexOf(StringUtils.EMPTY));
        final var stacks = parseStacks(split.getLeft());
        split.getRight().stream().map(Command::parse).forEach(i -> i.apply(stacks));
        return stacks.stream().map(Stack::peek).map(String::valueOf).collect(Collectors.joining());
    }

    private List<Stack<Character>> parseStacks(final List<String> input) {
        final var stacks = new TreeMap<Integer, Stack<Character>>();
        for (var line : input) {
            for (int i = 1; i < line.length(); i += 4) {
                if (line.charAt(i) != ' ') {
                    stacks.computeIfAbsent(i, j -> new Stack<>()).add(0, line.charAt(i));
                }
            }
        }
        return new ArrayList<>(stacks.values());
    }

    private Pair<List<String>, List<String>> split(final List<String> input, int index) {
        return Pair.of(input.subList(0, index), input.subList(index + 1, input.size()));
    }
}

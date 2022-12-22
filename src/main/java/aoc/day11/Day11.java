package aoc.day11;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day11 {

    public long part1(final List<Monkey> input) {
        final var monkeys = input.stream().collect(Collectors.toMap(Monkey::getId, Function.identity()));
        for (var i = 0; i < 20; i++) {
            for (var monkey : monkeys.values()) {
                monkey.exec(monkeys);
            }
        }
        return monkeys.values().stream().map(Monkey::getInspectCounter).sorted(Comparator.reverseOrder()).limit(2)
                .mapToLong(i -> i).reduce(1, (i, j) -> i * j);
    }
}

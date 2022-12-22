package aoc.day11;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day11 {

    public long part1(final List<Monkey> input) {
        return exec(input, i -> i / 3, 20);
    }

    public long part2(final List<Monkey> input) {
        final var commonMultiple = input.stream().mapToLong(Monkey::getDivisor).reduce(1, (k, j) -> k * j);
        return exec(input, i -> i % commonMultiple, 10000);
    }

    public long exec(final List<Monkey> input, final Function<Long, Long> reliefModifier, final int rounds) {
        final var monkeys = input.stream().collect(Collectors.toMap(Monkey::getId, Function.identity()));
        for (var i = 0; i < rounds; i++) {
            for (var monkey : monkeys.values()) {
                monkey.exec(monkeys, reliefModifier);
            }
        }
        return monkeys.values().stream().map(Monkey::getInspectCounter).sorted(Comparator.reverseOrder()).limit(2)
                .mapToLong(i -> i).reduce(1, (i, j) -> i * j);
    }
}

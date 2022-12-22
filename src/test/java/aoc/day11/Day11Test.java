package aoc.day11;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {

    private final Day11 puzzle = new Day11();

    @Test
    void example() {
        var monkeys = List.of(
            new Monkey(0, List.of(79, 98), i -> i * 19, i -> i % 23 == 0, 2, 3),
            new Monkey(1, List.of(54, 65, 75, 74), i -> i + 6, i -> i % 19 == 0, 2, 0),
            new Monkey(2, List.of(79, 60, 97), i -> i * i, i -> i % 13 == 0, 1, 3),
            new Monkey(3, List.of(74), i -> i + 3, i -> i % 17 == 0, 0, 1)
        );
        assertEquals(10605, puzzle.part1(monkeys));
    }

    @Test
    void input() {
        var monkeys = List.of(
                new Monkey(0, List.of(98, 89, 52), i -> i * 2, i -> i % 5 == 0, 6, 1),
                new Monkey(1, List.of(57, 95, 80, 92, 57, 78), i -> i * 13, i -> i % 2 == 0, 2, 6),
                new Monkey(2, List.of(82, 74, 97, 75, 51, 92, 83), i -> i + 5, i -> i % 19 == 0, 7, 5),
                new Monkey(3, List.of(97, 88, 51, 68, 76), i -> i + 6, i -> i % 7 == 0, 0, 4),
                new Monkey(4, List.of(63), i -> i + 1, i -> i % 17 == 0, 0, 1),
                new Monkey(5, List.of(94, 91, 51, 63), i -> i + 4, i -> i % 13 == 0, 4, 3),
                new Monkey(6, List.of(61, 54, 94, 71, 74, 68, 98, 83), i -> i + 2, i -> i % 3 == 0, 2, 7),
                new Monkey(7, List.of(90, 56), i -> i * i, i -> i % 11 == 0, 3, 5)
        );
        assertEquals(113220, puzzle.part1(monkeys));
    }

}
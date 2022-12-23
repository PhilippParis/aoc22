package aoc.day14;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Test {

    private final Day14 puzzle = new Day14();

    @Test
    void example() {
        List<String> input = Input.getExample(14);
        assertEquals(24, puzzle.part1(input));
        assertEquals(93, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(14);
        assertEquals(979, puzzle.part1(input));
        assertEquals(29044, puzzle.part2(input));
    }
}
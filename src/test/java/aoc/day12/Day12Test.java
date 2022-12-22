package aoc.day12;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {

    private final Day12 puzzle = new Day12();

    @Test
    void example() {
        List<String> input = Input.getExample(12);
        assertEquals(31, puzzle.part1(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(12);
        assertEquals(425, puzzle.part1(input));
    }
}
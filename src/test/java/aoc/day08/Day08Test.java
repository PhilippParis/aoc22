package aoc.day08;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day08Test {

    private final Day08 puzzle = new Day08();

    @Test
    void example() {
        List<String> input = Input.getExample(8);
        assertEquals(21, puzzle.part1(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(8);
        assertEquals(1818, puzzle.part1(input));
    }
}
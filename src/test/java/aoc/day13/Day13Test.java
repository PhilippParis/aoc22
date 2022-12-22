package aoc.day13;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Test {

    private final Day13 puzzle = new Day13();

    @Test
    void example() {
        List<String> input = Input.getExample(13);
        assertEquals(13, puzzle.part1(input));
        assertEquals(140, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(13);
        assertEquals(6076, puzzle.part1(input));
        assertEquals(24805, puzzle.part2(input));
    }
}
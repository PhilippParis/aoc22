package aoc.day04;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {

    private final Day04 puzzle = new Day04();

    @Test
    void example() {
        List<String> input = Input.getExample(4);
        assertEquals(2, puzzle.part1(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(4);
        assertEquals(490, puzzle.part1(input));
    }
}
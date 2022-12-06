package aoc.day06;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {

    private final Day06 puzzle = new Day06();

    @Test
    void example() {
        String input = Input.getExample(6).get(0);
        assertEquals(11, puzzle.part1(input));
    }

    @Test
    void input() {
        String input = Input.getInput(6).get(0);
        assertEquals(1912, puzzle.part1(input));
    }

}
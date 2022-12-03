package aoc.day03;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    private final Day03 puzzle = new Day03();

    @Test
    void example() {
        List<String> input = Input.getExample(3);
        assertEquals(157, puzzle.part1(input));
        assertEquals(70, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(3);
        assertEquals(7795, puzzle.part1(input));
        assertEquals(2703, puzzle.part2(input));
    }

}
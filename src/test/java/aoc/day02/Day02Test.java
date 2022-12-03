package aoc.day02;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {

    private final Day02 puzzle = new Day02();

    @Test
    void example() {
        List<String> input = Input.getExample(2);
        assertEquals(15, puzzle.part1(input));
        assertEquals(12, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(2);
        assertEquals(14264, puzzle.part1(input));
        assertEquals(12382, puzzle.part2(input));
    }
}
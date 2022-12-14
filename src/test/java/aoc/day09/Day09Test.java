package aoc.day09;

import aoc.day08.Day08;
import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day09Test {

    private final Day09 puzzle = new Day09();

    @Test
    void example() {
        List<String> input = Input.getExample("09a");
        assertEquals(13, puzzle.part1(input));

        input = Input.getExample("09b");
        assertEquals(36, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(9);
        assertEquals(6367, puzzle.part1(input));
        assertEquals(2536, puzzle.part2(input));
    }
}
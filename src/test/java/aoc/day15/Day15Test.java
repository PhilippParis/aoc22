package aoc.day15;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day15Test {

    private final Day15 puzzle = new Day15();

    @Test
    void example() {
        List<String> input = Input.getExample(15);
        assertEquals(26, puzzle.part1(input, 10));
        assertEquals(56000011, puzzle.part2(input, 0, 20));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(15);
        assertEquals(5299855, puzzle.part1(input, 2000000));
        assertEquals(13615843289729L, puzzle.part2(input, 0, 4000000));
    }
}
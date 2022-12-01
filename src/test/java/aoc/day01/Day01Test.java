package aoc.day01;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    private final Day01 puzzle = new Day01();

    @Test
    void example() {
        List<String> input = Input.getExample(1);
        assertEquals(24000, puzzle.part1(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(1);
        assertEquals(68802, puzzle.part1(input));
    }

}
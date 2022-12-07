package aoc.day07;

import aoc.day06.Day06;
import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day07Test {

    private final Day07 puzzle = new Day07();

    @Test
    void example() {
        List<String> input = Input.getExample(7);
        assertEquals(95437, puzzle.part1(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(7);
        assertEquals(1886043, puzzle.part1(input));
    }

}
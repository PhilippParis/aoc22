package aoc.day05;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {

    private final Day05 puzzle = new Day05();

    @Test
    void example() {
        List<String> input = Input.getExample(5);
        assertEquals("CMZ", puzzle.part1(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(5);
        assertEquals("TBVFVDZPN", puzzle.part1(input));
    }

}
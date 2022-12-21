package aoc.day10;

import aoc.util.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {

    private final Day10 puzzle = new Day10();

    @Test
    void example() {
        List<String> input = Input.getExample(10);
        assertEquals(13140, puzzle.part1(input));
        assertEquals("""
                ##..##..##..##..##..##..##..##..##..##..
                ###...###...###...###...###...###...###.
                ####....####....####....####....####....
                #####.....#####.....#####.....#####.....
                ######......######......######......####
                #######.......#######.......#######.....
                """, puzzle.part2(input));
    }

    @Test
    void input() {
        List<String> input = Input.getInput(10);
        assertEquals(14620, puzzle.part1(input));
        assertEquals("""
                ###....##.####.###..#..#.###..####.#..#.
                #..#....#.#....#..#.#..#.#..#.#....#..#.
                ###.....#.###..#..#.####.#..#.###..#..#.
                #..#....#.#....###..#..#.###..#....#..#.
                #..#.#..#.#....#.#..#..#.#.#..#....#..#.
                ###...##..#....#..#.#..#.#..#.#.....##..
                """, puzzle.part2(input));
    }

}
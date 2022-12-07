package aoc.day07;

import java.util.List;

public class Day07 {

    private Terminal terminal = new Terminal();

    public long part1(final List<String> input) {
        input.forEach(terminal::execute);
        return terminal.root.getDirs().stream().mapToLong(Dir::getSize).filter(i -> i <= 100000).sum();
    }

}

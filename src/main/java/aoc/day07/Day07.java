package aoc.day07;

import java.util.List;

public class Day07 {

    private final static long TOTAL_DISK_SPACE = 70000000;
    private final static long REQUIRED_SPACE = 30000000;

    public long part1(final List<String> input) {
        var terminal = new Terminal();
        input.forEach(terminal::execute);
        return terminal.root.getDirs().stream().mapToLong(Dir::getSize).filter(i -> i <= 100000).sum();
    }

    public long part2(final List<String> input) {
        var terminal = new Terminal();
        input.forEach(terminal::execute);
        var missingSpace = REQUIRED_SPACE - (TOTAL_DISK_SPACE - terminal.root.getSize());
        return terminal.root.getDirs().stream().mapToLong(Dir::getSize).filter(i -> i >= missingSpace).min().orElse(0);
    }

}

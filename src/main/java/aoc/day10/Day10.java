package aoc.day10;

import java.util.List;
import java.util.stream.Collectors;

public class Day10 {

    private final CPU cpu = new CPU();

    public long part1(final List<String> input) {
        input.stream().map(Instruction::parse).forEach(cpu::exec);
        return getSignalStrengthSum();
    }

    private long getSignalStrengthSum() {
        final var valuePerCycle = cpu.getValuePerCycle();
        long result = 0;
        for (int i = 20; i < valuePerCycle.size(); i += 40) {
            result += valuePerCycle.get(i - 1) * i;
        }
        return result;
    }

}

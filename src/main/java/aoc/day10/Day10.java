package aoc.day10;

import aoc.util.Util;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Day10 {

    public long part1(final List<String> input) {
        final CPU cpu = new CPU();
        input.stream().map(Instruction::parse).forEach(cpu::exec);
        return getSignalStrengthSum(cpu);
    }

    public String part2(final List<String> input) {
        final CPU cpu = new CPU();
        input.stream().map(Instruction::parse).forEach(cpu::exec);
        return drawImage(cpu);
    }

    private String drawImage(final CPU cpu) {
        final var crt = StringUtils.repeat(".", 40 * 6).toCharArray();
        final var valuePerCycle = cpu.getValuePerCycle();
        for (int i = 0; i < valuePerCycle.size(); i++) {
            var spritePos = valuePerCycle.get(i);
            var crtPos = i % 40;
            if (crtPos >= spritePos - 1 && crtPos <= spritePos + 1) {
                crt[i] = '#';
            }
        }
        return Util.wrap(new String(crt), 40);
    }

    private long getSignalStrengthSum(final CPU cpu) {
        final var valuePerCycle = cpu.getValuePerCycle();
        long result = 0;
        for (int i = 20; i < valuePerCycle.size(); i += 40) {
            result += valuePerCycle.get(i - 1) * i;
        }
        return result;
    }

}

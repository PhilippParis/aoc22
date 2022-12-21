package aoc.day10;

import java.util.ArrayList;
import java.util.List;

public class CPU {

    private final Memory memory = new Memory();
    private final List<Integer> valuePerCycle = new ArrayList<>();

    public void exec(final Instruction instruction) {
        for (int i = 0; i < instruction.getCycles(); i++) {
            valuePerCycle.add(memory.getX());
        }
        instruction.exec(memory);
    }

    public List<Integer> getValuePerCycle() {
        return valuePerCycle;
    }
}

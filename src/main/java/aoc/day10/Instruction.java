package aoc.day10;

public abstract class Instruction {

    private final int cycles;

    public Instruction(int cycles) {
        this.cycles = cycles;
    }

    public static Instruction parse(final String input) {
        final var split = input.split(" ");
        return switch (split[0]) {
            case "noop" -> new Noop();
            case "addx" -> new AddX(Integer.parseInt(split[1]));
            default -> throw new IllegalArgumentException(split[0]);
        };
    }

    public int getCycles() {
        return cycles;
    }

    public abstract void exec(final Memory memory);

    private static class AddX extends Instruction {
        private final int argument;

        public AddX(int argument) {
            super(2);
            this.argument = argument;
        }

        @Override
        public void exec(final Memory memory) {
            memory.setX(memory.getX() + argument);
        }
    }

    private static class Noop extends Instruction {
        public Noop() {
            super(1);
        }

        @Override
        public void exec(Memory memory) {
            // do nothing
        }
    }

}

package aoc.day11;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Monkey {

    private final int id;
    private final List<Long> items;
    private final Function<Long, Long> operation;
    private final int divisor;
    private final int targetSuccess;
    private final int targetFailure;

    private long inspectCounter = 0;

    public Monkey(int id, List<Integer> items, Function<Long, Long> operation, int divisor,
                   int targetSuccess, int targetFailure) {
        this.id = id;
        this.items = items.stream().map(i -> (long) i).collect(Collectors.toList());
        this.operation = operation;
        this.divisor = divisor;
        this.targetSuccess = targetSuccess;
        this.targetFailure = targetFailure;
    }

    public void exec(final Map<Integer, Monkey> monkeys, Function<Long, Long> reliefModifier) {
        for (var item : items) {
            final var value = reliefModifier.apply(operation.apply(item));
            if (value % divisor == 0) {
                monkeys.get(targetSuccess).add(value);
            } else {
                monkeys.get(targetFailure).add(value);
            }
        }
        inspectCounter += items.size();
        items.clear();
    }

    public void add(final long item) {
        items.add(item);
    }

    public int getId() {
        return id;
    }

    public long getInspectCounter() {
        return inspectCounter;
    }

    public int getDivisor() {
        return divisor;
    }
}

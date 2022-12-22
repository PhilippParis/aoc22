package aoc.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Monkey {

    private final int id;
    private final List<Integer> items;
    private final Function<Integer, Integer> operation;
    private final Predicate<Integer> test;
    private final int targetSuccess;
    private final int targetFailure;

    private int inspectCounter = 0;

    public Monkey(int id, List<Integer> items, Function<Integer, Integer> operation, Predicate<Integer> test,
                   int targetSuccess, int targetFailure) {
        this.id = id;
        this.items = new ArrayList<>(items);
        this.operation = operation;
        this.test = test;
        this.targetSuccess = targetSuccess;
        this.targetFailure = targetFailure;
    }

    public void exec(final Map<Integer, Monkey> monkeys) {
        for (var item : items) {
            inspectCounter++;
            var newItem = operation.apply(item) / 3;
            if (test.test(newItem)) {
                monkeys.get(targetSuccess).add(newItem);
            } else {
                monkeys.get(targetFailure).add(newItem);
            }
        }
        items.clear();
    }

    public void add(final Integer item) {
        items.add(item);
    }

    public int getId() {
        return id;
    }

    public int getInspectCounter() {
        return inspectCounter;
    }
}

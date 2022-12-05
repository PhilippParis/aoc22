package aoc.day05;

import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Command {

    private final static Pattern PATTERN = Pattern.compile("move (?<count>[0-9]+) from (?<from>[0-9]+) to (?<to>[0-9]+)");

    private final int from;
    private final int to;
    private final int count;

    public static Command parse(final String input) {
        final var matcher = PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalStateException();
        }
        return new Command(
                Integer.parseInt(matcher.group("from")) - 1,
                Integer.parseInt(matcher.group("to")) - 1,
                Integer.parseInt(matcher.group("count")));
    }

    public Command(int from, int to, int count) {
        this.from = from;
        this.to = to;
        this.count = count;
    }

    public void apply(List<Stack<Character>> stacks) {
        IntStream.range(0, count).forEach(i -> stacks.get(to).push(stacks.get(from).pop()));
    }

}

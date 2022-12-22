package aoc.day13;

import aoc.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day13 {

    public long part1(final List<String> input) {
        final var pairs = Util.split(input, StringUtils.EMPTY).stream().map(this::parse).collect(Collectors.toList());
        var result = 0;
        for (var i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).getLeft().compareTo(pairs.get(i).getRight()) < 0) {
                result += i + 1;
            }
        }
        return result;
    }

    public long part2(final List<String> input) {
        input.add("[[2]]");
        input.add("[[6]]");
        final var packets = input.stream().filter(i -> !i.isBlank()).map(this::parse).sorted().collect(Collectors.toList());
        var result = 1;
        for (var i = 0; i < packets.size(); i++) {
            if (packets.get(i).toString().equals("[[[2]]]") || packets.get(i).toString().equals("[[[6]]]")) {
                result *= i + 1;
            }
        }
        return result;
    }

    private Pair<Packet, Packet> parse(final List<String> input) {
        assert input.size() == 2;
        return Pair.of(parse(input.get(0)), parse(input.get(1)));
    }

    private Packet parse(final String input) {
        final var stack = new Stack<Packet>();
        Packet current = new Packet();
        for (var c : input.split("((?<=])|(?=]))|((?<=,)|(?=,))|((?<=\\[)|(?=\\[))")) {
            switch (c) {
                case "[" -> {stack.push(current); current = current.add(new Packet()); }
                case "]" -> current = stack.pop();
                case "," -> {}
                default -> current.add(new Packet(Integer.parseInt(c)));
            }
        }
        return current;
    }


}

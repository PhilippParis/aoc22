package aoc.day02;

import java.util.List;
import java.util.Map;

public class Day02 {

    public static final Map<Character, Shape> MAPPING_OPPONENT = Map.of('A', Shape.ROCK, 'B', Shape.PAPER, 'C', Shape.SCISSORS);

    public long part1(final List<String> input) {
        var mapping = Map.of('X', Shape.ROCK,'Y', Shape.PAPER,'Z', Shape.SCISSORS);
        return input.stream().mapToLong(i -> mapping.get(i.charAt(2)).play(MAPPING_OPPONENT.get(i.charAt(0)))).sum();
    }

    public long part2(final List<String> input) {
        var result = 0;
        for (var line : input) {
            var opponent = MAPPING_OPPONENT.get(line.charAt(0));
            var player = switch (line.charAt(2)) {
                case 'X' -> opponent.getLosingPick();
                case 'Y' -> opponent;
                case 'Z' -> opponent.getWinningPick();
                default -> throw new IllegalStateException("Unexpected value: " + line.charAt(2));
            };
            result += player.play(opponent);
        }
        return result;
    }

}

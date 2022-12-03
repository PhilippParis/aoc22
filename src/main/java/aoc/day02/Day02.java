package aoc.day02;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;

public class Day02 {

    private final Map<Character, Shape> MAPPING_OPPONENT =
            Map.of('A', Shape.ROCK,
                    'B', Shape.PAPER,
                    'C', Shape.SCISSORS);


    private final Map<Character, Shape> MAPPING_PLAYER =
            Map.of('X', Shape.ROCK,
                    'Y', Shape.PAPER,
                    'Z', Shape.SCISSORS);


    public long part1(final List<String> input) {
        return input.stream().map(this::parse).mapToLong(i -> getScore(i.getLeft(), i.getRight())).sum();
    }

    private Pair<Shape, Shape> parse(String input) {
        return Pair.of(MAPPING_PLAYER.get(input.charAt(2)), MAPPING_OPPONENT.get(input.charAt(0)));
    }

    private long getScore(final Shape player, final Shape opponent) {
        if (Shape.isDraw(player, opponent)) {
            return player.getScore() + 3;
        }
        if (Shape.isWin(player, opponent)) {
            return player.getScore() + 6;
        }
        return player.getScore();
    }

}

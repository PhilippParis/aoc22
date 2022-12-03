package aoc.day02;

import java.util.Map;

public enum Shape {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private static final Map<Shape, Shape> WINS_AGAINST = Map.of(ROCK, SCISSORS, SCISSORS, PAPER, PAPER, ROCK);

    private final int score;

    Shape(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static boolean isDraw(final Shape player, final Shape opponent) {
        return player == opponent;
    }

    public static boolean isWin(final Shape player, final Shape opponent) {
        return WINS_AGAINST.get(player) == opponent;
    }


}

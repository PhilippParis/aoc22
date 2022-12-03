package aoc.day02;

public enum Shape {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int score;

    Shape(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int play(final Shape opponent) {
        if (this == opponent) {
            return getScore() + 3;
        }
        if (getLosingPick() == opponent) {
            return getScore() + 6;
        }
        return getScore();
    }

    public Shape getWinningPick() {
        return switch (this) {
            case ROCK -> PAPER;
            case PAPER -> SCISSORS;
            case SCISSORS -> ROCK;
        };
    }

    public Shape getLosingPick() {
        return switch (this) {
            case ROCK -> SCISSORS;
            case PAPER -> ROCK;
            case SCISSORS -> PAPER;
        };
    }

}

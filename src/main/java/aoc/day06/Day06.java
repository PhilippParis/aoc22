package aoc.day06;

public class Day06 {

    public long part1(final String input) {
        final var count = 4;
        final var chars = input.toCharArray();
        for (int i = count - 1; i < chars.length; i++) {
            if (areDifferent(chars, i, count)) {
                return i + 1;
            }
        }
        return -1;
    }

    private boolean areDifferent(char[] chars, int index, int count) {
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (chars[index - i] == chars[index - j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

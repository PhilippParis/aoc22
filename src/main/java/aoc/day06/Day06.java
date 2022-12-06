package aoc.day06;

public class Day06 {

    public long part1(final String input) {
        return getMarkerPos(input, 4);
    }

    public long part2(final String input) {
        return getMarkerPos(input, 14);
    }

    private long getMarkerPos(final String input, final int markerLength) {
        final var chars = input.toCharArray();
        for (int i = markerLength - 1; i < chars.length; i++) {
            if (areDifferent(chars, i, markerLength)) {
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

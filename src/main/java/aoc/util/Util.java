package aoc.util;

import org.apache.commons.lang3.text.WordUtils;

public class Util {

    public static String wrap(final String string, int wrapLength) {
        var build = new StringBuilder();
        for (int i = wrapLength; i <= string.length(); i += wrapLength) {
            build.append(string, i - wrapLength, i).append("\n");
        }
        return build.toString();
    }

}

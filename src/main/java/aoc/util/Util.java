package aoc.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static String wrap(final String string, int wrapLength) {
        var build = new StringBuilder();
        for (int i = wrapLength; i <= string.length(); i += wrapLength) {
            build.append(string, i - wrapLength, i).append("\n");
        }
        return build.toString();
    }

    public static List<List<String>> split(final List<String> input, final String separator) {
        final var result = new ArrayList<List<String>>();
        var current = new ArrayList<String>();
        for (var value : input) {
            if (value.equals(separator)) {
                result.add(current);
                current = new ArrayList<>();
            } else {
                current.add(value);
            }
        }
        result.add(current);
        return result;
    }


}

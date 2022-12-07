package aoc.day07;

import org.apache.commons.lang3.StringUtils;

public class Terminal {

    public final Dir root = new Dir("/", null);
    private Dir current = root;

    public void execute(String line) {
        if (line.startsWith("$ cd")) {
            changeDir(line.substring(5));
        } else if (line.startsWith("dir")) {
            current.add(new Dir(line.substring(4), current));
        } else if (!line.startsWith("$")) {
            final var parts = line.split(StringUtils.SPACE);
            current.add(new File(parts[1], Long.parseLong(parts[0])));
        }
    }

    private void changeDir(String target) {
        if (target.equals("/")) {
            current = root;
        } else if (target.equals("..")) {
            current = current.getParent();
        } else {
            current = current.getChild(target);
        }
    }

}

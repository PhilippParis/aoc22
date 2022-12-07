package aoc.day07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dir {

    private final String name;
    private final Dir parent;
    private final Map<String, File> files = new HashMap<>();
    private final Map<String, Dir> directories = new HashMap<>();

    public Dir(String name, Dir parent) {
        this.name = name;
        this.parent = parent;
    }

    public long getSize() {
        return files.values().stream().mapToLong(File::getSize).sum() +
                directories.values().stream().mapToLong(Dir::getSize).sum();
    }

    public Set<Dir> getDirs() {
        final var result = new HashSet<>(directories.values());
        directories.values().forEach(i -> result.addAll(i.getDirs()));
        return result;
    }

    public Dir getChild(String name) {
        return directories.get(name);
    }

    public Dir getParent() {
        return parent;
    }

    public void add(Dir dir) {
        directories.put(dir.name, dir);
    }

    public void add(File file) {
        files.put(file.getName(), file);
    }
}

package aoc.day13;

import java.util.ArrayList;
import java.util.List;

public class Packet implements Comparable<Packet> {

    private List<Packet> data = new ArrayList<>();
    private final Integer value;

    public Packet() {
        this.value = null;
    }

    public Packet(Integer value) {
        this(null, value);
    }

    public Packet(List<Packet> data) {
        this(data, null);
    }

    private Packet(List<Packet> data, Integer value) {
        this.data = data;
        this.value = value;
    }

    public Packet add(Packet packet) {
        this.data.add(packet);
        return packet;
    }

    @Override
    public int compareTo(final Packet other) {
        if (this.value != null && other.value != null) {
            return Integer.compare(this.value, other.value);
        } else if (this.value == null && other.value == null) {
            for (int i = 0; i < Math.min(data.size(), other.data.size()); i++) {
                var comparison = data.get(i).compareTo(other.data.get(i));
                if (comparison != 0) {
                    return comparison;
                }
            }
            return Integer.compare(data.size(), other.data.size());
        } else if (this.value == null) {
            return this.compareTo(new Packet(List.of(new Packet(other.value))));
        } else {
            return (new Packet(List.of(new Packet(this.value)))).compareTo(other);
        }
    }

    @Override
    public String toString() {
        if (value != null) {
            return String.valueOf(value);
        }
        return data.toString();
    }
}

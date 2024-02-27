package ch.hslu.demo;

import java.util.Arrays;
import java.util.Objects;

public final class Allocation implements Comparable<Allocation> {
    private final byte[] memory;
    private final int start;
    private final int size;

    public Allocation(final byte[] memory, final int start, final int size) {
        this.memory = memory;
        this.start = start;
        this.size = size;
    }

    public void release() {
        // release memory
    }

    @Override
    public String toString() {
        return "Allocation[Address: " + start + ", Size: " + size + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Allocation that = (Allocation) o;
        return start == that.start && size == that.size && Arrays.equals(memory, that.memory);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(start, size);
        result = 31 * result + Arrays.hashCode(memory);
        return result;
    }

    @Override
    public int compareTo(Allocation o) {
        return Integer.compare(this.start, o.start);
    }
}

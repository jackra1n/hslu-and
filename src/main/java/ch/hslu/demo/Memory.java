package ch.hslu.demo;

public class Memory implements MemorySimple{
    private final byte[] memory;
    private final int size;
    private int used;

    public Memory(final int size) {
        this.memory = new byte[size];
        this.size = size;
        this.used = 0;
    }

    @Override
    public Allocation malloc(final int size) {
        if (this.free() >= size) {
            int start = 0;
            for (int i = 0; i < this.size; i++) {
                if (this.memory[i] == 0) {
                    start = i;
                    break;
                }
            }
            for (int i = start; i < start + size; i++) {
                this.memory[i] = 1;
            }
            this.used += size;
            return new Allocation(this.memory, start, size);
        } else {
            return null;
        }
    }

    @Override
    public void free(Allocation allocation) {

    }

    @Override
    public int total() {
        return this.size;
    }

    @Override
    public int free() {
        return this.size - this.used;
    }

    @Override
    public int used() {
        return this.used;
    }

    @Override
    public String toString() {
        return "Memory{" + "memory=" + memory + ", size=" + size + ", used=" + used + '}';
    }
}

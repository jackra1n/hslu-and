package ch.hslu.demo;

public interface MemorySimple {
    Allocation malloc(int size);
    void free(Allocation allocation);
    int total();
    int free();
    int used();
}

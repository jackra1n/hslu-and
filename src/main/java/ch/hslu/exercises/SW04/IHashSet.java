package ch.hslu.exercises.SW04;

public interface IHashSet<E> {
    void add(E element);

    boolean contains(E element);

    void remove(E element);

    boolean isEmpty();

    int size();
}

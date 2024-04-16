package ch.hslu.exercises.SW04;


public class HashSet<E> implements IHashSet<E> {

    Object[] array;
    int size;

    public HashSet() {
        array = new Object[10];
    }

    @Override
    public void add(E element) {
        int index = element.hashCode() % array.length;
        System.out.println(index);
        if (array[index] == null) {
            array[index] = element;
            size++;
        }
    }

    @Override
    public boolean contains(E element) {
        for (Object o : array) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(E element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                array[i] = null;
                size--;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashSet[");
        for (Object o : array) {
            if (o != null) {
                sb.append(o);
                sb.append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length()); // remove last comma
        sb.append("]");
        return sb.toString();
    }
}

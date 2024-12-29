package fourth_work;

public interface Heap<E extends Comparable<E>> {
    int size();
    void add(E element);
    E peek();
    boolean containsHashMap(E element);
    boolean contains(E element);
}


package bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {
    private T[] elems;
    private int size;

    @SuppressWarnings("unchecked")
    public Bag() {
        this.elems = (T[]) new Object[10];
        this.size = 0;
    }

    public void add(T elem) {
        if (size == elems.length) {
            resize();
        }
        elems[size++] = elem;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void remove(T elem) {
        for (int i = 0; i < size; i++) {
            if (elems[i].equals(elem)) {
                for (int j = i; j < size - 1; j++) {
                    elems[j] = elems[j + 1];
                }
                elems[size - 1] = null;
                size--;
            }
        }
    }

    public boolean contains(T elem) {
        for (int i = 0; i < size; i++) {
            if (elems[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newElems = (T[]) new Object[elems.length * 2];
        System.arraycopy(elems, 0, newElems, 0, size);
        elems = newElems;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elems[currentIndex++];
            }
        };
    }
}

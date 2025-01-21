package bag;

import java.util.Arrays;
import java.util.Iterator;

public class CustomList<T> implements Iterable<T> {
    private Object[] elements;
    private int size;

    public CustomList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    @SafeVarargs
    public CustomList(T... items) {
        this.elements = new Object[items.length];
        System.arraycopy(items, 0, this.elements, 0, items.length);
        this.size = items.length;
    }

    public CustomList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    public void add(T element) {
        resize();
        elements[size++] = element;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    private void resize() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null && element == null) {
                return i;
            }
            if (elements[i] != null && elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public T set(int index, T element) {
        checkIndex(index);
        T oldElement = (T) elements[index];
        elements[index] = element;
        return oldElement;
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
                    throw new IllegalStateException();
                }
                return (T) elements[currentIndex++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

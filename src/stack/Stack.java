package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class Stack<T> implements Iterable<T> {
    private Object[] elements;
    private int size;
    private int capacity = 10;

    public int getSize() {
        return size;
    }

    public Stack() {
        elements = new Object[capacity];
        size = 0;
    }

    public void push(T elem) {
        if (size == elements.length) {
            increase();
        }
        elements[size++] = elem;
    }

    public T pop() {
        T item = (T) elements[--size];
        elements[size] = null;
        return item;
    }

    public T peek() {
        return (T) elements[size - 1];
    }

    private void increase() {
        int newCapacity = elements.length + 10;
        Object[] temp = new Object[newCapacity];
        System.arraycopy(elements, 0, temp, 0, size);
        elements = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elements[index--];
            }
        };
    }


}


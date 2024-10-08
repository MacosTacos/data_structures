package doublylinkedlist;

import java.util.Iterator;

class DoublyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int getSize() {
        return size;
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToTail(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void addToHead(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void removeHead() {
        head = head.next;
        if(head != null) {
            head.prev = null;
        }
        size--;
    }

    public void removeTail() {
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        size--;
    }

    public void update(T object, T data) {
        Node<T> node = head;
        while(object != node.data) {
            node = node.next;
        }
        node.data = data;
    }

    public T get(int index) {
        Node<T> node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = index - 1; i > 0; i--) {
                node = node.prev;
            }
        }
        return node.data;
    }

    public void set(int index, T value) {
        Node<T> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        node.data = value;
    }


    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
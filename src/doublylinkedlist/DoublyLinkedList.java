package doublylinkedlist;

class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;


    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void remove(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (node == head) {
            head = head.next;
            if(head != null) {
                head.prev = null;
            }
        } else if (node == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void update(int index, T data) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.data = data;
    }

    public T get(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }
}

package tree;

public class BST<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    public BST() {
        this.root = null;
    }

    @Override
    public void insert(E element) {
        this.root = insertRec(this.root, element);
    }

    private Node<E> insertRec(Node<E> node, E element) {
        if (node == null) {
            return new Node<>(element);
        }

        if (element.compareTo(node.value) < 0) {
            node.leftChild = insertRec(node.leftChild, element);
        } else if (element.compareTo(node.value) > 0) {
            node.rightChild = insertRec(node.rightChild, element);
        }

        return node;
    }

    @Override
    public boolean contains(E element) {
        return containsRec(this.root, element);
    }

    private boolean containsRec(Node<E> node, E element) {
        if (node == null) {
            return false;
        }

        int cmp = element.compareTo(node.value);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return containsRec(node.leftChild, element);
        } else {
            return containsRec(node.rightChild, element);
        }
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> foundNode = searchRec(this.root, element);
        if (foundNode != null) {
            BST<E> subtree = new BST<>();
            subtree.root = foundNode;
            return subtree;
        }
        return null;
    }

    private Node<E> searchRec(Node<E> node, E element) {
        if (node == null || node.value.equals(element)) {
            return node;
        }

        if (element.compareTo(node.value) < 0) {
            return searchRec(node.leftChild, element);
        } else {
            return searchRec(node.rightChild, element);
        }
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.root != null ? this.root.leftChild : null;
    }

    @Override
    public Node<E> getRight() {
        return this.root != null ? this.root.rightChild : null;
    }

    @Override
    public E getValue() {
        return this.root != null ? this.root.value : null;
    }

}

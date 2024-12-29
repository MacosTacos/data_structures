package tree;

import java.util.*;

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
    public void printTree() {
        if (this.root == null) {
            System.out.println("(empty tree)");
            return;
        }

        List<List<String>> levels = new ArrayList<>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node<E> current = queue.poll();
                if (current != null) {
                    currentLevel.add(current.value.toString());
                    queue.add(current.leftChild);
                    queue.add(current.rightChild);
                } else {
                    currentLevel.add(null);
                    queue.add(null);
                    queue.add(null);
                }
            }

            boolean allNulls = currentLevel.stream().allMatch(Objects::isNull);
            if (allNulls) break;

            levels.add(currentLevel);
        }


        int maxWidth = levels.get(levels.size() - 1).size();
        for (int i = 0; i < levels.size(); i++) {
            List<String> level = levels.get(i);
            int spacing = (int) Math.pow(2, levels.size() - i - 1);
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < level.size(); j++) {
                String nodeValue = level.get(j) == null ? "  " : level.get(j);
                int padding = spacing - 1;
                sb.append("  ".repeat(padding)).append(nodeValue).append("  ".repeat(padding + 1));
            }

            System.out.println(sb);
        }
    }


    private int getWidth(int height) {
        return (int) Math.pow(2, height) - 1;
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

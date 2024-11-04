package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private AbstractBinaryTree<E> left;
    private AbstractBinaryTree<E> right;

    public BinaryTree(E key) {
        this.key = key;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public void setLeft(AbstractBinaryTree<E> left) {
        this.left = left;
    }

    @Override
    public void setRight(AbstractBinaryTree<E> right) {
        this.right = right;
    }

    @Override
    public String asIndentedPreOrder(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(i));
        sb.append(this.key).append("\n");
        if (this.left != null) {
            sb.append(this.left.asIndentedPreOrder(i + 1));
        }
        if (this.right != null) {
            sb.append(this.right.asIndentedPreOrder(i + 1));
        }
        return sb.toString();
    }


    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);
        if (left != null) {
            result.addAll(left.preOrder());
        }
        if (right != null) {
            result.addAll(right.preOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.inOrder());
        }
        result.add(this);
        if (right != null) {
            result.addAll(right.inOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.postOrder());
        }
        if (right != null) {
            result.addAll(right.postOrder());
        }
        result.add(this);
        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }

    @Override
    public List<AbstractBinaryTree<E>> formatBFS() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();

        queue.add(this); // Начинаем с корня

        while (!queue.isEmpty()) {
            AbstractBinaryTree<E> current = queue.poll();
            result.add(current);

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        return result;
    }

    public static <E> boolean isMirror(AbstractBinaryTree<E> tree1, AbstractBinaryTree<E> tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }

        Queue<AbstractBinaryTree<E>> queue1 = new LinkedList<>();
        Queue<AbstractBinaryTree<E>> queue2 = new LinkedList<>();

        queue1.add(tree1);
        queue2.add(tree2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            AbstractBinaryTree<E> node1 = queue1.poll();
            AbstractBinaryTree<E> node2 = queue2.poll();

            if (node1.getKey() == null && node2.getKey() != null ||
                    node1.getKey() != null && node2.getKey() == null) {
                return false;
            }
            if (node1.getKey() != null && !node1.getKey().equals(node2.getKey())) {
                return false;
            }

            if (node1.getLeft() != null && node2.getRight() != null) {
                queue1.add(node1.getLeft());
                queue2.add(node2.getRight());
            } else if (node1.getLeft() != node2.getRight()) {
                return false;
            }

            if (node1.getRight() != null && node2.getLeft() != null) {
                queue1.add(node1.getRight());
                queue2.add(node2.getLeft());
            } else if (node1.getRight() != node2.getLeft()) {
                return false;
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}
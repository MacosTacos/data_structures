package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E> {
    E getKey();
    AbstractBinaryTree<E> getLeft();
    AbstractBinaryTree<E> getRight();
    void setLeft(AbstractBinaryTree<E> left);
    void setRight(AbstractBinaryTree<E> right);
    void setKey(E key);
    String asIndentedPreOrder(int indent);
    List<AbstractBinaryTree<E>> preOrder();
    List<AbstractBinaryTree<E>> inOrder();
    List<AbstractBinaryTree<E>> postOrder();
    void forEachInOrder(Consumer<E> consumer);
    public List<AbstractBinaryTree<E>> formatBFS();
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
package tree;

import java.util.List;
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
}
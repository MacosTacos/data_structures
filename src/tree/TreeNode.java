package tree;

public class TreeNode<E> {
    public E value;
    public TreeNode<E>leftChild;
    public TreeNode<E>rightChild;

    public TreeNode(E value) {
        this.value= value;
    }

    public TreeNode(E value, TreeNode<E> leftChild, TreeNode<E> rightChild) {
        this.value= value;
        this.leftChild= leftChild;
        this.rightChild= rightChild;
    }
}


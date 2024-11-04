package tree;

import doublylinkedlist.Minion;

import java.util.List;

public class BinaryTreeTest {
    public static void main(String[] args) {
        AbstractBinaryTree<Integer> binaryTree = new BinaryTree<>(10);
        AbstractBinaryTree<Integer> binaryTree2 = new BinaryTree<>(2);
        AbstractBinaryTree<Integer> binaryTree3 = new BinaryTree<>(4);
        AbstractBinaryTree<Integer> binaryTree4 = new BinaryTree<>(6);
        AbstractBinaryTree<Integer> binaryTree5 = new BinaryTree<>(16);
        AbstractBinaryTree<Integer> binaryTree6 = new BinaryTree<>(29);
        AbstractBinaryTree<Integer> binaryTree7 = new BinaryTree<>(74);
        binaryTree.setLeft(binaryTree3);
        binaryTree3.setLeft(binaryTree2);
        binaryTree3.setRight(binaryTree4);
        binaryTree.setRight(binaryTree6);
        binaryTree6.setLeft(binaryTree5);
        binaryTree6.setRight(binaryTree7);
        printNicely(binaryTree);
        System.out.println("Вывод asIndentedPreOrder");
        System.out.println(binaryTree.asIndentedPreOrder(0));
        System.out.println("Вывод preOrder");
        printTree(binaryTree.preOrder());
        System.out.println("Вывод inOrder");
        printTree(binaryTree.inOrder());
        System.out.println("Вывод postOrder");
        printTree(binaryTree.postOrder());
        System.out.println("Вывод BFS");
        printTree(binaryTree.formatBFS());

    }

    static void printTree(List<AbstractBinaryTree<Integer>> trees) {
        for (AbstractBinaryTree tree : trees) {
            System.out.print(tree.getKey() + " ");
        }
        System.out.println("\n____________________________________________________________");
    }

    static void printNicely(AbstractBinaryTree<Integer> tree) {
        System.out.println("Дерево:");
        System.out.println("        " + tree.getKey());
        System.out.println("    " + tree.getLeft().getKey() + "        " + tree.getRight().getKey());
        System.out.println("  " + tree.getLeft().getLeft().getKey() + "   " + tree.getLeft().getRight().getKey() + "    " + tree.getRight().getLeft().getKey() + "  " + tree.getRight().getRight().getKey());
    }

}

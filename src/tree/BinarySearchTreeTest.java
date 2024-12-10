package tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        AbstractBinarySearchTree<Integer> tree = new BST<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(29);
        tree.insert(2);
        tree.insert(6);
        tree.insert(16);
        tree.insert(74);
        printNicely(tree);


        System.out.println("Проверка на наличие элемента со значением 2: " + tree.contains(2));
        System.out.println("Корень дерева: " + tree.getRoot().value);


    }



    static void printNicely(AbstractBinarySearchTree<Integer> tree) {
        System.out.println("Дерево:");
        System.out.println("        " + tree.getValue());
        System.out.println("    " + tree.getLeft().value + "        " + tree.getRight().value);
        System.out.println("  " + tree.getLeft().leftChild.value + "   " + tree.getLeft().rightChild.value + "    " + tree.getRight().leftChild.value + "  " + tree.getRight().rightChild.value);
    }
}

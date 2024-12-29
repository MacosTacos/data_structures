package tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        AbstractBinarySearchTree<Integer> tree = new BST<>();
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(40);
        tree.insert(90);
        tree.insert(60);
        tree.insert(10);
        tree.insert(95);
        tree.insert(99);
        tree.insert(42);
        tree.insert(62);
        tree.printTree();


        System.out.println("Проверка на наличие элемента со значением 2: " + tree.contains(2));
        System.out.println("Корень дерева: " + tree.getRoot().value);


    }



    static void printNicely(AbstractBinarySearchTree<Integer> tree) {
        System.out.println("Дерево:");
        System.out.println("        " + tree.getValue());
        System.out.println("      /    \\   ");
        System.out.println("    " + tree.getLeft().value + "        " + tree.getRight().value);
        System.out.println("   / \\       / \\");
        System.out.println("  " + tree.getLeft().leftChild.value + "   " + tree.getLeft().rightChild.value + "    " + tree.getRight().leftChild.value + "  " + tree.getRight().rightChild.value);
        System.out.println("   / \\       / \\");
        System.out.println("  " + tree.getLeft().leftChild.value + "   " + tree.getLeft().rightChild.value + "    " + tree.getRight().leftChild.value + "  " + tree.getRight().rightChild.value);
    }
}

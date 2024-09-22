package doublylinkedlist;

public class DLLTest {
    public static void main(String[] args) {
        DoublyLinkedList<Minion> minions = new DoublyLinkedList<>();
        Minion firstMinion = new Minion(0, "papoj", 2);
        Minion secondMinion = new Minion(1, "banana", 2);
        Minion thirdMinion = new Minion(2, "KIRILL", 1);
        Minion fourthMinion = new Minion(3, "alek", 1);

        minions.add(firstMinion);
        minions.add(secondMinion);
        minions.add(thirdMinion);
        minions.add(fourthMinion);

        printList(minions, 4);

        minions.remove(2);

        printList(minions, 3);

        Minion updatedMinion = new Minion(15, "kruggets", 2);
        minions.update(2, updatedMinion);

        printList(minions, 3);



    }

    static void printList(DoublyLinkedList<Minion> minions, int capacity) {
        for(int i = 0; i < capacity; i++) {
            System.out.println(minions.get(i));
        }
        System.out.println("____________________________________________________________");
    }
}

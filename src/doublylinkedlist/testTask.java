package doublylinkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testTask {
    public static void main(String[] args) {
//        Minion firstMinion = new Minion(0, "papoj", 2);
//        Minion secondMinion = new Minion(1, "banana", 2);
//        Minion thirdMinion = new Minion(2, "KIRILL", 1);
        List<Minion> minionList = new ArrayList<>();
        minionList.add(new Minion(10, "Bobus", 1));
        minionList.add(new Minion(10, "Amogus", 1));  // level + eyesCount = 5 (равно, но по имени "Kevin" > "Bob")
        minionList.add(new Minion(8, "Bobus", 5));
        minionList.add(new Minion(8, "Babus", 5));
        minionList.add(new Minion(9, "Babus", 4));
        minionList.add(new Minion(7, "Bobus", 6));
        minionList.add(new Minion(7, "Bobus", 6));
        System.out.println("Несортированный список:");
        printList(minionList);
        minionList.sort(new TestComparator());
        System.out.println("Отсортированный список:");
        printList(minionList);
    }

    static void printList(List<Minion> minions) {
        for (Minion minion : minions) {
            System.out.println(minion);
        }
        System.out.println("____________________________________________________________");
    }
}

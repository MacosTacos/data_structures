package doublylinkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DLLTest {
    public static void main(String[] args) {
        DoublyLinkedList<Minion> minions = new DoublyLinkedList<>();
        Minion firstMinion = new Minion(0, "papoj", 2);
        Minion secondMinion = new Minion(1, "banana", 2);
        Minion thirdMinion = new Minion(2, "KIRILL", 1);
        Minion fourthMinion = new Minion(2, "ALEK", 1);
        System.out.println("Добавление первого элемента");
        minions.addToTail(firstMinion);
        printList(minions);
        System.out.println("Добавление в конец двух элементов");
        minions.addToTail(secondMinion);
        minions.addToTail(thirdMinion);
        printList(minions);
        System.out.println("Добавление в начало одного элемента");
        minions.addToHead(fourthMinion);
        printList(minions);
        System.out.println("Удаление одного элемента с конца, одного с начала");

        minions.removeHead();
        minions.removeTail();

        printList(minions);
        System.out.println("Обновление элемента");

        Minion updatedMinion = new Minion(15, "kruggets", 2);
        minions.update(secondMinion, updatedMinion);
        printList(minions);
        System.out.println("Изменение и вывод элемента по индексу 1");
        minions.set(1, thirdMinion);
        System.out.println(minions.get(1));

        System.out.println("Сравнение двух миньонов по уровню с использованием компаратора");
        System.out.println("Неотсортированный список миньонов:");
        List<Minion> minionList = new ArrayList<>();
        minionList.add(fourthMinion);
        minionList.add(thirdMinion);
        minionList.add(firstMinion);
        for (Minion minion : minionList) {
            System.out.println(minion);
        }
        System.out.println("Отсортированный список:");
        Collections.sort(minionList);
        for (Minion minion : minionList) {
            System.out.println(minion);
        }
    }

    static void printList(DoublyLinkedList<Minion> minions) {
        for (Minion minion : minions) {
            System.out.println(minion);
        }
        System.out.println("____________________________________________________________");
    }
}
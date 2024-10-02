package stack;

import doublylinkedlist.Minion;

public class StackTest {
    public static void main(String[] args) {
        Stack<Minion> stack = new Stack<>();
        Minion firstMinion = new Minion(0, "papoj", 2);
        Minion secondMinion = new Minion(1, "banana", 2);
        Minion thirdMinion = new Minion(2, "KIRILL", 1);
        Minion fourthMinion = new Minion(3, "alek", 1);
        stack.push(firstMinion);
        System.out.println("Добавлен первый элемент в стек");
        output(stack);
        stack.push(secondMinion);
        stack.push(thirdMinion);
        System.out.println("Добавлены еще 2 элемента");
        output(stack);
        stack.pop();
        System.out.println("Кирилл покинул чач");
        output(stack);
        System.out.println("Демонстрация работы функции peek: " + stack.peek());
        stack.push(fourthMinion);
        System.out.println("Еще один элемент добавлен");
        output(stack);


    }

    static void output(Stack<Minion> stack) {
        for (Minion minion : stack) {
            System.out.println(minion);
        }
        System.out.println("--------------------------------------------");
    }
}

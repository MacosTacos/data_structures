package fourth_work;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        AbstractQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(5);
        priorityQueue.add(10);
        priorityQueue.add(3);

        System.out.println("размер: " + priorityQueue.size());
        System.out.println("peek: " + priorityQueue.peek());
        System.out.println("poll: " + priorityQueue.poll());
        System.out.println("peek: " + priorityQueue.peek());
        System.out.println("размер: " + priorityQueue.size());

        System.out.println("____________________________________");
        Heap<Integer> maxHeap = new MaxHeap<>(10);

        maxHeap.add(5);
        maxHeap.add(10);
        maxHeap.add(3);
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            maxHeap.add(random.nextInt());
        }


        System.out.println("размер: " + maxHeap.size());
        System.out.println("peek: " + maxHeap.peek());

        maxHeap.add(15);
        System.out.println("peek после добавления: " + maxHeap.peek());
        System.out.println("размер: " + maxHeap.size());

        System.out.println("поиск элемента 15 по treemap");
        long startTime = System.nanoTime();
        System.out.println(maxHeap.contains(15) ? "true" : "false");
        System.out.println((System.nanoTime() - startTime) + " nano seconds");

        System.out.println("поиск элемента 15 по hashmap:");
        startTime = System.nanoTime();
        System.out.println(maxHeap.containsHashMap(15) ? "true" : "false");
        System.out.println((System.nanoTime() - startTime) + " nano seconds");
    }
}

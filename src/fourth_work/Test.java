package fourth_work;

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

        System.out.println("размер: " + maxHeap.size());
        System.out.println("peek: " + maxHeap.peek());

        maxHeap.add(15);
        System.out.println("peek после добавления: " + maxHeap.peek());
        System.out.println("размер: " + maxHeap.size());
    }
}

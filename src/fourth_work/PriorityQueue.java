package fourth_work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private List<E> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void add(E element) {
        queue.add(element);
        Collections.sort(queue, Collections.reverseOrder());
    }

    @Override
    public E peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    @Override
    public E poll() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }
}

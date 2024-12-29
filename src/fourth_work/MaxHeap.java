package fourth_work;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private E[] heap;
    private int size;
    private Map<E, Integer> indexMap;
    private Map<E, Integer> indexMapDefault;

    @SuppressWarnings("unchecked")
    public MaxHeap(int capacity) {
        heap = (E[]) new Comparable[capacity];
        size = 0;
        indexMap = new HashMap<>();
        indexMapDefault = new TreeMap<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        if (size == heap.length) {
            grow();
        }
        heap[size] = element;
        indexMap.put(element, size);
        indexMapDefault.put(element, size);
        heapifyUp(size);
        size++;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return heap[0];
    }

    public E remove(E element) {
        Integer index = indexMap.get(element);
        if (index == null || size == 0) {
            return null;
        }

        E removedValue = heap[index];
        swap(index, size - 1);
        size--;
        indexMap.remove(removedValue);

        if (index < size) {
            heapifyDown(index);
            heapifyUp(index);
        }
        return removedValue;
    }

    @Override
    public boolean containsHashMap(E element) {
        return indexMap.containsKey(element);
    }
    @Override
    public boolean contains(E element) {
        return indexMapDefault.containsKey(element);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index].compareTo(heap[parentIndex]) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild < size && heap[leftChild].compareTo(heap[largest]) > 0) {
            largest = leftChild;
        }
        if (rightChild < size && heap[rightChild].compareTo(heap[largest]) > 0) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

        indexMap.put(heap[i], i);
        indexMap.put(heap[j], j);

        indexMapDefault.put(heap[i], i);
        indexMapDefault.put(heap[j], j);
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        heap = java.util.Arrays.copyOf(heap, heap.length * 2);
    }
}

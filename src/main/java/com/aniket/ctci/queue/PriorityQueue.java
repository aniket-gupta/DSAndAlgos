package com.aniket.ctci.queue;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by AnGupta on 5/28/17.
 */
public class PriorityQueue<E> implements Queue<E>{

    private int size;

    private Object[] queue;

    private static int DEFAULT_INIT_CAPACITY = 10;

    private static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private Comparator<? super E> comparator;

    public PriorityQueue() {
        this(DEFAULT_INIT_CAPACITY, null);

    }

    public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    public PriorityQueue(Comparator<? super E> comparator) {
        this(DEFAULT_INIT_CAPACITY, comparator);
    }

    public PriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    public PriorityQueue(Object[] arr) {
        this.queue = Arrays.copyOf(arr, arr.length);
        this.size = arr.length;
        heapify();

    }

    public E getMax() {
        return size == 0 ? null : (E) queue[0];
    }

    public E peek() {
        return getMax();
    }

    public E extractMax() {
        if(size == 0)
            return null;

        E data = (E) queue[0];

        queue[0] = queue[--size];

        siftDown(0);
        return data;

    }

    public void enqueue(E e) {
        insert(e);
    }

    public E dequeue() {
        return extractMax();
    }

    public void insert(E e) {

        if(size == 0) {
            queue[size++] = e;
            return;
        }
        int i = size++;
        ensureCapacity(size);
        queue[i] = e;
        shiftUp(i);


    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void shiftUp(int index) {
        if (comparator != null) siftUpUsingComparator(index);
        else siftUpUsingComparable(index);

    }

    private void siftUpUsingComparator(int index) {

        while (index > 0 &&
                comparator.compare((E)queue[index], (E)queue[parentOf(index)]) > 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    private void siftUpUsingComparable(int index) {
        Comparable<? super E> key = (Comparable<? super E>) queue[index];

        while (index > 0 &&
                key.compareTo((E)queue[parentOf(index)]) > 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
            key = (Comparable<? super E>) queue[index];
        }


    }

    private void swap(int i, int j) {
        Object tmp = queue[i];
        queue[i] = queue[j];
        queue[j] = tmp;
    }

    private void siftDown(int index) {
        if(comparator != null) {
            siftDownUsingComparator(index);
        } else siftDownUsingComparable(index);

    }

    private void siftDownUsingComparable(int index) {
        Comparable<? super E> key = (Comparable<? super E>) queue[index];

        int half = size >>> 1; //half of size

        int maxIndex = index;
        while (index < half) {
            key = (Comparable<? super E>) queue[index];
            int left = leftChildOf(index);
            int right = rightChildOf(index);
            int indedToCompare = left;
            if(((Comparable<? super E>) queue[left]).compareTo((E)queue[right]) < 0)
                indedToCompare = right;

            if(key.compareTo((E)queue[indedToCompare]) < 0)
                maxIndex = indedToCompare;

            if (maxIndex == index)
                break;
            swap(index, maxIndex);
            index = maxIndex;
        }


    }

    private void siftDownUsingComparator(int index) {
        int half = size >>> 1; //half of size

        int maxIndex = index;
        while (index < half) {
            E key = (E)queue[index];
            int left = leftChildOf(index);
            int right = rightChildOf(index);
            if(comparator.compare(key, (E)queue[left])  < 0)
                maxIndex = left;
            if(comparator.compare(key, (E)queue[right]) < 0)
                maxIndex = right;
            if (maxIndex == index)
                break;
            swap(index, maxIndex);
            index = maxIndex;
        }
    }


    public void update(E oldObject, E newObject) {
        // TODO:
    }

    private void heapify() {

        int half = size >>> 1;

        for(int i = half; i >= 0; i--) {
            siftDown(i);
        }

    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > queue.length) {
            int oldCapacity = queue.length;
            int newCapacity = oldCapacity + (oldCapacity > 64 ? oldCapacity : oldCapacity >> 1);
            if (newCapacity - MAX_ARRAY_SIZE > 0) {
                newCapacity = Integer.MAX_VALUE;
            }

            queue = Arrays.copyOf(queue, newCapacity);
        }
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;

    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) >>> 1;
    }


}

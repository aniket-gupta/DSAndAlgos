package com.aniket.test;

import com.aniket.ctci.queue.PriorityQueue;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by AnGupta on 5/28/17.
 */
public class PriorityQueueTest {

    @Test
    public void testExtractMax() {
        Integer[] a = {1, 5, 3, 7, 2, 9, 12};
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(a);

        assertEquals(new Integer(12), queue.extractMax());
        assertEquals(new Integer(9), queue.extractMax());
        assertEquals(new Integer(7), queue.extractMax());
        assertEquals(new Integer(5), queue.extractMax());
        assertEquals(new Integer(3), queue.extractMax());
        assertEquals(new Integer(2), queue.extractMax());
        assertEquals(new Integer(1), queue.extractMax());
        assertEquals(null, queue.extractMax());

    }

    @Test
    public void testInsert() {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.insert(3);
        queue.insert(12);
        queue.insert(1);
        queue.insert(24);
        queue.insert(2);
        queue.insert(9);
        queue.insert(5);
        queue.insert(8);
        queue.insert(2);
        queue.insert(10);

        assertEquals(new Integer(24), queue.peek());
        assertEquals(new Integer(24), queue.extractMax());
        assertEquals(new Integer(12), queue.extractMax());
        assertEquals(new Integer(10), queue.extractMax());
        assertEquals(new Integer(9), queue.extractMax());
        assertEquals(new Integer(8), queue.extractMax());
        assertEquals(new Integer(5), queue.extractMax());
        assertEquals(new Integer(3), queue.extractMax());
        assertEquals(new Integer(2), queue.extractMax());
        assertEquals(new Integer(2), queue.extractMax());
        assertEquals(new Integer(1), queue.extractMax());

    }
}

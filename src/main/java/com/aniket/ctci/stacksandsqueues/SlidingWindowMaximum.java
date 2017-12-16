package com.aniket.ctci.stacksandsqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    /**
     * A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window. The following example will give you more clarity.
     * <p>
     * Example :
     * <p>
     * The array is [1 3 -1 -3 5 3 6 7], and w is 3.
     * <p>
     * Window position	Max
     * <p>
     * [1 3 -1] -3 5 3 6 7	3
     * 1 [3 -1 -3] 5 3 6 7	3
     * 1 3 [-1 -3 5] 3 6 7	5
     * 1 3 -1 [-3 5 3] 6 7	5
     * 1 3 -1 -3 [5 3 6] 7	6
     * 1 3 -1 -3 5 [3 6 7]	7
     * Input: A long array A[], and a window width w
     * Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
     * Requirement: Find a good optimal way to get B[i]
     * <p>
     * Note: If w > length of the array, return 1 element with the max of the array.
     */

    public static void main(String[] args) {
        int[] A = {648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};

        int[] res = new SlidingWindowMaximum().slidingMaximum(A, 9);
    }

    /**
     * We create a Dequeue, Qi of capacity k, that stores only useful elements of current window of k elements. An element is useful if it is in current window and is greater than all other elements on left side of it in current window. We process all array elements one by one and maintain Qi to contain useful elements of current window and these useful elements are maintained in sorted order. The element at front of the Qi is the largest and element at rear of Qi is the smallest of current window. Thanks to Aashish for suggesting this method.
     */

    public int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> deque = new ArrayDeque<Integer>(B);
        int i = 0;
        int index = 0;
        int[] res = new int[A.length - B + 1];

        /* Process first k (or first window) elements of array */
        for (i = 0; i < B && i < A.length; i++) {
            // For very element, the previous smaller elements are useless so
            // remove them from Q
            while (!deque.isEmpty() && A[i] >= A[deque.peekLast()]) {
                deque.pollLast();
            }
            // Add new element at rear of queue
            deque.offerLast(i);
        }

        for (; i < A.length; i++) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            res[index++] = A[deque.peekFirst()];

            // Remove the elements which are out of this window
            while (!deque.isEmpty() && deque.peekFirst() <= i - B) {
                deque.pollFirst();
            }

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while (!deque.isEmpty() && A[i] >= A[deque.peekLast()]) {
                deque.pollLast();
            }
            // Add new element at rear of queue
            deque.offerLast(i);
        }

        if (!deque.isEmpty()) {
            res[index++] = A[deque.pollFirst()];
        }

        return res;
    }
}

package com.aniket.ctci.stacksandsqueues;

import java.util.Stack;

public class NextGreater {

    /**
     * Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
     * More formally,
     * <p>
     * G[i] for an element A[i] = an element A[j] such that
     * j is minimum possible AND
     * j > i AND
     * A[j] > A[i]
     * Elements for which no greater element exist, consider next greater element as -1.
     * <p>
     * Example:
     * <p>
     * Input : A : [4, 5, 2, 10]
     * Output : [5, 10, 10, -1]
     * <p>
     * Example 2:
     * <p>
     * Input : A : [3, 2, 1]
     * Output : [-1, -1, -1]
     */


    // O(n^2 - n)
    public int[] nextGreater1(int[] A) {

        int[] res = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int j = i + 1;
            for (; j < A.length; j++) {
                if (A[j] > A[i]) {
                    res[i] = A[j];
                    break;
                }
            }
            if (j == A.length) res[i] = -1;
        }

        return res;

    }

    public int[] nextGreater(int[] A) {

        int[] res = new int[A.length];

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);

        int next = 1;

        while (next < A.length) {
            while (!stack.isEmpty() && A[next] > A[stack.peek()]) {
                int top = stack.pop();
                res[top] = A[next];
            }
            stack.push(next);
            next++;
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            res[top] = -1;
        }

        return res;

    }
}

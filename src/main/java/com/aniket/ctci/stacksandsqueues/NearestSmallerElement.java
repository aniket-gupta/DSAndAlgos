package com.aniket.ctci.stacksandsqueues;

import java.util.Stack;

public class NearestSmallerElement {

    /**
     * Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
     * <p>
     * More formally,
     * <p>
     * G[i] for an element A[i] = an element A[j] such that
     * j is maximum possible AND
     * j < i AND
     * A[j] < A[i]
     * Elements for which no smaller element exist, consider next smaller element as -1.
     * <p>
     * Example:
     * <p>
     * Input : A : [4, 5, 2, 10, 8]
     * Return : [-1, 4, -1, 2, 2]
     * <p>
     * Example 2:
     * <p>
     * Input : A : [3, 2, 1]
     * Return : [-1, -1, -1]
     */

    public int[] prevSmaller(int[] A) {
        if (A == null || A.length < 1) return new int[0];
        int[] res = new int[A.length];
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        stack1.push(A[0]);

        int minIndex = 0;

        res[0] = -1;
        for (int i = 1; i < A.length; i++) {
            int val = A[i];
            res[i] = -1;
            if (val > A[minIndex]) {
                while (!stack1.isEmpty() && stack1.peek() >= val) {
                    stack2.push(stack1.pop());
                }

                if (!stack1.isEmpty()) res[i] = stack1.peek();
                while (!stack2.isEmpty()) stack1.push(stack2.pop());
            }

            stack1.push(A[i]);
            if (val < A[minIndex]) minIndex = i;
        }

        return res;

    }
}

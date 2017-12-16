package com.aniket.ctci.stacksandsqueues;

import java.util.Stack;

public class LargestRectangleinHistogram {

    /**
     * Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
     * <p>
     * Largest Rectangle in Histogram: Example 1
     * <p>
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     * <p>
     * Largest Rectangle in Histogram: Example 2
     * <p>
     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     * <p>
     * For example,
     * Given height = [2,1,5,6,2,3],
     * return 10.
     */

    /**
     * SOLUTION APPROACH
     * For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle. If we calculate such area for every bar ‘x’ and find the maximum of all areas, our task is done. How to calculate area with ‘x’ as smallest bar? We need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’ and index of first smaller bar on right of ‘x’. Let us call these indexes as ‘left index’ and ‘right index’ respectively.
     * We traverse all bars from left to right, maintain a stack of bars. Every bar is pushed to stack once. A bar is popped from stack when a bar of smaller height is seen. When a bar is popped, we calculate the area with the popped bar as smallest bar. How do we get left and right indexes of the popped bar – the current index tells us the ‘right index’ and index of previous item in stack is the ‘left index’. Following is the complete algorithm.
     * <p>
     * 1) Create an empty stack.
     * <p>
     * 2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
     * ……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
     * ……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
     * <p>
     * 3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
     */

    public static void main(String[] args) {
        int[] A = {
                69, 47, 84, 7, 70, 73, 4, 73, 70, 54, 2, 35, 32, 53, 99, 41, 90, 53, 55, 6, 1, 95, 63, 63, 74, 12, 32, 89, 69, 71, 17, 49, 9, 40, 10, 56
        };

        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(A));
    }

    public int largestRectangleArea(int[] A) {

        if (A == null || A.length < 1) return 0;

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;
        for (; i < A.length; ) {
            if (stack.isEmpty() || A[i] >= A[stack.peek()]) {
                stack.push(i++);
            } else {
                // while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                int h = A[stack.pop()];

                int area = h * (stack.isEmpty() ? i : i - stack.peek() - 1);
                max = Math.max(max, area);
                //  }
                //  stack.push(i);
            }


        }
        while (!stack.isEmpty()) {
            int h = A[stack.pop()];

            int area = h * (stack.isEmpty() ? i : i - stack.peek() - 1);
            max = Math.max(max, area);
        }


        return max;

    }
}

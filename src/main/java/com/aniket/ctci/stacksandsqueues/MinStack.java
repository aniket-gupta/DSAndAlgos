package com.aniket.ctci.stacksandsqueues;

import java.util.Stack;

public class MinStack {

    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * <p>
     * push(x) – Push element x onto stack.
     * pop() – Removes the element on top of the stack.
     * top() – Get the top element.
     * getMin() – Retrieve the minimum element in the stack.
     * Note that all the operations have to be constant time operations.
     * <p>
     * Questions to ask the interviewer :
     * <p>
     * Q: What should getMin() do on empty stack?
     * A: In this case, return -1.
     * <p>
     * Q: What should pop do on empty stack?
     * A: In this case, nothing.
     * <p>
     * Q: What should top() do on empty stack?
     * A: In this case, return -1
     */

    /**
     * Solution
     * http://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
     */
    Stack<Integer> s = new Stack<Integer>();
    Integer minEle;

    public void push(int x) {
        if (s.isEmpty()) {
            minEle = x;
            s.push(x);

            return;
        }

        // If new number is less than original minEle
        if (x < minEle) {
            s.push(2 * x - minEle);
            minEle = x;
        } else
            s.push(x);
    }

    public void pop() {

        if (s.isEmpty()) {

            return;
        }


        Integer t = s.pop();

        // Minimum will change as the minimum element
        // of the stack is being removed.
        if (t < minEle) {

            minEle = 2 * minEle - t;
        }


    }

    public int top() {
        if (s.isEmpty()) {

            return -1;
        }

        Integer t = s.peek(); // Top element.


        // If t < minEle means minEle stores
        // value of t.
        if (t < minEle)
            return minEle;
        else
            return t;
    }

    public int getMin() {
        if (s.isEmpty())
            return -1;

            // variable minEle stores the minimum element
            // in the stack.
        else
            return minEle;
    }
}

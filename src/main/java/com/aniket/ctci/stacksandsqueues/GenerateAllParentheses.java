package com.aniket.ctci.stacksandsqueues;


import java.util.Stack;

public class GenerateAllParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     * <p>
     * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
     */

    public int isValid(String a) {

        if (a == null || a.length() < 2) return 0;


        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (isLeftParan(c)) {
                stack.push(c);
            } else if (isRightParan(c)) {
                if (stack.isEmpty()) return 0;
                char charInStack = stack.peek().charValue();
                if (isMatching(c, charInStack)) {
                    stack.pop();
                } else break;
            }
        }

        if (!stack.isEmpty()) return 0;

        return 1;
    }

    private boolean isMatching(char c, char charInStack) {
        return (c == ')' && charInStack == '(') ||
                (c == '}' && charInStack == '{') ||
                (c == ']' && charInStack == '[');
    }

    private boolean isRightParan(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private boolean isLeftParan(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}

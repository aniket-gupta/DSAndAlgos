package com.aniket.ctci.stacksandsqueues;

import java.util.Stack;

public class SimplifyDirectoryPath {

    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     * <p>
     * Examples:
     * <p>
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     * Note that absolute path always begin with ‘/’ ( root directory )
     * Path will not have whitespace characters.
     */

    public String simplifyPath(String a) {
        StringBuffer strBuffer = new StringBuffer();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '.') {
                while (!stack.isEmpty() && stack.peek() != '/')
                    stack.pop();
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                if (!stack.isEmpty() && c == '/' && stack.peek() == '/')
                    continue;
                stack.push(c);
            }
        }

        if (!stack.isEmpty() && stack.peek() == '/')
            stack.pop();
        if (stack.isEmpty()) return "/";
        while (!stack.isEmpty()) strBuffer.append(stack.pop());
        return strBuffer.reverse().toString();
    }
}

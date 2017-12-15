package com.aniket.ctci.stacksandsqueues;

import java.util.Stack;

public class ReverseString {

    /**
     * Given a string S, reverse the string using stack.
     * <p>
     * Example :
     * <p>
     * Input : "abc"
     * Return "cba"
     */

    public String reverseString(String a) {

        StringBuffer stringBuffer = new StringBuffer();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < a.length(); i++) stack.push(a.charAt(i));
        while (!stack.isEmpty()) stringBuffer.append(stack.pop().charValue());

        return stringBuffer.toString();
    }
}

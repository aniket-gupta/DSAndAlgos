package com.aniket.ctci.stacksandsqueues;

import java.util.HashMap;
import java.util.Stack;

public class RedundantBraces {

    /**
     * Write a program to validate if the input string has redundant braces?
     Return 0/1

     0 -> NO
     1 -> YES
     Input will be always a valid expression

     and operators allowed are only + , * , - , /

     Example:

     ((a + b)) has redundant braces so answer will be 1
     (a + (a + b)) doesn't have have any redundant braces so answer will be 0
      */

    // This problem can be solved by converting expression to postfix
    public static void main(String[] args) {
        String str = "(a/b)+(b*d)+(a*a)+a";//"(a + (a + b))";//"((a + b))";
        System.out.println(new RedundantBraces().braces(str));
    }

    public int braces(String a) {

        String ops = "+*-/()";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('(', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 3);
        map.put('-', 3);
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(c == ' ' || ops.indexOf(c) == -1) continue;
            else if(c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                char inStack = stack.pop().charValue();
                if(inStack == '(') return 1;
                while (inStack != '(') inStack = stack.pop();
            } else {
                while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(c) ) {
                    stack.pop();
                }
                stack.push(c);
            }



        }
        int count = 0;
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if(top == '(') count++;

        }

        if(count > 1) return 1;
        return 0;
    }
}

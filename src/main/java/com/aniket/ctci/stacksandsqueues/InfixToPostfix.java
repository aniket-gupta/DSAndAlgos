package com.aniket.ctci.stacksandsqueues;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        String str = "( A + B ) * C";//"A + B * C";
        System.out.println(new InfixToPostfix().infixToPostfix(str));
    }

    public String infixToPostfix(String exp) {
        String ops = "+*-/()";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('(', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 3);
        map.put('-', 3);

        StringBuffer stringBuffer = new StringBuffer();

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(ops.indexOf(c) == -1) stringBuffer.append(c);
            else if(c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                char inStack = stack.pop().charValue();
                while (inStack != '(') {
                    stringBuffer.append(inStack);
                    inStack = stack.pop();
                }
            } else {
                while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(c) ) {
                    stringBuffer.append(stack.pop());
                }
                stack.push(c);
            }



        }

        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());


        }

        return stringBuffer.toString();


    }
}

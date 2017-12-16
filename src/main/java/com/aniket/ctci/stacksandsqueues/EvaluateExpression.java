package com.aniket.ctci.stacksandsqueues;

import java.util.Stack;

public class EvaluateExpression {

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * <p>
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * <p>
     * Examples:
     * <p>
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */

    public int evalRPN(String[] A) {

        if (A == null || A.length < 1) return 0;

        Stack<String> stack = new Stack<String>();
        for (String str : A) {
            if (str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) {
                String b = stack.pop();
                String a = stack.pop();
                stack.push(eval(a, b, str));
            } else {
                stack.push(str);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private boolean isOp(String str) {
        return str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-");
    }

    private String eval(String str1, String str2, String op) {
        int a = Integer.parseInt(str1);
        int b = Integer.parseInt(str2);
        if (op.equals("*")) return String.valueOf(a * b);
        if (op.equals("/")) return String.valueOf(a / b);
        if (op.equals("+")) return String.valueOf(a + b);
        if (op.equals("-")) return String.valueOf(a - b);
        return null;
    }
}

package com.aniket.ctci.backtracking;

import com.aniket.ctci.stacksandsqueues.GenerateAllParentheses;

import java.util.*;

public class GenerateAllParenthesesII {

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
     * <p>
     * For example, given n = 3, a solution set is:
     * <p>
     * "((()))", "(()())", "(())()", "()(())", "()()()"
     * Make sure the returned list of strings are sorted.
     */

    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        GenerateAllParenthesesII obj = new GenerateAllParenthesesII();
        ArrayList<String> strings = obj.generateParenthesis(5);
        System.out.println(strings);
    }


    /**
     * Algorithm:
     * Keep track of counts of open and close brackets.
     * <p>
     * Initialize these counts as 0.
     * Recursively call the _printParenthesis() function until open bracket count is less than the given n.
     * If open bracket count becomes more than the close bracket count, then put a closing bracket and recursively call for the remaining brackets.
     * If open bracket count is less than n, then put an opening bracket and call _printParenthesis() for the remaining brackets.
     */

    public ArrayList<String> generateParenthesis(int A) {

        ArrayList<String> strings = new ArrayList<>();
        generateParenthesis(A, "", 0, 0, strings);
        Collections.sort(strings);
        return strings;
    }

    private void generateParenthesis(int n, String s, int open, int close, ArrayList<String> strings) {
        if (close == n) {
            strings.add(s);
        } else {
            if (open > close) {
                generateParenthesis(n, s + ")", open, close + 1, strings);
            }
            if (open < n) {
                generateParenthesis(n, s + "(", open + 1, close, strings);
            }
        }
    }


}

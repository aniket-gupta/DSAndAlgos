package com.aniket.ctci.backtracking;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {

    /**
     * Given a digit string, return all possible letter combinations that the number could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
     * <p>
     * <p>
     * <p>
     * The digit 0 maps to 0 itself.
     * The digit 1 maps to 1 itself.
     * <p>
     * Input: Digit string "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Make sure the returned strings are lexicographically sorted.
     */

    static String[] phoneStr = {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {

        ArrayList<String> strings = new LetterPhone().letterCombinations("2649");
        System.out.println(strings);
    }

    public ArrayList<String> letterCombinations(String A) {

        ArrayList<String> comb = new ArrayList<>();

        letterCombinations(A, 0, "", comb);

        return comb;

    }

    private void letterCombinations(String a, int i, String s, ArrayList<String> comb) {

        if (s.length() == a.length()) {
            comb.add(s);
        } else if (i >= a.length()) {
            return;
        } else {
            char c = a.charAt(i);
            String str = phoneStr[c - '0'];

            for (int index = 0; index < str.length(); index++) {
                letterCombinations(a, i + 1, s + str.charAt(index), comb);
            }
        }


    }
}

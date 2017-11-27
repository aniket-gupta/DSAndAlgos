package com.aniket.ctci.arrayandstring;

import java.util.ArrayList;

public class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
     * <p>
     * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
     * <p>
     * Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
     * <p>
     * Example:
     * <p>
     * Given the array as:
     * <p>
     * [
     * <p>
     * "abcdefgh",
     * <p>
     * "aefghijk",
     * <p>
     * "abcefgh"
     * ]
     * The answer would be “a”.
     */
    public String longestCommonPrefix(ArrayList<String> a) {
        int minLen = Integer.MAX_VALUE;
        for (String s : a) {
            if (minLen > s.length()) minLen = s.length();
        }
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < minLen; i++) {

            char c = a.get(0).charAt(i);
            int j = 1;
            for (; j < a.size(); j++) {
                if (a.get(j).charAt(i) != c)
                    break;
            }
            if (j == a.size())
                strBuffer.append(c);
            else
                break;

        }

        return strBuffer.toString();


    }
}

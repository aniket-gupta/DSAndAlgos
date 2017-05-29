package com.aniket.ctci.searching;


import java.util.Stack;

public class PatternMatching {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        System.out.println(new PatternMatching().kmpAlgo("abxabcabcaby", "abcaby"));
    }

    public int naiveMethod(String text, String patt){  // complexity O(mn)

        for (int i = 0; i <= text.length() - patt.length(); i++) { // (m -n) times

            int j = 0;
            for(; j < patt.length(); j++) {  // n times
                if(text.charAt(i+j) != patt.charAt(j)) {
                    break;
                }
            }

            if(j == patt.length()) {
                return i;
            }
        }
        return -1;
    }

    public int kmpAlgo(String text, String pattern) {

        if(pattern.length() < 2) {
            throw new IllegalArgumentException("Kmp Algo is not applicable for pattern length less than 2");
        }

        int[] lps = buidLPSArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length() && j < pattern.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }

        if(j == pattern.length()) {

            return Math.abs(i - pattern.length());
        }

        return  -1;

    }

    public int[] buidLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int len = 0;
        for(int i = 1; i < pattern.length();) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len-1];
                } else {
                    lps[i++] = 0;
                }
            }
        }

        return lps;

    }
}

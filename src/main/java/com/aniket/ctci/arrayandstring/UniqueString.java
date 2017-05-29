package com.aniket.ctci.arrayandstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * problem 1.1nnnnn
 */
public class UniqueString {

    // time complexity is O(n) and space O(n)
    public boolean isUnique(String str) {
        if(str == null || str.length() == 1) {
            return true;
        }
        HashSet<Character> charset = new HashSet<Character>();

        for(int i = 0; i < str.length(); i++) {
            char c  = str.charAt(i);
            if(charset.contains(c)) {
                return false;
            }
            charset.add(c);
        }
        return true;
    }

    // time complexity is O(n) and space O(n)
    public boolean isUnique1(String str) {
        if(str == null || str.length() == 1) {
            return true;
        }
        boolean[] charset = new boolean[256];
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(charset[c]) {
                return false;
            }
            charset[c] = true;
        }
        return true;
    }

    // O(n log n) + O(n) = O(n log n)
    public boolean isUnique2(String str) {
        if(str == null || str.length() == 1) {
            return true;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars); // O(n log n)

        for(int i = 0; i < chars.length - 1; i++) { // O(n)
            if(chars[i] == chars[i + 1]) {
                return false;
            }
        }

        return true;

    }

    // O(n) if chars are from [a..z]
    public boolean isUnique3(String str) {
        if(str == null || str.length() == 1) {
            return true;
        }
        int charmap = 1;
        for (int i = 0; i < str.length(); i++) {
            char c  = str.charAt(i);
            if( ((1 << c) & charmap) > 0  ) {
                return false;
            }
            charmap |= (1 << c);
        }
        return true;
    }

}

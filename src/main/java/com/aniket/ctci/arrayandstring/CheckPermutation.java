package com.aniket.ctci.arrayandstring;

import java.util.*;
import java.util.LinkedList;

/**
 * Problem 1.2
 */
public class CheckPermutation {

    // O(n) space O(n)
    public boolean checkPermutation(String str1, String str2) {

        if(str1.length() == str2.length()) {
            Map<Character, Integer> charFreqMap = new HashMap<Character, Integer>();
            for( char c : str1.toCharArray()) {
                if(charFreqMap.containsKey(c)) {
                    charFreqMap.put(c, charFreqMap.get(c) + 1);
                } else {
                    charFreqMap.put(c, 1);
                }
            }

            for( char c : str2.toCharArray()) {
                if(!charFreqMap.containsKey(c)) {
                    return false;
                }
                int freq = charFreqMap.get(c);
                if(freq <= 1) {
                    return false;
                }
                charFreqMap.put(c, freq - 1);
            }


            return true;

        }
        return false;
    }

    // O(n)
    public boolean checkPermutaion1(String str1, String str2) {
        if(str1.length() == str2.length()) {
            long sumOfChars = 0;
            for (char c : str1.toCharArray()) {
                sumOfChars += c;
            }
            for (char c : str2.toCharArray()) {
                sumOfChars -= c;
                if(sumOfChars < 0) {
                    return false;
                }
            }
            if(sumOfChars < 0 || sumOfChars > 0) {
                return false;
            }
            return true;

        }
        return false;
    }
}

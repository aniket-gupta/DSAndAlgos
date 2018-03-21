package com.aniket.ctci.hashing;

import java.util.HashMap;

public class WindowString {

    /**
     * t when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.
     * <p>
     * Example :
     * <p>
     * S = "ADOBECODEBANC"
     * T = "ABC"
     * Minimum window is "BANC"
     * <p>
     * Note:
     * If there is no such window in S that covers all characters in T, return the empty string ''.
     * If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
     */

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(new WindowString().minWindow(S, T));

    }

    public String minWindow(String A, String B) {

        int lenS = A.length();
        int lenT = B.length();

        if (lenS < lenT) return "";

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        int startIndex = -1;
        int minLen = A.length() + 1;
        int left = 0;

        for (int i = 0; i < lenT; i++) {
            char c = B.charAt(i);
            if (mapT.containsKey(c)) {
                mapT.put(c, mapT.get(c) + 1);
            } else mapT.put(c, 1);
        }
        int count = 0;
        for (int i = 0; i < lenS; i++) {
            char c = A.charAt(i);
            if (mapS.containsKey(c)) {
                mapS.put(c, mapS.get(c) + 1);
            } else mapS.put(c, 1);

            if (mapT.containsKey(c) && mapS.get(c) <= mapT.get(c)) count++;

            // if all the characters are matched
            if (count == lenT) {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.


                while (!mapT.containsKey(A.charAt(left)) || mapS.get(A.charAt(left)) > mapT.get(A.charAt(left))) {
                    if (!mapT.containsKey(A.charAt(left)) || mapS.get(A.charAt(left)) > mapT.get(A.charAt(left))) {
                        mapS.put(A.charAt(left), mapS.get(A.charAt(left)) - 1);
                        left++;
                    }
                }

                // update window size
                int lenWindow = i - left + 1;
                if (minLen > lenWindow) {
                    minLen = lenWindow;
                    startIndex = left;
                }
            }

        }

        //System.out.println(left + " " + startIndex + " " + minLen);


        return startIndex == -1 ? "" : A.substring(startIndex, startIndex + minLen);

    }


}

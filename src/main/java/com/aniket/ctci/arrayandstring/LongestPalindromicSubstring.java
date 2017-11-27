package com.aniket.ctci.arrayandstring;

public class LongestPalindromicSubstring {
    /**
     * Longest Palindromic Substring
     * Given a string S, find the longest palindromic substring in S.
     * <p>
     * Substring of string S:
     * <p>
     * S[i...j] where 0 <= i <= j < len(S)
     * <p>
     * Palindrome string:
     * <p>
     * A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
     * <p>
     * Incase of conflict, return the substring which occurs first ( with the least starting index ).
     * <p>
     * Example :
     * <p>
     * Input : "aaaabaaa"
     * Output : "aaabaaa"
     */

    public String longestPalindrome(String a) {

        int maxLen = 1;
        int startIndex = 0;

        for (int i = 1; i < a.length(); i++) {

            // for even len
            int low = i - 1;
            int high = i;

            while (low >= 0 && high < a.length() && a.charAt(low) == a.charAt(high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    startIndex = low;
                }
                low--;
                high++;
            }


            // for odd len
            low = i - 1;
            high = i + 1;

            while (low >= 0 && high < a.length() && a.charAt(low) == a.charAt(high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    startIndex = low;
                }
                low--;
                high++;
            }
        }

        return a.substring(startIndex, startIndex + maxLen);

    }
}

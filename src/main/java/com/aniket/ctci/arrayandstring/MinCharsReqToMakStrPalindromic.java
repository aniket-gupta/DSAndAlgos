package com.aniket.ctci.arrayandstring;

public class MinCharsReqToMakStrPalindromic {
    /**
     * Minimum Characters required to make a String Palindromic
     * You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string
     * <p>
     * Example:
     * Input: ABC
     * Output: 2
     * Input: AACECAAAA
     * Output: 2
     */

    public int solve(String A) {
        int count = 0;
        if (A != null && A.length() > 1) {
            int i = 0;
            int j = A.length() - 1;

            while (i < j) {
                if (A.charAt(i) == A.charAt(j) && isPalindrom(A, i, j)) {
                    break;
                }
                count++;
                j--;

            }

        }
        return count;
    }

    private boolean isPalindrom(String A, int i, int j) {
        while (i < j) {
            if (A.charAt(i) != A.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

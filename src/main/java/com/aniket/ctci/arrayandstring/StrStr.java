package com.aniket.ctci.arrayandstring;

public class StrStr {
    /**
     * Implement StrStr
     * Please Note:
     * <p>
     * Another question which belongs to the category of questions which are intentionally stated vaguely.
     * Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.
     * Try not to use standard library string functions for this question.
     * <p>
     * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * <p>
     * NOTE: Good clarification questions:
     * What should be the return value if the needle is empty?
     * What if both haystack and needle are empty?
     * For the purpose of this problem, assume that the return value should be -1 in both cases.
     */

    public int strStr(final String haystack, final String needle) {

        if (haystack == null || haystack.length() == 0) return -1;
        if (needle == null || needle.length() == 0) return -1;
        if (haystack.length() < needle.length()) return -1;

        if (needle.length() < 2) {
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    return i;
                }

            }
            return -1;
        } else {
            int[] lps = buidLPSArray(needle);
            int i = 0;
            int j = 0;
            while (i < haystack.length() && j < needle.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }

            if (j == needle.length()) {

                return Math.abs(i - needle.length());
            }

            return -1;
        }


    }

    private int[] buidLPSArray(final String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int len = 0;
        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }

        return lps;

    }
}

package com.aniket.ctci.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {

    /**
     * You are given a string, S, and a list of words, L, that are all of the same length.
     * <p>
     * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
     * <p>
     * Example :
     * <p>
     * S: "barfoothefoobarman"
     * L: ["foo", "bar"]
     * You should return the indices: [0,9].
     * (order does not matter).
     */

    public static void main(String[] args) {
        String A = "barfoothefoobarman";
        ArrayList<String> L = new ArrayList<>(Arrays.asList("foo", "bar"));

        System.out.println(new SubstringConcatenation().findSubstring(A, L));
    }

    public ArrayList<Integer> findSubstring(String A, final List<String> B) {

        ArrayList<Integer> res = new ArrayList<>();
        if (A == null || A.isEmpty() || B == null || B.isEmpty()) return res;
        int wordLen = B.get(0).length();
        int subStrLen = B.size() * wordLen;
        int strLen = A.length();

        if (strLen >= subStrLen) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String str : B) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else map.put(str, 1);
            }

            for (int i = 0; i <=strLen - subStrLen; i++) {

                String substring = A.substring(i, i + subStrLen);
                HashMap<String, Integer> tmpMap = (HashMap<String, Integer>) map.clone();

                for (int j = 0; j < substring.length(); j = j + wordLen) {
                    String word = substring.substring(j, j + wordLen);
                    if (!tmpMap.containsKey(word)) break;
                    int val = tmpMap.get(word);
                    if (val == 1) {
                        tmpMap.remove(word);
                    } else tmpMap.put(word, tmpMap.get(word) - 1);

                }

                if (tmpMap.isEmpty()) res.add(i);

            }
        }

        return res;
    }
}

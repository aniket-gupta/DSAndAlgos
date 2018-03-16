package com.aniket.ctci.hashing;

import java.util.*;

public class Anagrams {

    /**
     * Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
     * <p>
     * Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
     * Note: All inputs will be in lower-case.
     * Example :
     * <p>
     * Input : cat dog god tca
     * Output : [[1, 4], [2, 3]]
     * cat and tca are anagrams which correspond to index 1 and 4.
     * dog and god are another set of anagrams which correspond to index 2 and 3.
     * The indices are 1 based ( the first element has index 1 instead of index 0).
     */

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("god");
        list.add("tca");
        System.out.println(new Anagrams().anagrams(list));
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            char[] chars = A.get(i).toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(i + 1);
            } else {
                map.put(sortedStr, new ArrayList<>(Arrays.asList(i + 1)));
            }

        }

        for (ArrayList<Integer> list : map.values()) {
            res.add(list);
        }
        return res;
    }

}

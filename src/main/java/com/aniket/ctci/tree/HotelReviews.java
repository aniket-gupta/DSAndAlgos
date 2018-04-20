package com.aniket.ctci.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

public class HotelReviews {

    /**
     * Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.
     * <p>
     * Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.
     * <p>
     * You are expected to use Trie in an Interview for such problems
     * <p>
     * Constraints:
     * <p>
     * 1.   1 <= No.of reviews <= 200
     * 2.   1 <= No. of words in a review <= 1000
     * 3.   1 <= Length of an individual review <= 10,000
     * 4.   1 <= Number of Good Words <= 10,000
     * 5.   1 <= Length of an individual Good Word <= 4
     * 6.   All the alphabets are lower case (a - z)
     * Input:
     * <p>
     * S : A string S containing "Good Words" separated by  "_" character. (See example below)
     * R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
     * Output:
     * <p>
     * A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews.
     * <p>
     * V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
     * In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
     * Example:
     * <p>
     * Input:
     * S = "cool_ice_wifi"
     * R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]
     * <p>
     * Output:
     * ans = [2, 0, 1]
     * Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
     */

    public static void main(String[] args) {
        String s = "cool_ice_wifi";
        ArrayList<String> r = new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"));
        System.out.println(new HotelReviews().solve(s, r));
    }

    public ArrayList<Integer> solve(String goodWords, ArrayList<String> vector) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        String[] words = goodWords.split("_");
        for (String str : words) {
            set.add(str);
        }

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        for (int i = 0; i < vector.size(); i++) {
            int count = 0;
            String[] split = vector.get(i).split("_");
            for (String word : split) {
                if (set.contains(word)) count++;
            }
            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(i);
        }


        while (!map.isEmpty()) {
            Integer key = map.lastKey();
            ArrayList<Integer> integers = map.get(key);
            for (int integer : integers) {
                res.add(integer);
            }
            map.remove(key);

        }

        return res;

    }


}

package com.aniket.ctci.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Combinations {


    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
     * <p>
     * Make sure the combinations are sorted.
     * <p>
     * To elaborate,
     * <p>
     * Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
     * Entries should be sorted within themselves.
     * Example :
     * If n = 4 and k = 2, a solution is:
     * <p>
     * [
     * [1,2],
     * [1,3],
     * [1,4],
     * [2,3],
     * [2,4],
     * [3,4],
     * ]
     */
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<Integer> set = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        combine(A, B, 1, set, list);
        Collections.sort(list, (o1, o2) -> {
            if (o1.isEmpty()) return -1;
            if (o2.isEmpty()) return 1;
            int i = 0;
            int j = 0;
            while (i < o1.size() && j < o2.size()) {
                int a = o1.get(i);
                int b = o2.get(j);
                if (a == b) {
                    i++;
                    j++;
                } else {
                    return a - b;
                }
            }
            return 0;
        });
        return list;
    }

    private void combine(int n, int k, int i, ArrayList<Integer> set, ArrayList<ArrayList<Integer>> list) {
        if (i > n) {
            if (set.size() == k) {
                ArrayList<Integer> copy = new ArrayList<Integer>(set);
                list.add(copy);
            }

        } else if (set.size() == k) {
            ArrayList<Integer> copy = new ArrayList<Integer>(set);
            list.add(copy);
        } else {
            combine(n, k, i + 1, set, list);
            set.add(i);
            combine(n, k, i + 1, set, list);
            set.remove(set.size() - 1);
        }
    }
}

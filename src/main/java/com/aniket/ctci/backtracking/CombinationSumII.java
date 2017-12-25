package com.aniket.ctci.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSumII {

    /**
     * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     * <p>
     * Each number in C may only be used once in the combination.
     * <p>
     * Note:
     * All numbers (including target) will be positive integers.
     * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
     * The solution set must not contain duplicate combinations.
     * Example :
     * <p>
     * Given candidate set 10,1,2,7,6,1,5 and target 8,
     * <p>
     * A solution set is:
     * <p>
     * [1, 7]
     * [1, 2, 5]
     * [2, 6]
     * [1, 1, 6]
     */

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> comb = new ArrayList<>();
        combinationSum(A, B, 0, comb, list);
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

    private void combinationSum(ArrayList<Integer> A, int T, int index, ArrayList<Integer> comb, ArrayList<ArrayList<Integer>> list) {
        if (T == 0) {
            ArrayList<Integer> copy = new ArrayList<>(comb);
            Collections.sort(copy);
            if (!find(copy, list))
                list.add(copy);
        } else if (index >= A.size() || T < 0) return;
        else {
            combinationSum(A, T, index + 1, comb, list);
            comb.add(A.get(index));
            combinationSum(A, T - A.get(index), index + 1, comb, list);
            if (!comb.isEmpty()) {
                comb.remove(comb.size() - 1);
            }
        }
    }

    private boolean find(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> list) {
        for (ArrayList<Integer> arrList : list) {
            if (isEqual(A, arrList)) return true;
        }

        return false;
    }

    private boolean isEqual(ArrayList<Integer> A, ArrayList<Integer> B) {
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            int a = A.get(i);
            int b = B.get(j);
            if (a != b) return false;
            i++;
            j++;
        }

        if (i < A.size()) return false;
        if (j < B.size()) return false;
        return true;
    }
}

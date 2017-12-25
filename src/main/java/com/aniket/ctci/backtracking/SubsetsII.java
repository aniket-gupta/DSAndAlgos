package com.aniket.ctci.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SubsetsII {

    /**
     * Given a collection of integers that might contain duplicates, S, return all possible subsets.
     * <p>
     * Note:
     * Elements in a subset must be in non-descending order.
     * The solution set must not contain duplicate subsets.
     * The subsets must be sorted lexicographically.
     * Example :
     * If S = [1,2,2], the solution is:
     * <p>
     * [
     * [],
     * [1],
     * [1,2],
     * [1,2,2],
     * [2],
     * [2, 2]
     * ]
     */

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subsetList = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();

        Collections.sort(A);

        subsets(A, 0, subset, subsetList);
        Collections.sort(subsetList, (o1, o2) -> {
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
        return subsetList;


    }

    private void subsets(ArrayList<Integer> A, int k, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> subsetList) {
        if (k == A.size()) {
            ArrayList<Integer> list = new ArrayList<Integer>(subset);
            // Collections.sort(list);
            if (!find(list, subsetList))
                subsetList.add(list);
        } else {
            subsets(A, k + 1, subset, subsetList);
            subset.add(A.get(k));
            subsets(A, k + 1, subset, subsetList);
            subset.remove(subset.size() - 1);
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

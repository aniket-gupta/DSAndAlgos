package com.aniket.ctci.backtracking;

import java.util.ArrayList;

public class Permutations {

    /**
     * Given a collection of numbers, return all possible permutations.
     * <p>
     * Example:
     * <p>
     * [1,2,3] will have the following permutations:
     * <p>
     * [1,2,3]
     * [1,3,2]
     * [2,1,3]
     * [2,3,1]
     * [3,1,2]
     * [3,2,1]
     * NOTE
     * No two entries in the permutation sequence should be the same.
     * For the purpose of this problem, assume that all the numbers in the collection are unique.
     */

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList<ArrayList<Integer>> permute = obj.permute(list);
        System.out.println(permute);
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> perm = new ArrayList<>();
        permute(A, perm, res);
        return res;
    }

    private void permute(ArrayList<Integer> A, ArrayList<Integer> perm, ArrayList<ArrayList<Integer>> res) {
        if (perm.size() == A.size()) {
            res.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < A.size(); i++) {
                int val = A.get(i);
                if (!perm.contains(val)) {
                    perm.add(val);
                    permute(A, perm, res);
                    if (!perm.isEmpty()) {
                        perm.remove(perm.size() - 1);
                    }
                }

            }
        }
    }
}

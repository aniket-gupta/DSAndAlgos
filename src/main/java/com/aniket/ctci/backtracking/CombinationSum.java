package com.aniket.ctci.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {

    /**
     * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     * <p>
     * The same repeated number may be chosen from C unlimited number of times.
     * <p>
     * Note:
     * All numbers (including target) will be positive integers.
     * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
     * The combinations themselves must be sorted in ascending order.
     * CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
     * The solution set must not contain duplicate combinations.
     * Example,
     * Given candidate set 2,3,6,7 and target 7,
     * A solution set is:
     * <p>
     * [2, 2, 3]
     * [7]
     */

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(8);
        A.add(8);
        A.add(1);
        A.add(1);
        A.add(6);
        A.add(11);
        A.add(10);
        A.add(16);




        ArrayList<ArrayList<Integer>> arrayLists = new CombinationSum().combinationSum(A, 28);
        System.out.println(arrayLists);

    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> comb = new ArrayList<>();
        Collections.sort(A);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(A.get(0));
        for(int i = 1; i < A.size(); i++) {
            if(A.get(i) != A.get(i - 1)) temp.add(A.get(i));
        }
        combinationSum(temp, B, 0, comb, list);
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
        if(T == 0) {
            ArrayList<Integer> copy = new ArrayList<>(comb);
            list.add(copy);
        } else if(index >= A.size()) return;
        else if(T < 0) return;
        else {
            combinationSum(A, T, index+1, comb, list);
            comb.add(A.get(index));
            combinationSum(A, T - A.get(index) , index, comb, list);
            if(!comb.isEmpty()) {
                comb.remove(comb.size() - 1);
            }
        }
    }

    private boolean find(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> list) {
        for(ArrayList<Integer> arrList : list) {
            if(isEqual(A, arrList)) return true;
        }

        return false;
    }

    private boolean isEqual(ArrayList<Integer> A, ArrayList<Integer> B) {
        int i = 0;
        int j = 0;
        while(i < A.size() && j < B.size()){
            int a = A.get(i);
            int b = B.get(j);
            if(a != b) return false;
            i++;
            j++;
        }

        if(i < A.size()) return false;
        if(j < B.size()) return false;
        return true;
    }
}

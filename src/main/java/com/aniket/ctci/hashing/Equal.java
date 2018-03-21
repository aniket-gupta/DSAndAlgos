package com.aniket.ctci.hashing;

import java.util.*;

public class Equal {

    /**
     * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

     Note:

     1) Return the indices `A1 B1 C1 D1`, so that
     A[A1] + A[B1] = A[C1] + A[D1]
     A1 < B1, C1 < D1
     A1 < C1, B1 != D1, B1 != C1

     2) If there are more than one solutions,
     then return the tuple of values which are lexicographical smallest.

     Assume we have two solutions
     S1 : A1 B1 C1 D1 ( these are values of indices int the array )
     S2 : A2 B2 C2 D2

     S1 is lexicographically smaller than S2 iff
     A1 < A2 OR
     A1 = A2 AND B1 < B2 OR
     A1 = A2 AND B1 = B2 AND C1 < C2 OR
     A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
     Example:

     Input: [3, 4, 7, 1, 2, 9, 8]
     Output: [0, 2, 3, 5] (O index)
     */

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8));
        System.out.println(new Equal().equal(integers));
    }

    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> sumIdxes = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = i+1; j < A.size(); j++) {
                int sum = A.get(i) + A.get(j);
                if (sumIdxes.get(sum) != null) {
                    List<Integer> newres = new ArrayList<>(sumIdxes.get(sum));
                    if (!newres.contains(i) && !newres.contains(j)) {
                        newres.add(i);
                        newres.add(j);
                        checkAndSetRes(res, newres);
                    }
                    continue;
                }
                List<Integer> idxs = new ArrayList<>();
                idxs.add(i);
                idxs.add(j);
                sumIdxes.put(sum, idxs);
            }
        }

        return res;
    }

    private void checkAndSetRes(List<Integer> res, List<Integer> newres) {
        if (res.isEmpty() || (newres.get(0) < res.get(0)) ||
                (newres.get(0) == res.get(0) && newres.get(1) < res.get(1)) ||
                (newres.get(0) == res.get(0) && newres.get(1) == res.get(1) &&
                        newres.get(2) < res.get(2)) ||
                (newres.get(0) == res.get(0) && newres.get(1) == res.get(1) &&
                        newres.get(2) == res.get(2) && newres.get(3) < res.get(3))) {
            res.clear();
            res.addAll(newres);
        }
    }
}

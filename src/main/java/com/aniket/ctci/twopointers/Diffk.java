package com.aniket.ctci.twopointers;

public class Diffk {

    /**
     * Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

     Example: Input :
     A : [1 3 5]
     k : 4
     Output : YES as 5 - 1 = 4
     Return 0 / 1 ( 0 for false, 1 for true ) for this problem

     Try doing this in less than linear space complexity.
     */

    public boolean diffPossible(int[] A, int B) {

        if (A.length < 2 || B < 0) return false;
        int j = 0, len = A.length;
        for (int i = 0; i < len - 1; i++) {
            j = Math.max(j, i + 1);
            while (j < len && A[j] - A[i] < B) j += 1;
            if (j < len && A[j] - A[i] == B) return true;
        }
        return false;

    }
}

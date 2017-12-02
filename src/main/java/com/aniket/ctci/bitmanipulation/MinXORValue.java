package com.aniket.ctci.bitmanipulation;

import java.util.Arrays;

public class MinXORValue {

    /**
     * Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
     * <p>
     * Examples :
     * Input
     * 0 2 5 7
     * Output
     * 2 (0 XOR 2)
     * Input
     * 0 4 7 9
     * Output
     * 3 (4 XOR 7)
     * <p>
     * Constraints:
     * 2 <= N <= 100 000
     * 0 <= A[i] <= 1 000 000 000
     */

    public int findMinXor(int[] A) {

        int min = Integer.MAX_VALUE;

        Arrays.sort(A);

        for (int i = 0; i < A.length - 1; i++) {
            int val = A[i] ^ A[i + 1];
            if (min > val) {
                min = val;
            }
        }

        return min;
    }
}

package com.aniket.ctci.twopointers;

import java.util.Arrays;

public class ThreeSum {

    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
     * Return the sum of the three integers.
     * <p>
     * Assume that there will only be one solution
     * <p>
     * Example:
     * given array S = {-1 2 1 -4},
     * and target = 1.
     * <p>
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
     */

    public static void main(String[] args) {
        int[] A = { 10, -6, 3, 4, -8, -5 };
        System.out.println(new ThreeSum().threeSumClosest(A, 3));
    }

    public int threeSumClosest(int[] A, int B) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 1; j < A.length - 1; j++) {
                for (int k = j+1; k < A.length; k++) {
                    int sum = A[i] + A[j] + A[k];
                    int diff = Math.abs(B - sum);
                    if (diff == 0) return sum;
                    if (diff < min) {
                        min = diff;
                        result = sum;
                    }
                }
            }
        }

        return result;
    }
}

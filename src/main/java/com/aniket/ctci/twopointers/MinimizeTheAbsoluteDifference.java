package com.aniket.ctci.twopointers;

public class MinimizeTheAbsoluteDifference {

    /**
     * Minimize the absolute difference
     * Given three sorted arrays A, B and Cof not necessarily same sizes.
     * <p>
     * Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
     * i.e. minimize | max(a,b,c) - min(a,b,c) |.
     * <p>
     * Example :
     * <p>
     * Input:
     * <p>
     * A : [ 1, 4, 5, 8, 10 ]
     * B : [ 6, 9, 15 ]
     * C : [ 2, 3, 6, 6 ]
     * Output:
     * <p>
     * 1
     * Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
     */

    /**
     * Efficient Solution Let ‘p’ be size of A[], ‘q’ be size of B[] and ‘r’ be size of C[]
     * <p>
     * 1)   Start with i=0, j=0 and k=0 (Three index variables for A,
     * B and C respectively)
     * <p>
     * //  p, q and r are sizes of A[], B[] and C[] respectively.
     * 2)   Do following while i < p and j < q and k < r
     * a) Find min and maximum of A[i], B[j] and C[k]
     * b) Compute diff = max(X, Y, Z) - min(A[i], B[j], C[k]).
     * c) If new result is less than current result, change
     * it to the new result.
     * d) Increment the pointer of the array which contains
     * the minimum.
     * Note that we increment the pointer of the array which has the minimum, because our goal is to decrease the difference. Increasing the maximum pointer increases the difference. Increase the second maximum pointer can potentially increase the difference.
     */

    public static void main(String[] args) {
        int[] A = {1, 4, 5, 8, 10};
        int[] B = {6, 9, 15};
        int[] C = {2, 3, 6, 6};
        System.out.println(new MinimizeTheAbsoluteDifference().solve(A, B, C));
    }

    public int solve(int[] A, int[] B, int[] C) {
        int diff = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < A.length && j < B.length && k < C.length) {
            int min = min(A[i], B[j], C[k]);
            int max = max(A[i], B[j], C[k]);
            if (max - min < diff) {
                diff = max - min;
            }

            if (diff == 0) break;

            if (A[i] == min) i++;
            else if (B[j] == min) j++;
            else k++;
        }

        return diff;

    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}

package com.aniket.ctci.twopointers;

public class Array3Pointers {

    /**
     * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
     * <p>
     * Find i, j, k such that :
     * max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
     * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
     * <p>
     * *abs(x) is absolute value of x and is implemented in the following manner : **
     * <p>
     * if (x < 0) return -x;
     * else return x;
     * Example :
     * <p>
     * Input :
     * A : [1, 4, 10]
     * B : [2, 15, 20]
     * C : [10, 12]
     * <p>
     * Output : 5
     * With 10 from A, 15 from B and 10 from C.
     */

    /**
     * Solution Approach
     * Windowing strategy works here.
     * Lets say the arrays are A,B and C.
     * <p>
     * Take 3 pointers X, Y and Z
     * Initialize them to point to the start of arrays A, B and C
     * Find min of X, Y and Z.
     * Compute max(X, Y, Z) - min(X, Y, Z).
     * If new result is less than current result, change it to the new result.
     * Increment the pointer of the array which contains the minimum.
     * Note that we increment the pointer of the array which has the minimum, because our goal is to decrease the difference. Increasing the maximum pointer is definitely going to increase the difference. Increase the second maximum pointer can potentially increase the difference ( however, it certainly will not decrease the difference ).
     */

    public int minimize(final int[] A, final int[] B, final int[] C) {

        int i = 0, j = 0, k = 0;
        int sol = Integer.MAX_VALUE;
        int temp, temp1, temp2, temp3;

        while (i < A.length || j < B.length || k < C.length) {
            sol = Math.min(sol, checkMax(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])));

            if (i + 1 < A.length) {
                temp1 = checkMax(abs(A[i + 1] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i + 1]));
            } else {
                temp1 = Integer.MAX_VALUE;
            }
            if (j + 1 < B.length) {
                temp2 = checkMax(abs(A[i] - B[j + 1]), abs(B[j + 1] - C[k]), abs(C[k] - A[i]));
            } else {
                temp2 = Integer.MAX_VALUE;
            }
            if (k + 1 < C.length) {
                temp3 = checkMax(abs(A[i] - B[j]), abs(B[j] - C[k + 1]), abs(C[k + 1] - A[i]));
            } else {
                temp3 = Integer.MAX_VALUE;
            }

            temp = Math.min(temp1, temp2);
            temp = Math.min(temp, temp3);

            if (temp == Integer.MAX_VALUE) {
                return sol;
            } else if (temp == temp1) {
                i++;
            } else if (temp == temp2) {
                j++;
            } else {
                k++;
            }

        }


        return sol;
    }

    private int checkMax(int a, int b, int c) {
        int max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }

        return max;
    }

    private int abs(int x) {
        if (x < 0) return -x;
        else return x;
    }
}

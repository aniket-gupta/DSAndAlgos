package com.aniket.ctci.heapsandmaps;

import java.util.HashMap;

public class DistinctNumbersInWindow {

    /**
     * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.
     *
     * Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
     *
     * Note:
     *
     * If K > N, return empty array.
     * For example,
     *
     * A=[1, 2, 1, 3, 4, 3] and K = 3
     *
     * All windows of size K are
     *
     * [1, 2, 1]
     * [2, 1, 3]
     * [1, 3, 4]
     * [3, 4, 3]
     *
     * So, we return an array [2, 3, 3, 2].
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3};
        int K = 3;
        int[] ints = dNums(A, K);
        for (int n : ints) {
            System.out.print(n + " ");
        }
    }

    public static int[] dNums(int[] A, int K) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int numDistinct = 0;

        int[] res = new int[A.length - K + 1];

        int index = 0;
        for (int i = 0; i < K; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
                numDistinct++;
            }
        }

        res[index++] = numDistinct;

        for (int i = K; i < A.length; i++) {

            if(map.get(A[i - K]) == 1) {
                map.remove(A[i - K]);
                numDistinct--;
            } else {
                map.put(A[i - K], map.get(A[i - K]) - 1);
            }

            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
                numDistinct++;
            }

            res[index++] = numDistinct;

        }

        return res;

    }
}

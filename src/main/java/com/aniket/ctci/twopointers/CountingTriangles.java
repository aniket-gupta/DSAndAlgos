package com.aniket.ctci.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingTriangles {

    /**
     * You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
     * Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can form using these array values.
     * <p>
     * Notes:
     * <p>
     * You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn’t matter. Any triangle formed should have a positive area.
     * <p>
     * Return answer modulo 109 + 7.
     * <p>
     * For example,
     * <p>
     * A = [1, 1, 1, 2, 2]
     * <p>
     * Return: 4
     */

    /**
     * Solution Approach
     * First we sort the array of side lengths. So since Ai < Aj < Ak where i < j < k, therefore it is sufficient to check Ai + Aj > Ak to prove they form a triangle.
     * <p>
     * Thus for every i and j, we can find the maximum value of k such that the triangle inequality holds.
     * Also we can also prove that for every such index i, we only have to increase the value of the k (satisfying the above condition) for every iteration of j from i+1 to n. Therefore, we get a O(n2) solution (Proof of this is left to the reader).
     */

    public int nTriang(ArrayList<Integer> A) {
        if (A == null) return 0;
        int S[] = new int[A.size()];
        for (int i = 0; i < A.size(); i++)
            S[i] = A.get(i);
        Arrays.sort(S);
        long count = 0;
        for (int i = 0; i < S.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    // The edge from S[left] to S[right - 1] will also form a triangle
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }

        }
        count %= 1000000007;
        return (int) count;
    }
}

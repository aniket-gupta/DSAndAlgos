package com.aniket.ctci.twopointers;

public class ContainerWithMostWater {
    /**
     * Given n non-negative integers a1, a2, ..., an,
     * where each represents a point at coordinate (i, ai).
     * 'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * <p>
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * <p>
     * Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).
     * <p>
     * Note: You may not slant the container.
     * Example :
     * <p>
     * Input : [1, 5, 4, 3]
     * Output : 6
     * <p>
     * Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
     * So total area = 3 * 2 = 6
     */

    /**
     * Access Hint
     * Note 1: When you consider a1 and aN, then the area is (N-1) * min(a1, aN).
     * Note 2: The base (N-1) is the maximum possible.
     * This implies that if there was a better solution possible, it will definitely have height greater than min(a1, aN).
     * <p>
     * B * H > (N-1) * min(a1, aN)
     * We know that, B < (N-1)
     * So, H > min(a1, aN)
     * <p>
     * This means that we can discard min(a1, aN) from our set and look to solve this problem again from the start.
     * If a1 < aN, then the problem reduces to solving the same thing for a2, aN.
     * Else, it reduces to solving the same thing for a1, aN-1
     */

    public int maxArea(int[] A) {

        int max = 0;
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(A[start], A[end]));
            if (A[start] < A[end])
                start++;
            else
                end--;
        }
        return max;
    }
}

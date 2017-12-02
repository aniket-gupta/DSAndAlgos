package com.aniket.ctci.bitmanipulation;

public class SingleNumber {

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     * <p>
     * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * Example :
     * <p>
     * Input : [1 2 2 3 1]
     * Output : 3
     */

    /**
     * Solution Approach
     * We have noticed that if X has 1 in that position, we will have odd number of 1s in that position.
     * <p>
     * If X has 0 in that position, we will have odd number of 0 in that position.
     * <p>
     * If you look at the bit operators, XOR is exactly what we need.
     * <p>
     * XOR will return 1 only on two different bits. So if two numbers are the same, XOR will return 0.
     * <p>
     * Finally, there is only one number left.
     * <p>
     * A ^ A = 0 and A ^ B ^ A = B.
     * <p>
     * So, all even occurences will cancel out using XOR.
     */
    public int singleNumber(final int[] A) {
        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }
}

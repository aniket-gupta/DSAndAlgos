package com.aniket.ctci.bitmanipulation;

public class DivideIntegers {

    /**
     * Divide two integers without using multiplication, division and mod operator.
     * <p>
     * Return the floor of the result of the division.
     * <p>
     * Example:
     * <p>
     * 5 / 2 = 2
     * Also, consider if there can be overflow cases. For overflow case, return INT_MAX.
     */

    /**
     * Solution approach
     * 1. How do you do the division with bits?
     * <p>
     * How do you determine the most significant bit in the answer?
     * Iterate on the bit position ‘i’ from 31 to 1 and find the first bit for which divisor«i is less than dividend.
     * <p>
     * How do you use (1) to move forward in similar fashion?
     */

    public static void main(String[] args) {
        System.out.println(new DivideIntegers().divide(-2147483648, 3));
    }

    public int divide(int dividend, int divisor) {
        long n = dividend;
        long m = divisor;

        // determine sign of the quotient
        int sign = n < 0 ^ m < 0 ? -1 : 1;
        // remove sign of operands
        n = Math.abs(n);
        m = Math.abs(m);

        // q stores the quotient in computation
        long q = 0;
        long t = 0;
        for (int i = 31; i >= 0; i--) {
            if (t + (m << i) <= n) {
                t += m << i;
                q |= 1L << i;
            }
        }

        // assign back the sign
        if (sign < 0) q = -q;
        // check for overflow and return
        return q >= Integer.MAX_VALUE || q < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) q;


    }


}

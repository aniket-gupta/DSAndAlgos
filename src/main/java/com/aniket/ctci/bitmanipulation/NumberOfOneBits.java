package com.aniket.ctci.bitmanipulation;

public class NumberOfOneBits {

    /**
     * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
     * <p>
     * Example:
     * <p>
     * The 32-bit integer 11 has binary representation
     * <p>
     * 00000000000000000000000000001011
     * so the function should return 3.
     */

    public int numSetBits(long a) {
        int count = 0;
        while (a != 0) {
            if ((a & 1) == 1) count++;
            a >>= 1;
        }

        return count;
    }
}

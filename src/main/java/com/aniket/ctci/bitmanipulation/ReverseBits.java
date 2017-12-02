package com.aniket.ctci.bitmanipulation;

import java.util.BitSet;

public class ReverseBits {

    /**
     * Reverse bits of an 32 bit unsigned integer
     * <p>
     * Example 1:
     * <p>
     * x = 0,
     * <p>
     * 00000000000000000000000000000000
     * =>        00000000000000000000000000000000
     * return 0
     * <p>
     * Example 2:
     * <p>
     * x = 3,
     * <p>
     * 00000000000000000000000000000011
     * =>        11000000000000000000000000000000
     * return 3221225472
     * <p>
     * Since java does not have unsigned int, use long
     */

    public static void main(String[] args) {

        System.out.println(new ReverseBits().reverse(4294967295L));
        System.out.println(new ReverseBits().reverse1(4294967295L));

    }

    public long reverse(long a) {
        long n = 0;
        int noOfBit = 31;
        while (a != 0 && noOfBit > 0) {
            if ((a & 1) == 1) {
                long val = (((long) 1) << noOfBit);
                n |= val;
            }
            a >>= 1;
            noOfBit--;
        }

        if (a != 0) {
            n |= a;
//            System.out.println(a);
        }

//        System.out.println(Long.toBinaryString(n));


        return n;
    }

    public long reverse1(long A) {
        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((A & (1 << i)) != 0)
                rev |= 1;
        }

        return rev;

    }
}

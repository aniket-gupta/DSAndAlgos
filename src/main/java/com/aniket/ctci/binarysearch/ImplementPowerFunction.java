package com.aniket.ctci.binarysearch;

public class ImplementPowerFunction {

    /**
     * Implement pow(x, n) % d.

     In other words, given x, n and d,

     find (x^n % d)

     Note that remainders on division cannot be negative.
     In other words, make sure the answer you return is non negative.

     Input : x = 2, n = 3, d = 3
     Output : 2

     2^3 % 3 = 8 % 3 = 2.
     */

    public static int pow(int x, int n, int d) {

        if(x == 0) return 0;
        if(n == 0) return 1;


        long result = 1;

         long temp = x % d;


        while(n > 0) {
            if(n % 2 != 0) {
                result = ((temp * result) % d);
            }

            n = n/2;
            temp = ( temp * temp ) % d;
        }

        if(result < 0) result += d;

        return (int) result;

    }

    public static void main(String[] args) {
        System.out.println(pow(71045970, 41535484, 64735492));
    }
}

package com.aniket.ctci.binarysearch;

/**
 * Created by AnGupta on 7/29/17.
 */
public class SquareRootOfInteger {

    /**
     * Implement int sqrt(int x).

         Compute and return the square root of x.

         If x is not a perfect square, return floor(sqrt(x))
         Example :
         Input : 11
         Output : 3
         DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
     */

    public static void main(String[] args) {

       int a = 2147483647;
        System.out.println(sqrt(2147483647));
        System.out.println((int) Math.floor(Math.sqrt(a)));
    }

    public static int sqrt(int x) {
        // Base cases
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        int start = 1, end = x/2, ans = 0;
        while (start <= end)
        {
            int mid = (start + end) / 2;

            long sqr = (long) mid * (long) mid;
            // If x is a perfect square
            if (sqr == x)
                return mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)

            if (sqr < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else // If mid*mid is greater than x
                end = mid - 1;
        }
        return ans;

    }
}

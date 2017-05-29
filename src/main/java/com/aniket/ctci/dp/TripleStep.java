package com.aniket.ctci.dp;

/**
 * Created by AnGupta on 2/27/17.
 */
public class TripleStep {

    public static void main(String[] args) {
        System.out.println(countWaysDP(4));
    }

    public static int countWays(int n) {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;

        return countWays(n-1) + countWays(n-2) + countWays(n - 3);

    }

    public static int countWaysDP(int n) {
        int[] memo = new int[n + 1];
        return countWaysDP(n , memo);

    }

    private static int countWaysDP(int n, int[] memo) {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        if(memo[n] > 1) {
            return memo[n];
        }

        memo[n] = countWays(n-1) + countWays(n-2) + countWays(n - 3);
        return memo[n];
    }


}

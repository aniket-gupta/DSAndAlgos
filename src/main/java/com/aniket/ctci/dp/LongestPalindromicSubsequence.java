package com.aniket.ctci.dp;

/**
 * Created by AnGupta on 5/12/17.
 */
public class LongestPalindromicSubsequence {

    public static int lps(char[] s, int i , int j, int[][] dp) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
//        if(i == j) {
//            dp[i][j] = 1;
//            return dp[i][j];
//        }

        if(s[i] == s[j] && i+1 == j) {
            dp[i][j] = 2;
            return dp[i][j];
        }

        if(s[i] == s[j]) {
            dp[i][j] =   2 + lps(s, i+1, j-1, dp);
            return dp[i][j];
        }

        dp[i][j] =  Math.max(lps(s, i, j-1, dp), lps(s, i+1, j, dp));
        return dp[i][j];
    }


    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        System.out.println(lps(s.toCharArray(), 0, s.length() - 1, dp));
    }
}

package com.aniket.ctci.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AnGupta on 3/25/17.
 */
public class CountThePathInGrid {

    /**
     * You are given a grid of cells with size N rows by M columns. A robot is situated at the bottom-left cell (row N-1, column 0). It can move from cell to cell but only to the right and to the top. Some cells are empty and the robot can pass through them but others are not and the robot cannot enter such cells. The robot cannot go outside the grid boundaries.
     * <p>
     * The robot has a goal to reach top-right cell (row 0, column M-1). Both the start and end cells are always empty. You need to compute the number of different paths that the robot can take from start to end. Only count paths that visit empty cells and move only to the right and up.
     * <p>
     * N and M will be numbers in the range [1, 512].
     * <p>
     * Write a method, which accepts the grid as an argument and returns one integer - the total number of different paths that the robot can take from the start to the end cell, MODULO 1,000,003. The reason we will use the modulo operation here is that the actual result could become a really big number and we don't want to let handling big numbers complicate the task more.
     * <p>
     * The input grid will contain N strings with M characters each - either '0' or '1', with '0' meaning an empty cell and '1' meaning an occupied cell. Each of these strings corresponds to a row in the grid.
     */

    public static void main(String[] args) {

        String s  = "000";
        List<String> grid = new ArrayList<String>();
        grid.set(0, "a");
//        grid.add(s);
//        grid.add(s);
//        grid.add(s);
//        System.out.println(count_the_paths(grid));
    }

    public static int count_the_paths(List<String> grid) {
        int[][] dp = new int[grid.size()][grid.get(0).length()];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return count_the_paths(grid, dp, 0, grid.get(0).length() - 1);
    }

    public static int count_the_paths(List<String> grid, int[][] dp, int N, int M) {

        if (N < 0 || M < 0 || N >= grid.size() || M >= grid.get(0).length()) {
            return 0;
        }
        if(dp[N][M] != -1) {
            return dp[N][M];
        }

        if (N == grid.size() - 1 && M == 0) {
            dp[N][M] = 1;
            return dp[N][M];
        }

        if (grid.get(N).charAt(M) == '1') {
            dp[N][M] = 0;
            return dp[N][M];
        }

        dp[N][M] = (count_the_paths(grid, dp, N + 1, M) +

                count_the_paths(grid, dp, N, M - 1)) % 1000003;
        return dp[N][M];


    }
}

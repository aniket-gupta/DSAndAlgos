package com.aniket.ctci.backtracking;

import java.util.ArrayList;

public class NQeens {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * <p>
     * Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
     * <p>
     * For example,
     * There exist two distinct solutions to the 4-queens puzzle:
     * <p>
     * [
     * [".Q..",  // Solution 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // Solution 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     */

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> arrayLists = new NQeens().solveNQueens(4);
        for (ArrayList<String> ans : arrayLists) {
            for (String str : ans) {
                System.out.println(str);
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<String>> solveNQueens(int n) {

        int[][] A = new int[n][n];

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        nQueens(A, 0, n, res);
        return res;

    }

    private void nQueens(int[][] A, int k, int n, ArrayList<ArrayList<String>> res) {

        if (k == n) {

            ArrayList<String> strings = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][j] != 0) stringBuilder.append('Q');
                    else stringBuilder.append('.');
                }
                strings.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }

            res.add(strings);
        } else {
            for (int i = 0; i < n; i++) {
                if (isValidMove(A, k, i, n)) {
                    A[k][i] = k + 1;
                    nQueens(A, k + 1, n, res);
                    A[k][i] = 0;
                }

            }
        }

    }


    public boolean isValidMove(int[][] A, int row, int col, int n) {
        // check column not crossing
        for (int i = 0; i < row; i++) {
            if (A[i][col] != 0) return false;
        }

        // check row not crossing
        for (int j = 0; j < col; j++) {
            if (A[row][j] != 0) return false;
        }

        // check left diagonal
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (A[i--][j--] != 0) return false;
        }

        // check right diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (A[i--][j++] != 0) return false;
        }

        return true;

    }
}

package com.aniket.ctci.arrayandstring;

/**
 * problem 1.8
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        int A[][] = {
                {10, 20, 30, 40, 50},
                {11, 21, 31, 41, 51},
                {12, 22, 0, 42, 52},
                {13, 0, 33, 43, 53},
                {14, 24, 34, 44, 54}
        };

        print(A);

        new ZeroMatrix().zeroMatrix(A);

        System.out.println("===========");
        print(A);
    }

    public void zeroMatrix(int[][] A) {

        boolean[] rowHasZero = new boolean[A.length];
        boolean[] colHasZero = new boolean[A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    rowHasZero[i] = true;
                    colHasZero[j] = true;
                }
            }
        }

        // make row zero
        for (int i = 0; i < rowHasZero.length; i++) {
            if (rowHasZero[i]) makeRowZero(A, i);
        }

        // make col zero

        for (int i = 0; i < colHasZero.length; i++) {
            if (colHasZero[i]) makeColumnZero(A, i);
        }
    }

    private void makeRowZero(int[][] A, int row) {
        for (int i = 0; i < A[0].length; i++) {
            A[row][i] = 0;
        }
    }

    private void makeColumnZero(int[][] a, int col) {
        for (int i = 0; i < a.length; i++) {
            a[i][col] = 0;
        }
    }

    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

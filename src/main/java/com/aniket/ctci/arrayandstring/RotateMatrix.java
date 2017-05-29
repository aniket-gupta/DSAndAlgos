package com.aniket.ctci.arrayandstring;

/**
 * problem 1.7
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int A[][] = {
                {10, 20, 30, 40, 50},
                {11, 21, 31, 41, 51},
                {12, 22, 32, 42, 52},
                {13, 23, 33, 43, 53},
                {14, 24, 34, 44, 54}
        };

        print(A);

        new RotateMatrix().rotate(A);

        System.out.println("======= After Rotation =======");

        print(A);
    }

    private static void print(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void rotate(int A[][]) {
        int n = A.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i -1; j++) {
                int temp = A[i][j];
                A[i][j] = A[n - j - 1][i];
                A[n - j - 1][i] = A[n - i - 1][n - j - 1];
                A[n - i - 1][n - j - 1] = A[j][n - i - 1];
                A[j][n - i - 1] = temp;
            }
        }
    }
}

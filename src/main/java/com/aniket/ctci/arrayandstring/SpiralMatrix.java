package com.aniket.ctci.arrayandstring;


import java.util.Collections;

public class SpiralMatrix {

    public static void main(String[] args) {
        int a[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printInSpiralWay(a);

        a  = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println();
        printInSpiralWay(a);

        System.out.println();
        decorate(3);


    }

    public static void printInSpiralWay(int a[][]) {

        if(a == null) return;

        int top = 0;
        int down = a.length - 1;
        int left = 0;
        int right = a[0].length - 1;
        int direction = 0;

        while (left <= right && top <= down) {

//            System.out.println("print left to right");
            if(direction == 0) {
                for(int i = left; i <= right; i++) {
                    System.out.print(a[top][i] + " ");
                }
                top++;
                direction = 1;
            }


//            System.out.println("print top to down");
            else if(direction == 1) {
                for (int i = top; i <= down; i++) {
                    System.out.print(a[i][right] + " ");
                }
                right--;
                direction = 2;
            }


//            System.out.println("print right to left");
            else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    System.out.print(a[down][i] + " ");
                }
                down--;
                direction = 3;
            }

//            System.out.println("print down to top");
            else if(direction == 3) {
                for (int i = down; i >= top; i--) {
                    System.out.print(a[i][left] + " ");
                }
                left++;
                direction = 0;
            }
        }
    }


    /** print matrix as below when n  = 4
     4 4 4 4 4 4 4
     4 3 3 3 3 3 4
     4 3 2 2 2 3 4
     4 3 2 1 2 3 4
     4 3 2 2 2 3 4
     4 3 3 3 3 3 4
     4 4 4 4 4 4 4
     * @param n
     */
    public static void decorate(int n) {
        int[][] a = new int[2 * n -1][2 * n -1];
        int top = 0;
        int bottom = 2 * n - 2;
        int left = 0;
        int right = 2 * n - 2;
        int dir = 0;

        while ( top <= bottom && left <= right && n >= 1) {

            if(dir == 0) { // left -> right
                for(int i = left; i<= right; i++) {
                    a[top][i] = n;
                }
                top++;
                dir = 1;
            }

            else if (dir == 1) { // top -> bottom
                for (int i = top; i <= bottom; i++) {
                    a[i][right] = n;
                }
                right--;
                dir = 2;
            }

            else if (dir == 2) { // right -> left
                for (int i = right; i >= left; i--) {
                    a[bottom][i] = n;
                }
                bottom--;
                dir = 3;
            }

            else if (dir == 3) { // bottom -> top
                for (int i = bottom; i >= top; i--) {
                    a[i][left] = n;
                }
                left++;
                dir = 0;
                n--;
            }

        }

        // print matrix

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.println();
        }


    }


}

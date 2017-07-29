package com.aniket.ctci.binarysearch;

/**
 * Created by AnGupta on 7/29/17.
 */
public class MatrixMedian {

    /**
     * Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.
     * For example,
     * Matrix=
         [1, 3, 5]
         [2, 6, 9]
         [3, 6, 9]

        A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

        Median is 5. So, we return 5.
     */

    /**
        Solution approach
        Point to be noted that each row is sorted. Binary Search can be used.
        We can find min num and max num by comparing first col and last col. So range is [min, max]
        Median num is lies between [min, max] and median num will be greater that count(num)/2 numbers
        So task is to find number which is greater than half of the element and lies in between [min, max]

     */


    public static int findMedian(int[][] A) {

        if(A == null || A.length == 0) return -1;

        // find range :  min and max values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if(A[i][0] < min) min = A[i][0];
            if(A[i][A[i].length - 1] > max) max = A[i][A[i].length - 1];
        }

        // find target number of elements from which median val should be greater
        // M*N is number of element in Matrix
        int target = (A.length * A[0].length + 1) / 2;

        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                count += upperBound(A[i], mid);
            }
            if(count < target) min = mid + 1;
            else max = mid;
        }

        return min;

    }

    // return first element in A which is greater that target
    private static int upperBound(int[] A, int target) {
        int max = A.length;
        int min = -1;
        while (max - min > 1) {
            int mid = ( max + min ) / 2;
            if(A[mid] <= target) {
                min = mid;
            } else {
                max = mid;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        //[1, 3, 5]
//         [2, 6, 9]
//         [3, 6, 9]
        int[][] A = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        System.out.println(findMedian(A));

    }

}

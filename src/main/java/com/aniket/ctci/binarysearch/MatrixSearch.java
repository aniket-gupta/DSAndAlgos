package com.aniket.ctci.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by AnGupta on 8/3/17.
 */
public class MatrixSearch {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:
     *  1. Integers in each row are sorted from left to right.
     *  2. The first integer of each row is greater than or equal to the last integer of the previous row.
     *  Example:
     *      Consider the following matrix:
     *      [
                [1,   3,  5,  7],
                [10, 11, 16, 20],
                [23, 30, 34, 50]
            ]
            Given target = 3, return 1 ( 1 corresponds to true )
       Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
     */


    public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

        if(a == null || a.size() == 0) return 0;

        int row = a.size() - 1;
        int col = a.get(0).size() - 1;

        // find the row index where element can be present

        int start = 0;
        int end = row;
        while(start <= end && end >= 0 && start <= row) {

            int mid = start + (end - start) / 2;
            if(a.get(mid).get(col) == b) return 1;
            else if(a.get(mid).get(col) > b) end = mid - 1;
            else start = mid + 1;
        }

        if (start < 0 || start > row) start = 0;


            int targetRow = start;
            end = col;
            start = 0;
            while (start <= end && end >= 0 && start <= col) {
                int mid = start + (end - start) / 2;
                if (a.get(targetRow).get(mid) == b) return 1;
                else if (a.get(targetRow).get(mid) > b) end = mid - 1;
                else start = mid + 1;
            }


        return 0;

    }

    public static void main(String[] args) {

        //[3]
//  [29]
//  [36]
//  [63]
//  [67]
//  [72]
//  [74]
//  [78]
//  [85]
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        a.add(new ArrayList<Integer>( Arrays.asList(new Integer[] {22, 32, 67})));
//        a.add(new ArrayList<Integer>( Arrays.asList(new Integer[] {1,   3,  5,  7 })));
//        a.add(new ArrayList<Integer>( Arrays.asList(new Integer[] {10, 11, 16, 20 })));
//        a.add(new ArrayList<Integer>( Arrays.asList(new Integer[] {23, 30, 34, 50 })));
//        a.add(new ArrayList<Integer>( Collections.singletonList(63)));
//        a.add(new ArrayList<Integer>(Collections.singletonList(67)));
//        a.add(new ArrayList<Integer>( Collections.singletonList(72)));
//        a.add(new ArrayList<Integer>( Collections.singletonList(74)));
//        a.add(new ArrayList<Integer>( Collections.singletonList(78)));
//        a.add(new ArrayList<Integer>( Collections.singletonList(85)));

        System.out.println(searchMatrix(a, 93));
//        System.out.println(searchMatrix(a, 16));
//        System.out.println(searchMatrix(a, 5));
//        System.out.println(searchMatrix(a, 10));
//        System.out.println(searchMatrix(a, 34));

    }
}

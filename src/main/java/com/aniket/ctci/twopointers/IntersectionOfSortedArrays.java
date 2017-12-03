package com.aniket.ctci.twopointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {

    /**
     * Find the intersection of two sorted arrays.
     OR in other words,
     Given 2 sorted arrays, find all the elements which occur in both the arrays.

     Example :

     Input :
     A : [1 2 3 3 4 5 6]
     B : [3 3 5]

     Output : [3 3 5]

     Input :
     A : [1 2 3 3 4 5 6]
     B : [3 5]

     Output : [3 5]
     NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final output.
     */

    public static void main(String[] args) {
        int[] A = { 10000000};
//        int[] A = { 1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101 };
        int[] B = {10000000};
//        int[] B = { 5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98 };
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int i : A) {
            a.add(i);
        }
        for(int i : B) {
            b.add(i);
        }

        System.out.println(new IntersectionOfSortedArrays().intersect(a, b));
    }

    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(i < a.size() && j < b.size()) {
            int A = a.get(i);
            int B = b.get(j);
            if(A == B) {
                list.add(A);
                i++;
                j++;
            } else if (A < B) i++;
            else j++;
        }
        return list;
    }
}

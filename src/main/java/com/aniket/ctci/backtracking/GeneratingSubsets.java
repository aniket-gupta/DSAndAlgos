package com.aniket.ctci.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneratingSubsets {

    public static void main(String[] args) {
        int[] A = {0,1,2};
        LinkedList<Integer> list = new LinkedList<Integer>();
//        genearteSubset(A, list, 0);
        genSubsetIter(A);
    }


    public static void genearteSubset(int[] A, LinkedList<Integer> subset, int index) {
        if(index == A.length) {
            System.out.println("subset found");
            System.out.println(subset);
        } else {
            System.out.println(A[index] + " is not included");
            genearteSubset(A, subset, index + 1);
            System.out.println(A[index] + " is included");
            subset.add(A[index]);
            genearteSubset(A, subset, index + 1);
            Integer integer = subset.removeLast();
            System.out.println(integer + "removed");
        }
    }

    public static void genSubsetIter(int[] A) {
        int n = A.length;

        List<Integer> subset = null;
        for (int b = 0; b < (1<<n); b++) {

            for (int i = 0; i < n; i++) {
                if ((b & (1<<i)) != 0) System.out.print(A[i] + " ");
            }
            System.out.println();
        }

    }
}

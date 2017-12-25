package com.aniket.ctci.backtracking;

import java.util.*;

public class GeneratingSubsets {

    public static void main(String[] args) {
        int[] A = {0,1,2};
//        LinkedList<Integer> list = new LinkedList<Integer>();
//        genearteSubset(A, list, 0);
//        genSubsetIter(A);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : A) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsetList = subsets(list);
        System.out.println(subsetList);
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

        for (int b = 0; b < (1<<n); b++) {

            for (int i = 0; i < n; i++) {
                if ((b & (1<<i)) != 0) System.out.print(A[i] + " ");
            }
            System.out.println();
        }

    }

    // return lexicographically sorted subset list
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> subsetList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        subsets(A, 0, subset, subsetList);
        Collections.sort(subsetList, new Comparator<ArrayList<Integer>>(){

            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.isEmpty()) return -1;
                if(o2.isEmpty()) return 1;
                int i = 0;
                int j = 0;
                while(i < o1.size() && j < o2.size()) {
                    int a = o1.get(i);
                    int b = o2.get(j);
                    if(a == b) {
                        i++;
                        j++;
                    } else {
                        return a-b;
                    }
                }
                return 0;
            }

        });
        return subsetList;
    }

    private static void subsets(ArrayList<Integer> A, int k, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> subsetList) {
        if(k == A.size()) {
            ArrayList<Integer> list = new ArrayList<Integer>(subset);
            Collections.sort(list);
            subsetList.add(list);
        } else {
            subsets(A, k+1, subset, subsetList);
            subset.add(A.get(k));
            subsets(A, k+1, subset, subsetList);
            subset.remove(subset.size() - 1);
        }
    }
}

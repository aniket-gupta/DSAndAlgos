package com.aniket.ctci.twopointers;

import java.util.ArrayList;

public class MergeTwoSortedListsII {

    public static void main(String[] args) {
        int[] A = {-4, 3 };
        int[] B = {-2, -2};
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int i : A) {
            a.add(i);
        }
        for(int i : B) {
            b.add(i);
        }
        new MergeTwoSortedListsII().merge(a, b);
        System.out.println(a);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        ArrayList<Integer> c = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while(i < a.size() && j < b.size()) {
            int A = a.get(i);
            int B = b.get(j);
            if(A <= B) {
                c.add(A);
                i++;
            } else {
                c.add(B);
                j++;
            }
        }

        while(i < a.size()) {
            c.add(a.get(i));
            i++;
        }
        while(j < b.size()) {
            c.add(b.get(j));
            j++;
        }

        a.clear();
        a.addAll(c);

//        a = new ArrayList<Integer>(c);
//        System.out.println(a);
    }
}

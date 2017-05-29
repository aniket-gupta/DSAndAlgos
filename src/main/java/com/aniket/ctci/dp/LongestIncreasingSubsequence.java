package com.aniket.ctci.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by AnGupta on 3/6/17.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
//        4, 2, 4, 5, 3, 7
        list.add(4);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(7);
//        list.add(14);
//        list.add(12);
//        list.add(20);
//        list.add(15);

//        System.out.println(len_of_LIS(list));

        int[] a  = {99, -7, 10, 9, 2, 3, 8, 8, 1, 2, 3};
        LIS(a);


    }

    public static int len_of_LIS(List<Integer> a) {

        ArrayList<Integer> s = new ArrayList<Integer>();
        s.add(a.get(0));

        System.out.println(s);
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > s.get(s.size() - 1)) {
                s.add(a.get(i));
            } else {
                Integer val = a.get(i);
                int index = Collections.binarySearch(s, val);
                System.out.println(index);
                if (index < 0) {
                    index = -1 * index - 1;
                }

                s.set(index, val);

            }
            System.out.println(s);
        }
        System.out.println(s);
        return s.size();


    }

    public static void LIS(int[] a) {

        int[] small = new int[a.length];
        int[] parent = new int[a.length];
        int size = 0;

        for (int i = 0; i < a.length; i++) {

            if (i == 0) {
                small[size] = i;
                parent[i] = -1;
            } else if (a[i] <= a[small[size]]) {

                int pos = binarySearch(a, small, size + 1, a[i]);
                small[pos] = i;
                if (pos != 0) {
                    parent[i] = small[pos - 1];
                }
            } else {
                size = size + 1;
                small[size] = i;
                parent[i] = small[size - 1];
            }

        }

        System.out.println("Length of Longest Increasing Sub-sequence : " + (size + 1));

        int pos = small[size];

        while (size >= 0) {
            System.out.print(a[pos] + " ");
            pos = parent[pos];
            size--;
        }

    }

    private static int binarySearch(int[] a, int[] small, int n, int val) {

        int low = 0;
        int high = n - 1;
        int mid;

        while (low < high) {

            mid = low + (high - low) / 2;

            if (a[small[mid]] > val) {
                high = mid;
            } else if (a[small[mid]] < val) {
                low = mid + 1;
            } else {
                return mid; // found
            }

        }

        return low; //not found
    }


}

package com.aniket.ctci.twopointers;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {

    /**
     * Remove duplicates from Sorted Array
     * Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
     * <p>
     * Note that even though we want you to return the new length, make sure to change the original array as well in place
     * <p>
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * <p>
     * Example:
     * Given input array A = [1,1,2],
     * Your function should return length = 2, and A is now [1,2].
     */

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(500);
        a.add(500);
        a.add(500);
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(a));
        a.clear();
        a.add(0);
        a.add(1);
        a.add(2);
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(a));
        a.clear();
        a.add(0); a.add(0); a.add(0); a.add(0); a.add(0); a.add(0);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(a));
    }

    public int removeDuplicates(ArrayList<Integer> a) {

        if (a == null || a.size() == 0) return 0;
        if (a.size() == 1) return 1;
        int i = 0;
        int j = i + 1;
        while (i < j && i < a.size()) {

            while (j < a.size() && a.get(j).equals(a.get(i))) {
                j++;
            }
            if (j >= a.size()) return i + 1;

            for (int k = i + 1; k < j; k++) {
                a.set(k, a.get(j));
            }
            i++;
            j = i + 1;

        }

        return i;
    }
}

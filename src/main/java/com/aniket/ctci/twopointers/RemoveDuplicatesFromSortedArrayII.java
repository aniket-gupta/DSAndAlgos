package com.aniket.ctci.twopointers;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArrayII {

    /**
     * Remove Duplicates from Sorted Array
     * <p>
     * Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * <p>
     * Note that even though we want you to return the new length, make sure to change the original array as well in place
     * <p>
     * For example,
     * Given input array A = [1,1,1,2],
     * <p>
     * Your function should return length = 3, and A is now [1,1,2].
     */
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        int len = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();

        a.clear();
        a.add(500);
        a.add(500);
        a.add(500);
        len = removeDuplicatesFromSortedArrayII.removeDuplicates(a);
        System.out.println(len);
        System.out.println(a.subList(0, len));
        a.clear();
        a.add(0);
        a.add(1);
        a.add(2);
        len = removeDuplicatesFromSortedArrayII.removeDuplicates(a);
        System.out.println(len);
        System.out.println(a.subList(0, len));
        a.clear();
        a.add(0);
        a.add(0);
        a.add(0);
        a.add(0);
        a.add(0);
        a.add(0);
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
        len = removeDuplicatesFromSortedArrayII.removeDuplicates(a);
        System.out.println(len);
        System.out.println(a.subList(0, len));

        a.clear();
        a.add(0);
        a.add(0);

        a.add(1);
        a.add(1);

        a.add(2);
        a.add(2);

        len = removeDuplicatesFromSortedArrayII.removeDuplicates(a);
        System.out.println(len);
        System.out.println(a.subList(0, len));

        a.clear();
        a.add(1000);
        a.add(1000);
        a.add(1000);
        a.add(1000);
        a.add(1001);
        a.add(1002);
        a.add(1003);
        a.add(1003);
        a.add(1004);
        a.add(1004);
        a.add(1004);
        a.add(1010);
        a.add(1010);
        a.add(1010);
        a.add(1010);
        a.add(1010);
        a.add(1010);
        a.add(1010);
        a.add(1010);


        len = removeDuplicatesFromSortedArrayII.removeDuplicates(a);
        System.out.println(len);
        System.out.println(a.subList(0, len));
    }

    public int removeDuplicates(ArrayList<Integer> a) {

        if (a == null || a.size() == 0) return 0;
        if (a.size() == 1) return 1;
        int i = 0;
        int j = i + 1;
        int len = a.size();
        while (i < j && i < len) {

            int count = 1;
            while (j < len && a.get(j).equals(a.get(i))) {
                j++;
                count++;
            }
            if (j >= len) {
                return count > 1 ? i + 2 : i + 1;
            }

            if (count > 1) {
                int n = i + 2;
                for (int k = j; k < len; k++) {
                    a.set(n++, a.get(k));
                }
                len = n;
            }

            i = count > 1 ? i + 2 : i + 1;
            j = i + 1;

        }

        return i > len ? len : i;
    }
}

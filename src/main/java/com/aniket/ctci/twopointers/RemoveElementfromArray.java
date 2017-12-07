package com.aniket.ctci.twopointers;

import java.util.ArrayList;

public class RemoveElementfromArray {

    /**
     * Remove Element
     * <p>
     * Given an array and a value, remove all the instances of that value in the array.
     * Also return the number of elements left in the array after the operation.
     * It does not matter what is left beyond the expected length.
     * <p>
     * Example:
     * If array A is [4, 1, 1, 2, 1, 3]
     * and value elem is 1,
     * then new length is 3, and A is now [4, 2, 3]
     * Try to do it in less than linear additional space complexity.
     */

    public static void main(String[] args) {
        RemoveElementfromArray removeElementfromArray = new RemoveElementfromArray();
        ArrayList<Integer> a = new ArrayList<Integer>();
        int len = 0;
        a.clear();
        a.add(500);
        a.add(500);
        a.add(500);
        len = removeElementfromArray.removeElement(a, 500);
        System.out.println(len);
        System.out.println(a.subList(0, len));
        a.clear();
        a.add(0);
        a.add(1);
        a.add(2);
        len = removeElementfromArray.removeElement(a, 500);
        System.out.println(len);
        System.out.println(a.subList(0, len));

        len = removeElementfromArray.removeElement(a, 1);
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
        a.add(0);
        a.add(0);
        a.add(0);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        len = removeElementfromArray.removeElement(a, 1);
        System.out.println(len);
        System.out.println(a.subList(0, len));
        a.clear();
        a.add(0);
        len = removeElementfromArray.removeElement(a, 0);
        System.out.println(len);
        System.out.println(a.subList(0, len));

    }

    public int removeElement(ArrayList<Integer> a, int b) {

        if (a == null || a.size() == 0) return 0;
        if (a.size() == 1 && a.get(0).intValue() == b) return 0;


        int start = 0;
        for (int i = 0; i < a.size(); i++) {

            if (a.get(i).intValue() != b) {
                a.set(start, a.get(i).intValue());
                start++;
            }

        }

        return start;
    }
}

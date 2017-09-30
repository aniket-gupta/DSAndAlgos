package com.aniket.ctci.binarysearch;

import java.util.List;

public class RotatedSortedArraySearch {

    /**
     Suppose a sorted array is rotated at some pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

     You are given a target value to search. If found in the array, return its index, otherwise return -1.

     You may assume no duplicate exists in the array.

     Input : [4 5 6 7 0 1 2] and target = 4
     Output : 0


     */

    public int search(final List<Integer> a, int b) {
        if(a == null || a.isEmpty()) return -1;

        int pivotPoint = findPivotPoint(a);

        int start = 0;
        int end = a.size() - 1;

        if(pivotPoint > 0) {
            if(b < a.get(0)) {
                start = pivotPoint;
            } else {
                end = pivotPoint - 1;
            }
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(a.get(mid) == b) return mid;
            else if (a.get(mid) > b) end = mid - 1;
            else start = mid + 1;
        }

        return -1;

    }

    private int findPivotPoint(final List<Integer> a) {

        int start = 0;
        int end = a.size() - 1;
        int n = a.size();

        while(start <= end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            if(a.get(mid) <= a.get(prev) && a.get(mid) <= a.get(next)) {
                return mid;
            }  else if (a.get(mid) <=  a.get(end)) end = mid - 1;
            else start = mid + 1;
        }

        return -1;

    }
}

package com.aniket.ctci.binarysearch;

import java.util.List;

public class RotatedSortedArraySearch {

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

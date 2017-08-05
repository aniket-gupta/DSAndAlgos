package com.aniket.ctci.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnGupta on 8/5/17.
 */
public class SearchForARange {

    /**
     *  Given a sorted array of integers, find the starting and ending position of a given target value.

        Your algorithm’s runtime complexity must be in the order of O(log n).

        If the target is not found in the array, return [-1, -1].

         Example:

         Given [5, 7, 7, 8, 8, 10]

         and target value 8,

         return [3, 4].
     */

    public ArrayList<Integer> searchRange(final List<Integer> a, int target) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(-1);
        result.add(-1);

        result.set(0, findFirstOccurrence(a, target));
        result.set(1, findLastOccurrence(a, target));

        return result;
    }

    private int findFirstOccurrence(final List<Integer> a, int target) {
        if(a == null || a.isEmpty()) return -1;

        int result = Integer.MAX_VALUE;

        int start = 0;
        int end = a.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(a.get(mid) >= target) {
                result = (a.get(mid) == target) ? Math.min(result, mid) : result;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if(result == Integer.MAX_VALUE) return -1;
        return result;
    }

    private int findLastOccurrence(final List<Integer> a, int target) {
        if(a == null || a.isEmpty()) return -1;

        int result = Integer.MIN_VALUE;

        int start = 0;
        int end = a.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(a.get(mid) <= target) {
                result = (a.get(mid) == target) ? Math.max(result, mid) : result;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(result == Integer.MIN_VALUE) return -1;
        return result;
    }
}

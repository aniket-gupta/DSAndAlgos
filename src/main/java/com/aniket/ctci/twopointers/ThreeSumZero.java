package com.aniket.ctci.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThreeSumZero {
    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Note:
     * <p>
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     * The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
     */

    /**
     * Solution Approach
     * 1. Sort all element of array
     * 2. Run loop from i=0 to n-2.
     * Initialize two index variables l=i+1 and r=n-1
     * 4. while (l < r)
     * Check sum of arr[i], arr[l], arr[r] is
     * zero or not if sum is zero then print the
     * triplet and do l++ and r--.
     * 5. If sum is less than zero then l++
     * 6. If sum is greater than zero then r--
     * 7. If not exist in array then print not found.
     */

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        int[] A = {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
        for (int i : A) {
            a.add(i);
        }
        System.out.println(new ThreeSumZero().threeSum(a));
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {


        Collections.sort(a);
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < a.size() - 2; i++) {
            int j = i + 1;
            int k = a.size() - 1;
            while (j < k) {
                int b = a.get(j);
                int c = a.get(k);
                if (b + c + a.get(i) == 0) {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(a.get(i));
                    triplet.add(b);
                    triplet.add(c);
                    set.add(triplet);
                    j++;
                } else if (a.get(i) + b + c > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> list :
                set) {
            result.add(list);
        }
        return result;


    }
}

package com.aniket.ctci.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {

    /**
     * Find the largest continuous sequence in a array which sums to zero.
     * <p>
     * Example:
     * <p>
     * <p>
     * Input:  {1 ,2 ,-2 ,4 ,-4}
     * Output: {2 ,-2 ,4 ,-4}
     */

    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);

            if (map.get(sum) != null) {
                if (maxLength < (i - map.get(sum))) {
                    start = map.get(sum) + 1;
                    end = i;
                    maxLength = i - map.get(sum);
                    System.out.printf("start = %d, end = %d, maxLength = %d \n", start, end, maxLength);

                }

            } else
                map.put(sum, i);
        }

        if (start >= 0 && end >= 0) {
            for (int i = start; i <= end; i++) {
                result.add(A.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] a = {-16, -10, -7, -11, 16, -15, 2, 28, -27, 19, -20, -22, -22, 21, -21, 18, -20, 24, 24, -12, -27, 2, -13, 3, 1, -18, 10, 20, -29, -4};

        ArrayList<Integer> A = new ArrayList<>();
        for (int i : a) {
            A.add(i);
        }

        System.out.println(new LargestContinuousSequenceZeroSum().lszero(A));

    }

}

package com.aniket.ctci.hashing;

import java.lang.reflect.Array;
import java.util.*;

public class DiffkII {

    /**
     * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
     * <p>
     * Example :
     * <p>
     * Input :
     * <p>
     * A : [1 5 3]
     * k : 2
     * Output :
     * <p>
     * 1
     * as 3 - 1 = 2
     * <p>
     * Return 0 / 1 for this problem.
     */

    public static void main(String[] args) {
        int[] A = {77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : A) {
            list.add(i);
        }

        System.out.println(new DiffkII().diffPossible(list, 53));
    }

    public int diffPossible(final List<Integer> a, int b) {
        HashSet<Integer> visited = new HashSet<Integer>();
        for (Integer number : a) {
            if (visited.contains(number + b) || visited.contains(number - b)) return 1;
            visited.add(number);
        }
        return 0;
    }
}

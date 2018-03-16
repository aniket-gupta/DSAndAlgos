package com.aniket.ctci.hashing;

import java.lang.reflect.Array;
import java.util.*;

public class DiffkII {

    public static void main(String[] args) {
        int[] A = {77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0 };
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

package com.aniket.ctci.twopointers;

import java.util.ArrayList;

public class SortByColor {

    /**
     * Given an array with n objects colored red, white or blue,
     * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     * <p>
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * <p>
     * Note: Using library sort function is not allowed.
     * <p>
     * Example :
     * <p>
     * Input : [0 1 2 0 1 2]
     * Modify array so that it becomes : [0 0 1 1 2 2]
     */

    public void sortColors(ArrayList<Integer> a) {

        if (a == null || a.size() < 2) return;

        int r = 0;
        int w = 0;
        int b = 0;

        for (int i = 0; i < a.size(); i++) {
            int c = a.get(i);
            if (c == 0) r++;
            else if (c == 1) w++;
            else if (c == 2) b++;
        }

        int i = 0;
        while (r-- > 0) a.set(i++, 0);
        while (w-- > 0) a.set(i++, 1);
        while (b-- > 0) a.set(i++, 2);


    }
}

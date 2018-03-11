package com.aniket.ctci.hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class ColorfulNumber {

    /**
     * For Given Number N find if its COLORFUL number or not
     * <p>
     * Return 0/1
     * <p>
     * COLORFUL number:
     * <p>
     * A number can be broken into different contiguous sub-subsequence parts.
     * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
     * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
     * Example:
     * <p>
     * N = 23
     * 2 3 23
     * 2 -> 2
     * 3 -> 3
     * 23 -> 6
     * this number is a COLORFUL number since product of every digit of a sub-sequence are different.
     * <p>
     * Output : 1
     */

    public static void main(String[] args) {
        int a = 3245;

        while (a > 0) {
            int n = a % 10;
            a = a / 10;
            System.out.println(n);
//            System.out.println(a);
        }
    }

    public int colorful(int A) {

        ArrayList<Integer> digits = getDigits(A);

        int i = 0;

        HashSet<Integer> set = new HashSet<>();

        while (i < digits.size()) {

            int j = i + 1;
            if (set.contains(digits.get(i))) return 0;

            set.add(digits.get(i));

            int result = digits.get(i);

            while (j < digits.size()) {
                result *= digits.get(j);
                if (set.contains(result)) return 0;
                set.add(result);
                j++;
            }
            i++;
        }

        return 1;

    }

    private ArrayList<Integer> getDigits(int a) {

        ArrayList<Integer> digits = new ArrayList<>();
        while (a > 0) {
            int n = a % 10;
            a = a / 10;
            digits.add(n);
        }

        return digits;
    }


}

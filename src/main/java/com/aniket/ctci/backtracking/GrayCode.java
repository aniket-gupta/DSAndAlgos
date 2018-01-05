package com.aniket.ctci.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class GrayCode {

    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.
     * <p>
     * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
     * <p>
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     * <p>
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     * There might be multiple gray code sequences possible for a given n.
     * Return any such sequence.
     */

    // Easy to solve with iterative approach
    public static void main(String[] args) {
        GrayCode obj = new GrayCode();
        ArrayList<Integer> integers = obj.grayCode(8);
        System.out.println(integers);

        int num = 0 ^ (1 << 1);
        System.out.println(num);
    }


    /**
     * 1. The goal of the problem is to test your backtracking coding ability.
     * So our effort will pay on this first. In order to use backtracking,
     * you need to know how gray code works or how can it be built with backtracking.
     * See figure below, when n=1, the code is 0 and 1. And when n=2, you can see how it's built base on n=1!
     * And the same way, n=3 is built base on n=2.
     * http://2.bp.blogspot.com/-Fml6bo0PTUQ/Va_xQCaFxGI/AAAAAAAAAA4/ygHR0jEcO8Y/s1600/leet.png
     * So based on this rule, we can code with backtracking. And the backtracking is a way from top to down, like we build n=N first, in the building of n=N, we call n=N-1. In N-1, we call N-2, ... and all the way to n=1.
     * <p>
     * 2. Another thing is the representation of these digits. In above figure, all are binary digits. In codes, we use decimal. And we need to return decimal instead of binary digits. You can see the solution about this problem in following codes.
     */
    public ArrayList<Integer> grayCode(int a) {

        if (a == 0) return new ArrayList<>();

        ArrayList<String> bStrings = new ArrayList<>();

        bStrings.add("0");
        bStrings.add("1");

        while (bStrings.size() < (int) Math.pow(2, a)) {

            int end = bStrings.size() - 1;

            for (int i = end; i >= 0; i--) {
                bStrings.add(bStrings.get(i));
            }

            for (int i = 0; i < bStrings.size() / 2; i++) {
                bStrings.set(i, "0" + bStrings.get(i));
            }

            for (int i = bStrings.size() / 2; i < bStrings.size(); i++) {
                bStrings.set(i, "1" + bStrings.get(i));
            }

        }

//        System.out.println(bStrings);

        ArrayList<Integer> integers = new ArrayList<>();
        for (String str : bStrings) {
            int integer = Integer.parseInt(str, 2);
            integers.add(integer);
        }

        return integers;
    }

//    private void grayCode(int n, ArrayList<Integer> res) {
//        if (res.size() != (int) Math.pow(2, n)) {
//            for (int i = 1; i < Math.pow(2, n); i++) {
//                int lastVal = res.get(res.size() - 1);
//                if(res.contains(i)) continue;
//
//                if (isValid(lastVal, i)) {
//                    res.add(i);
//                    grayCode(n, res);
//
////                    res.remove(res.size() - 1);
//                }
//            }
//        }
//
//    }
//
//    private boolean isValid(int lastVal, int curr) {
//        String a = Integer.toBinaryString(lastVal);
//        String b = Integer.toBinaryString(curr);
//
//        int i = a.length() - 1;
//        int j = b.length() - 1;
//        int count = 0;
//        while (i >= 0 && j >= 0) {
//            if (a.charAt(i) != b.charAt(j)) count++;
//            i--;
//            j--;
//        }
//
//        if(i >= 0) count += i+1;
//        if(j >= 0) count += j+1;
//
//        if (count == 1) return true;
//        return false;
//
//    }

}

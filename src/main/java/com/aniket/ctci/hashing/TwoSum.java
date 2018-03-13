package com.aniket.ctci.hashing;

import java.util.*;

public class TwoSum {

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.

     The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
     Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

     If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

     Input: [2, 7, 11, 15], target=9
     Output: index1 = 1, index2 = 2
     */

    public static void main(String[] args) {
        int[] a = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        int b = -3;
        ArrayList<Integer> A = new ArrayList<>();
        for (int i: a) {
            A.add(i);
        }
        System.out.println(new TwoSum().twoSum(A, b));
    }

    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < a.size(); i++){
            int curr = a.get(i);

            if (map.containsKey(b-curr)){
                int index = map.get(b-curr);
                ans.add(index);
                ans.add(i + 1);
                return ans;
            }else if (!map.containsKey(curr)){
                map.put(curr, i + 1);
            }
        }

        return ans;
    }

//    private int getFirstGreaterIndex(ArrayList<Integer> indexes, int i) {
//        for(int ind : indexes) {
//            if (ind > i) return ind;
//        }
//        return -1;
//    }
//
//    class Pair implements Comparable<Pair> {
//
//        int a;
//        int b;
//
//        @Override
//        public int compareTo(Pair o) {
//            if(this.a == o.a && this.b == o.b) return 0;
//            if(this.b < o.b) return -1;
//            else if(this.b == o.b && this.a < o.a) return -1;
//            return 1;
//        }
//    }
}

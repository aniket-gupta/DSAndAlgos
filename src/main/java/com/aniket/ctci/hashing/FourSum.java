package com.aniket.ctci.hashing;

import java.util.*;

public class FourSum {

    /**
     * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     * <p>
     * Note:
     * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
     * The solution set must not contain duplicate quadruplets.
     * Example :
     * Given array S = {1 0 -1 0 -2 2}, and target = 0
     * A solution set is:
     * <p>
     * (-2, -1, 1, 2)
     * (-2,  0, 0, 2)
     * (-1,  0, 0, 1)
     */

    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2};
        int b = 0;
        ArrayList<Integer> A = new ArrayList<>();
        for (int i : a) {
            A.add(i);
        }

        System.out.println(new FourSum().fourSum(A, b));
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();

        for (int i = 0; i < A.size() - 1; i++) {
            int a = A.get(i);
            for (int j = i + 1; j < A.size(); j++) {
                int b = A.get(j);

                int sum = a + b;
                int remain = B - sum;
                if (map.containsKey(remain)) {
                    ArrayList<Pair> pairs = map.get(remain);

                    for (Pair pair: pairs) {
                        if ( i != pair.a && i != pair.b && j != pair.a && j != pair.b) {
                            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a, b, A.get(pair.a), A.get(pair.b)));
                            Collections.sort(list);
                            if(!res.contains(list))
                                res.add(list);
                        }
                    }


                }

                if(map.containsKey(sum)) {
                    map.get(sum).add(new Pair(i, j));
                } else {
                    ArrayList<Pair> newPairList = new ArrayList<>();
                    newPairList.add( new Pair(i, j));
                    map.put(sum, newPairList);
                }




            }
        }

        Collections.sort(res, (o1, o2) -> {
            if(o1.equals(o2)) return 0;
            if (o1.get(0) < o2.get(0)) return -1;
            if(o1.get(0) <= o2.get(0) && o1.get(1) < o2.get(1)) return -1;
            if(o1.get(0) <= o2.get(0) && o1.get(1) <= o2.get(1) && o1.get(2) < o2.get(2)) return -1;
            if(o1.get(0) <= o2.get(0) && o1.get(1) <= o2.get(1) && o1.get(2) <= o2.get(2) && o1.get(3) < o2.get(3)) return -1;
            return 1;

        });

        return res;

    }


    // without hashmap
    public ArrayList<ArrayList<Integer>> fourSum1(ArrayList<Integer> A, int target) {
        Collections.sort(A);
        Integer[] num = new Integer[A.size()];
        num = A.toArray(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int k = j + 1;
                int l = num.length - 1;

                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);

                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }

                        k++;
                        l--;
                    }
                }
            }
        }

        return result;
    }

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a &&
                    b == pair.b;
        }

        @Override
        public int hashCode() {

            return Objects.hash(a, b);
        }
    }
}

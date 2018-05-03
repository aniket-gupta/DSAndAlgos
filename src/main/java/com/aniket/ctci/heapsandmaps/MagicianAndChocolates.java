package com.aniket.ctci.heapsandmaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    /**
     * Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.
     *
     * Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.
     *
     * For example,
     *
     * K = 3
     * N = 2
     * A = 6 5
     *
     * Return: 14
     * At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
     * At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
     * At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
     * so, total number of chocolates eaten: 6 + 5 + 3 = 14
     *
     * Note: Return your answer modulo 10^9+7
     */

    public static void main(String[] args) {
        int k = 3;
        int[] bags = {6,5};
        System.out.println(nchoc(k,bags));
    }

    public static  int nchoc(int k, int[] bags) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){

            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2) * -1;
            }

        });

        int maxChocEaten = 0;

        // create max heap
        for(int i = 0; i < bags.length; i++) {
            queue.offer(bags[i]);
        }

        for(int i = 0; i < k; i++) {
            int numChoc = queue.poll();
            int newNumChoc = numChoc/2;
            queue.offer(newNumChoc);
            maxChocEaten = (maxChocEaten%1000000007 + numChoc%1000000007)%1000000007;
        }

        return maxChocEaten;

    }
}

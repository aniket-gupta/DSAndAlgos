package com.aniket.ctci.heapsandmaps;


import java.util.*;

public class NmaxPairCombinations {

    /**
     * Given two arrays A & B of size N each.
     * Find the maximum n elements from the sum combinations (Ai + Bj) formed from elements in array A and B.
     * <p>
     * For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
     * and maximum 2 elements are 6, 5
     * <p>
     * Example:
     * <p>
     * N = 4
     * a[]={1,4,2,3}
     * b[]={2,5,1,6}
     * <p>
     * Maximum 4 elements of combinations sum are
     * 10   (4+6),
     * 9    (3+6),
     * 9    (4+5),
     * 8    (2+6)
     */

    public static void main(String[] args) {
        System.out.println(
                new NmaxPairCombinations().solve(
                        new ArrayList<Integer>(Arrays.asList(1, 4, 2, 3)),
                        new ArrayList<Integer>(Arrays.asList(2, 5, 1, 6))));
    }

    public  ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        Comparator<Integer> comp = (o1, o2) -> {
            int val = o1.compareTo(o2);
            return val == 0 ? 0 : val * -1;
        };

        PriorityQueue<HeapObject> queue = new PriorityQueue<>();
//        TreeSet<Integer> set = new TreeSet<Integer>((o1, o2) -> {
//            int val = o1.compareTo(o2);
//            return val == 0 ? 0 : val * -1;
//        });

        Collections.sort(A, comp);
        Collections.sort(B, comp);

        HashSet<Pair> set = new HashSet<>();

        Pair pair = new Pair(0, 0);
        set.add(pair);
        queue.offer(new HeapObject(A.get(0) + B.get(0), pair));


        ArrayList<Integer> res = new ArrayList<>();

        for (int count = 0; count < A.size(); count++) {
            HeapObject heapObject = queue.poll();
            res.add(heapObject.sum);
            Pair oldPair  = heapObject.pair;
            int i = oldPair.i;
            int j = oldPair.j;
            int sum = 0;
            if(i+1 < A.size()) {
                sum = A.get(i + 1) + B.get(j);
                Pair newPair = new Pair(i + 1, j);
                if (!set.contains(newPair)) {
                    queue.offer(new HeapObject(sum, newPair));
                    set.add(newPair);
                }
            }

            if(j + 1 < B.size()) {
                sum = A.get(i) + B.get(j + 1);
                Pair newPair = new Pair(i, j+1);
                if (!set.contains(newPair)) {
                    queue.offer(new HeapObject(sum, newPair));
                    set.add(newPair);
                }
            }


        }


        return res;

//        int i = 0;
//        int j = 0;
//        while (i < A.size() - 1 && j < B.size() - 1) {
//            int sum = A.get(i) + B.get(j);
//
//            addToQueue(A, queue, sum);
//
//            int a  = A.get(i + 1) + B.get(j);
//            int b  = A.get(i) + B.get(j + 1);
//            if (a  >  b) {
//                i++;
//            } else if (b > a) {
//                j++;
//            } else {
//                addToQueue(A, queue, a);
//                addToQueue(A, queue, b);
//                i++;j++;
//            }
//
//
//        }
//
//        int sum = A.get(i) + B.get(j);
//        addToQueue(A, queue, sum);
//
////        for (int i = 0; i < A.size(); i++) {
////            for (int j = 0; j < B.size(); j++) {
////                int sum = A.get(i) + B.get(j);
////                if (queue.size() == A.size()) {
////                    if (sum > queue.peek()) {
////                        queue.poll();
////                        queue.offer(sum);
////                    }
////                } else {
////                    queue.offer(sum);
////                }
////
////
////            }
////        }
//
//        ArrayList<Integer> res = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            res.add(queue.poll());
//
//        }
////        Collections.reverse(res);
//        return res;

    }

    private static void addToQueue(ArrayList<Integer> A, PriorityQueue<Integer> queue, int sum) {
        if (queue.size() == A.size()) {
            if (sum > queue.peek()) {
                queue.poll();
                queue.offer(sum);
            }
        } else {
            queue.offer(sum);
        }
    }

    private class HeapObject implements Comparable<HeapObject> {

        int sum;
        Pair pair;
        HeapObject(int sum, Pair pair) {
            this.sum = sum;
            this.pair = pair;
        }


        public int compareTo(HeapObject o) {
            return this.sum > o.sum ? -1 : (this.sum == o.sum ? 0 : 1);

        }

        @Override
        public String toString() {
            return "HeapObject{" +
                    "sum=" + sum +
                    '}';
        }
    }

    private class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {

            return Objects.hash(i, j);
        }
    }
}

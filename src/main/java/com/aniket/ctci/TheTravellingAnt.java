package com.aniket.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TheTravellingAnt {

    /**
     * There is an Ant that lives in Baskerville and loves to travel. As Baskerville is a small place, it consists of only 5 cities placed one next to each other.
     *
     * There is a train between each successive cities ie between City 1 - City 2, City 2 - City 3, ... City 5 - City 1. Note that our Ant loves to travel and gets happy after making exactly N train trips and returning back to home.
     * Ant lives in the city 1 from where she begins her journey. She asks you to find the number of ways she can make N train trips and come back to home.
     *
     * Since the number of ways can be huge, print that number modulo 10^9 + 7.
     *
     * Input
     * First line contains T, the number of test cases.
     * Then T lines follow.
     * Each line contains a single integer n, representing the number of train trips the ant needs to make.
     *
     * Output
     * For each test case, print a single line containing the answer to the problem.
     *
     * Constraints
     * 1 <= T <= 1000
     * 0 <= n <= 10^18
     *
     * Sample Input
     * 3
     * 0
     * 3
     * 4
     * Sample Output
     * 1
     * 0
     * 6
     * Explanation
     * In first case, ant has to make 0 trips. So the ant stays at city 1 and has only 1 option.
     * In second case, ant has to make 3 trips. No matter what combination we try, we can never reach back to city 1 back after 3 trips. So answer is 0.
     * In third case, ant makes 4 trips. There are 6 ways in which it can reach back to city 1.
     * Way 1: 1-->2-->1-->2-->1
     * Way 2: 1-->2-->3-->2-->1
     * Way 3: 1-->5-->1-->5-->1
     * Way 4: 1-->5-->4-->5-->1
     * Way 5: 1-->5-->1-->2-->1
     * Way 6: 1-->2-->1-->5-->1
     */

    static long limit = 1000000007;
    static int count = 0;

    private static class GraphNode {

        int val;
        ArrayList<GraphNode> neighbours;

        GraphNode(int val) {
            this.val = val;
            neighbours = new ArrayList<>();
        }

        public void addNeighbour(GraphNode node) {
            this.neighbours.add(node);
        }

    }

    private static class Pair {
        int source;
        long trip;

        Pair(int source, long trip) {
            this.source = source;
            this.trip = trip;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return source == pair.source &&
                    trip == pair.trip;
        }

        @Override
        public int hashCode() {

            return 31 * new Integer(source).hashCode() + new Long(trip).hashCode();
        }
    }

    public static void main(String args[] ) throws Exception {
        GraphNode source = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        source.addNeighbour(node2);
        source.addNeighbour(node5);

        node2.addNeighbour(source);
        node2.addNeighbour(node3);

        node3.addNeighbour(node2);
        node3.addNeighbour(node4);

        node4.addNeighbour(node3);
        node4.addNeighbour(node5);

        node5.addNeighbour(source);
        node5.addNeighbour(node4);



        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        while (t-- > 0) {
            long n = in.nextLong();
            HashMap<Pair, Long> map = new HashMap<>();
//            System.out.println(noOfWays(n, source, source, map));
            System.out.println(noOfWays1(n, source, source));
//            System.out.println(count);
//            count = 0;
        }

    }

    public static long noOfWays(long n, GraphNode source, GraphNode des, HashMap<Pair, Long> map) {

        count++;
        if (n == 0 && source.val == des.val) return 1;

        if(n == 1) {
            ArrayList<GraphNode> neighbours = source.neighbours;
            boolean ispath = false;
            for (GraphNode node : neighbours) {
                if (node.val == des.val) {
                    ispath = true;
                    break;
                }
            }
            return ispath == true ? 1 : 0;
        }



        long noOfWays = 0;
        ArrayList<GraphNode> neighbours = source.neighbours;

        Pair pair = new Pair(source.val, n);
//        System.out.println(pair.hashCode());

        if (map.get(pair) == null) {
            for (int i = 0; i < neighbours.size(); i++) {
                noOfWays = (((long) noOfWays % limit + (long) (noOfWays(n - 1, neighbours.get(i), des, map) % limit)) % limit);
            }
            map.put(pair, noOfWays);
        }
//        }

        return map.get(pair);
//        return noOfWays;
    }


    public static long noOfWays1(long n, GraphNode source, GraphNode des) {

        if(n == 0) return 1;
        if (n == 1) return 0;


        HashMap<Pair, Long> map = new HashMap<>();
        map.put(new Pair(1, 0), (long)1);
        map.put(new Pair(1, 1), (long)0);
        map.put(new Pair(2, 1), (long)1);
        map.put(new Pair(5, 1), (long)1);
        map.put(new Pair(3, 1), (long)0);
        map.put(new Pair(4, 1), (long)0);


        GraphNode temp = source;
        for (long i = 2; i <= n; i++) {
            Long n1 = map.get(new Pair( temp.neighbours.get(0).val, i -1));
            if(n1 == null) {
                n1 = getMaxWays(temp.neighbours.get(0), des, i -1, map);
                map.put(new Pair( temp.neighbours.get(0).val, i -1), n1);
            }
            Long n2 = map.get(new Pair( temp.neighbours.get(1).val, i-1));
            if(n2 == null) {
                n2 = getMaxWays(temp.neighbours.get(1), des, i -1, map);
                map.put(new Pair( temp.neighbours.get(1).val, i-1), n2);
            }
            map.put(new Pair(temp.val, i), (n1%limit +n2%limit)%limit);

        }

       return map.get(new Pair(source.val, n));


    }

    private static Long getMaxWays(GraphNode source, GraphNode des, long noOfTrip, HashMap<Pair,Long> map) {
        Pair pair = new Pair(source.val, noOfTrip);
        if (map.get(pair) == null) {

            if (noOfTrip == 0 && source.val == des.val) return (long)1;

            if(noOfTrip == 1) {
                ArrayList<GraphNode> neighbours = source.neighbours;
                boolean ispath = false;
                for (GraphNode node : neighbours) {
                    if (node.val == des.val) {
                        ispath = true;
                        break;
                    }
                }
                return ispath == true ? (long)1 : (long)0;
            }

            long noOfWays = 0;
            ArrayList<GraphNode> neighbours = source.neighbours;
            if (map.get(pair) == null) {
                for (int i = 0; i < neighbours.size(); i++) {
                    noOfWays = (((long) noOfWays % limit + (long) (noOfWays(noOfTrip - 1, neighbours.get(i), des, map) % limit)) % limit);
                }
                map.put(pair, noOfWays);
            }
        }
        return map.get(pair);

    }

}
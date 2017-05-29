package com.aniket.ctci.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by AnGupta on 5/29/17.
 */
public class MergingCommunities {
    /*
        https://www.hackerrank.com/challenges/merging-communities
        People connect with each other in a social network. A connection between Person  and Person  is represented as . When two persons belonging to different communities connect, the net effect is the merger of both communities which  and  belongs to.

        At the beginning, there are  people representing  communities. Suppose person  and  connected and later  and  connected, then ,, and  will belong to the same community.

        There are two type of queries:

         communities containing person  and  merged (if they belong to different communities).

         print the size of the community to which person  belongs.

        Input Format

        The first line of input will contain integers  and , i.e. the number of people and the number of queries.
        The next  lines will contain the queries.

        Constraints :



        Output Format

        The output of the queries.

        Sample Input

        3 6
        Q 1
        M 1 2
        Q 2
        M 2 3
        Q 3
        Q 2
        Sample Output

        1
        2
        3
        3
        Explanation

        Initial size of each of the community is .
     */

    private static HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i++) {
            makeSet(i);
        }
        int t = scanner.nextInt();
        while(t-- > 0) {
            String s = scanner.next();
            if(s.equals("Q")) {
                int num = scanner.nextInt();
                System.out.println(getSize(num));
            } else if(s.equals("M")) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                union(a, b);
            }
        }


    }

    private static int getSize(int i) {
        Integer setI = findSet(i);
        if(setI != null) {
            return map.get(setI).size;
        }
        return -1;
    }

    private static  void makeSet(int i) {
        map.put(i, new Node(i, 0, 1));
    }

    private static Integer findSet(int i) {
        Node node = map.get(i);
        if(node == null) {
            return null;
        }
        if (i != node.parent) {
            node.parent = findSet(node.parent);
        }
        return node.parent;
    }

    private static void union(int a, int b) {
        Integer setA = findSet(a);
        Integer setB = findSet(b);
        if(setA == null || setB == null || setA == setB)
            return;
        Node nodeA = map.get(setA);
        Node nodeB = map.get(setB);
        if(nodeA.rank > nodeB.rank) {
            nodeB.parent = setA;
            nodeA.size += nodeB.size;
        } else {
            nodeA.parent = setB;
            nodeB.size += nodeA.size;
            if(nodeA.rank == nodeB.rank) {
                nodeB.rank++;
            }
        }
    }

    private static class Node {
        Integer parent;
        int rank;
        int size;
        Node(int parent, int rank, int size) {
            this.parent = parent;
            this.rank = rank;
            this.size = size;
        }
    }
}

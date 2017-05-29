package com.aniket.ctci.set;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by AnGupta on 5/29/17.
 */
public class ComponentsInAGraph {

    /*
        https://www.hackerrank.com/challenges/components-in-graph
     */


    private static long max = 2;
    private static HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(map.get(a) == null) {
                makeSet(a);
            }
            if(map.get(b) == null) {
                makeSet(b);
            }
            union(a, b);
        }

        System.out.print(getMinSize() + " " + max);
    }

    private static long getMinSize() {
        Set<Integer> set = map.keySet();
        long min = 0;
        for(Integer n : set) {
            long size = map.get(findSet(n)).size;
            if(min == 0) {
                min = size;
            } else {
                min = Math.min(min, size);
            }
        }
        return min;
    }

    private static long getSize(int i) {
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
            max = Math.max(max, nodeA.size);

        } else {
            nodeA.parent = setB;
            nodeB.size += nodeA.size;
            max = Math.max(max, nodeB.size);
            if(nodeA.rank == nodeB.rank) {
                nodeB.rank++;
            }
        }
    }

    private static class Node {
        Integer parent;
        long rank;
        long size;
        Node(int parent, long rank, long size) {
            this.parent = parent;
            this.rank = rank;
            this.size = size;
        }
    }
}

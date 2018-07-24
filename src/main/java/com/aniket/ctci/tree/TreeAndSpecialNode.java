package com.aniket.ctci.tree;

import java.util.*;

public class TreeAndSpecialNode {

    /**
     * Given a rooted undirected tree T consisting of N nodes with 1 as the root of the tree. Each node of the tree has a value associated with it, where the value of the ith node is A[i]. A node x is said to be special if the path from the root to node x contains all distinct values. Your task is to find the number of special nodes.
     *
     * Input:
     *
     * The first line contains an integer N denoting the number of nodes in the tree.
     *
     * Next line contains N space separated integers where the ith integer denotes A[i].
     *
     * Next N-1 lines consist of two space-separated integers u and v, denoting that there is an edge between node u to node v.
     *
     * Output:
     *
     * Print a single integer, denoting the number of special nodes in the tree.
     *
     * Constraints:
     *
     *
     * Sample Input
     * 7
     * 1 7 2 3 7 2 5
     * 1 2
     * 1 3
     * 2 4
     * 2 5
     * 3 6
     * 3 7
     * Sample Output
     * 5
     * Explanation
     * Path from node 1 to node 1 contains: [1]
     *
     * The path from node 1 to node 2 contains: [1, 7]
     *
     * The path from node 1 to node 3 contains: [1, 2]
     *
     * The path from node 1 to node 4 contains: [1, 7, 3]
     *
     * The path from node 1 to node 5 contains: [1, 7, 7]
     *
     * The path from node 1 to node 6 contains: [1, 2, 2]
     *
     * The path from node 1 to node 7 contains: [1, 2, 5]
     *
     * Hence, 1, 2, 3, 4 and 7 are special nodes.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        STreeNode[] nodes = new STreeNode[n];

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            nodes[i] = new STreeNode(val);
            if(map.containsKey(val)) {
                set.add(map.get(val));
                set.add(i);


            } else {
                map.put(val, i);
            }

        }
        STreeNode root = nodes[0];
        Map<STreeNode, STreeNode> parentMap = new LinkedHashMap<>();
        for (int i = 1; i <= n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            nodes[v-1].parent = nodes[u-1];
            if(set.contains(v-1)) {
                if (!isSpecialNode(nodes[v-1] )) count++;

            }
        }

        System.out.println(n - count);
        scanner.close();
    }





    private static boolean isSpecialNode(STreeNode curr) {
        Set<Integer> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr.data)) return false;
            set.add(curr.data);
            curr = curr.parent; //parentMap.get(curr);
        }
        return true;
    }
}



class STreeNode {

    int data;
    STreeNode parent;

    STreeNode(int data) {
        this.data = data;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        STreeNode sTreeNode = (STreeNode) o;
        return data == sTreeNode.data &&
                Objects.equals(parent, sTreeNode.parent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, parent);
    }

    @Override
    public String toString() {
        return "STreeNode{" +
                "data=" + data +
                ", parent=" + parent +
                '}';
    }
}

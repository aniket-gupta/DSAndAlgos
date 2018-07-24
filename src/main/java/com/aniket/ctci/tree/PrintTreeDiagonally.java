package com.aniket.ctci.tree;

import java.util.*;

public class PrintTreeDiagonally {

    /**
     * Diagonal Traversal of Binary Tree
     * https://contribute.geeksforgeeks.org/wp-content/uploads/d1-1.png
     * Diagonal Traversal of binary tree :
     *  8 10 14
     *  3 6 7 13
     *  1 4
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(7);
        printTreeDiagonally(root);
    }

    public static void printTreeDiagonally(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        printTreeDiagonally(root, 0, map);
        Set<Integer> integers = map.keySet();
        for (int integer : integers) {
            List<Integer> list = map.get(integer);
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    public static void printTreeDiagonally(TreeNode root, int lev, Map<Integer, List<Integer>> map) {
        if (root == null) return;
        if (!map.containsKey(lev)) {
            map.put(lev, new ArrayList<>());
        }
        map.get(lev).add(root.val);
        printTreeDiagonally(root.left, lev + 1, map);
        printTreeDiagonally(root.right, lev, map);
    }


}

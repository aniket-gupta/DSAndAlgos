package com.aniket.ctci.tree;

import java.util.*;

public class BottomViewOfTree {

    /**
     * Bottom View of a Binary Tree
     *                       20
     *                     /    \
     *                   8       22
     *                 /   \    /   \
     *               5      3 4     25
     *                     / \
     *                   10    14
     *
     *  For the above tree the output should be 5, 10, 4, 14, 25.
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        printBottomView(root);
    }

    public static void printBottomView(TreeNode root) {
        if (root == null) return;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levQueue = new LinkedList<>();
        queue.offer(root);
        levQueue.offer(1);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int currLevel = levQueue.poll();
            map.put(currLevel, curr.val);
            if (curr.left != null) {
                queue.offer(curr.left);
                levQueue.offer(currLevel - 1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                levQueue.offer(currLevel + 1);
            }
        }

        Set<Integer> integers = map.keySet();

        for (int integer : integers) {
            System.out.println(map.get(integer));
        }

    }


}

package com.aniket.ctci.tree;

import java.util.Stack;

public class KthSmallestElementInTree {
    /**
     * Given a binary search tree, write a function to find the kth smallest element in the tree.
     *
     * Example :
     *
     * Input :
     *   2
     *  / \
     * 1   3
     *
     * and k = 2
     *
     * Return : 2
     *
     * As 2 is the second smallest element in the tree.
     *  NOTE : You may assume 1 <= k <= Total number of nodes in BST
     */

    public int kthsmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        int val = -1;
        int count = 0;
        while(count < k) {
            TreeNode node = stack.pop();
            val = node.val;
            count++;
            TreeNode right = node.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return val;
    }
}

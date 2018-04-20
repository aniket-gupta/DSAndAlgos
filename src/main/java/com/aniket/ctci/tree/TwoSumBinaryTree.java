package com.aniket.ctci.tree;

import java.util.HashSet;

public class TwoSumBinaryTree {

    /**
     * Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.
     *
     * Return 1 to denote that two such nodes exist. Return 0, otherwise.
     *
     * Notes
     *
     * Your solution should run in linear time and not take memory more than O(height of T).
     * Assume all values in BST are distinct.
     * Example :
     *
     * Input 1:
     *
     * T :       10
     *          / \
     *         9   20
     *
     * K = 19
     *
     * Return: 1
     *
     * Input 2:
     *
     * T:        10
     *          / \
     *         9   20
     *
     * K = 40
     *
     * Return: 0
     */

    public int t2Sum(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return t2SumUtil(root, set,  k);
    }

    public int t2SumUtil(TreeNode root, HashSet<Integer> set, int k) {
        if(root != null) {
            if(t2SumUtil(root.left, set, k) == 1) return 1;
            if(set.contains(k - root.val)) return 1;
            else set.add(root.val);
            if(t2SumUtil(root.right, set, k) == 1) return 1;
        }
        return 0;
    }
}

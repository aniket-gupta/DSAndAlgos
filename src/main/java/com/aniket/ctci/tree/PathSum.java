package com.aniket.ctci.tree;

public class PathSum {

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     *
     * For example:
     * Given the below binary tree and sum = 22,
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */

    public int hasPathSum(TreeNode a, int b) {

        return hasPathSumVal(a, b) == true ? 1 : 0;
    }

    public boolean hasPathSumVal(TreeNode a, int b) {

        if (a != null) {

            int remainingVal = b - a.val;

            if (remainingVal == 0 && a.left == null && a.right == null) {
                return true;
            }
            boolean sumZero = false;

            if (a.left != null) {
                sumZero = hasPathSumVal(a.left, remainingVal);
            }

            if (a.right != null) {
                sumZero = sumZero || hasPathSumVal(a.right, remainingVal);
            }

            return sumZero;

        }
        return b == 0;

    }
}

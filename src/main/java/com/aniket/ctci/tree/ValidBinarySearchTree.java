package com.aniket.ctci.tree;

public class ValidBinarySearchTree {

    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * <p>
     * Assume a BST is defined as follows:
     * <p>
     * The left subtree of a node contains only nodes with keys less than the node’s key.
     * The right subtree of a node contains only nodes with keys greater than the node’s key.
     * Both the left and right subtrees must also be binary search trees.
     * Example :
     * <p>
     * Input :
     *   1
     * /  \
     * 2    3
     * <p>
     * Output : 0 or False
     * <p>
     * <p>
     * Input :
     *   2
     *  / \
     * 1   3
     * <p>
     * Output : 1 or True
     * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
     */

    public int isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int isValidBSTUtil(TreeNode root, int minValue, int maxValue) {
        if (root == null) return 1;
        if (root.val > minValue && root.val < maxValue &&
                isValidBSTUtil(root.left, minValue, root.val) != 0 &&
                isValidBSTUtil(root.right, root.val, maxValue) != 0)
            return 1;
        else return 0;
    }
}

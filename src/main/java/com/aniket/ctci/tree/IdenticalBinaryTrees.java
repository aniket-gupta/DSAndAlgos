package com.aniket.ctci.tree;

public class IdenticalBinaryTrees {

    /**
     * Given two binary trees, write a function to check if they are equal or not.
     *
     * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     *
     * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
     *
     * Example :
     *
     * Input :
     *
     *    1       1
     *   / \     / \
     *  2   3   2   3
     *
     * Output :
     *   1 or True
     */

    public int isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null  && root2 == null) return 1;
        if((root1 != null && root2 == null) ||
                (root1 == null && root2 != null)) return 0;
        if(root1.val != root2.val) return 0;
        if(isSameTree(root1.left, root2.left) == 0 || isSameTree(root1.right, root2.right) == 0)
            return 0;
        return 1;
    }
}

package com.aniket.ctci.tree;


public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.val = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

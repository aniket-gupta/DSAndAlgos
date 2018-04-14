package com.aniket.ctci.tree;

import java.util.Stack;

public class BSTIterator {

    /**
     * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
     *
     * Calling next() will return the next smallest number in the BST.
     *
     * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
     *
     * Credits:
     * Special thanks to @ts for adding this problem and creating all test cases.
     */

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node.right;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return node.val;
    }
}

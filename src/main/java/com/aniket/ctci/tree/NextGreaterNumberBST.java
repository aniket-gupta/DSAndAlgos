package com.aniket.ctci.tree;

public class NextGreaterNumberBST {

    /**
     * Given a BST node, return the node which has value just greater than the given node.
     * <p>
     * Example:
     * <p>
     * Given the tree
     * <p>
     *       100
     *      /   \
     *    98    102
     *   /  \
     * 96    99
     * \
     * 97
     * Given 97, you should return the node corresponding to 98 as thats the value just greater than 97 in the tree.
     * If there are no successor in the tree ( the value is the largest in the tree, return NULL).
     * <p>
     * Using recursion is not allowed.
     * <p>
     * Assume that the value is always present in the tree.
     */
    public TreeNode getSuccessor(TreeNode a, int b) {

        TreeNode curr = find(a, b);
        TreeNode succ = null;
        if (curr == null) succ = null;
        else if (curr.right != null) {
            succ = findMin(curr.right);
        } else {
            TreeNode ancestor = a;
            while (ancestor != curr) {
                if (curr.val < ancestor.val) {
                    succ = ancestor;
                    ancestor = ancestor.left;
                } else ancestor = ancestor.right;
            }
        }
        return succ;
    }

    private TreeNode findMin(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    private TreeNode find(TreeNode root, int data) {
        if (root == null) return null;

        while (root != null && root.val != data) {
            if (root.val < data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}

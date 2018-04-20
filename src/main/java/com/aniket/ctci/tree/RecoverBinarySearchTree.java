package com.aniket.ctci.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Stack;

public class RecoverBinarySearchTree {

    /**
     * Two elements of a binary search tree (BST) are swapped by mistake.
     * Tell us the 2 values swapping which the tree will be restored.
     *
     *  Note:
     * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
     * Example :
     *
     *
     * Input :
     *          1
     *         / \
     *        2   3
     *
     * Output :
     *        [1, 2]
     *
     * Explanation : Swapping 1 and 2 will change the BST to be
     *          2
     *         / \
     *        1   3
     * which is a valid BST
     *
     * Input Tree:
     *          10
     *         /  \
     *        5    8
     *       / \
     *      2   20
     */

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(20);

        System.out.println(new RecoverBinarySearchTree().recoverTreeNonRecursive(root));
    }

    private class References {
        TreeNode prev;
        TreeNode first;
        TreeNode middle;
        TreeNode last;
    }

    public ArrayList<Integer> recoverTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        References references = new References();
        recoverTree(root, references);
        if (references.first != null && references.last != null) {
            res.add(references.first.val);
            res.add(references.last.val);
        } else if (references.first != null && references.middle != null) {
            res.add(references.first.val);
            res.add(references.middle.val);
        }
        return res;

    }

    private void recoverTree(TreeNode root, References references) {
        if(root != null) {
            recoverTree(root.left, references);

            if (references.prev != null && root.val < references.prev.val) {

                // first occurrence
                if (references.first == null) {
                    references.first = references.prev;
                    references.middle = root;
                } else {
                    references.last = root;
                }

            }
            references.prev = root;

            recoverTree(root.right, references);
        }
    }

    public ArrayList<Integer> recoverTreeNonRecursive(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        TreeNode prev = null;
        TreeNode first = null;
        TreeNode middle = null;
        TreeNode last = null;

        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else if (!stack.isEmpty()) {
                root = stack.pop();
                if (prev != null && root.val < prev.val) {
                    if (first == null) {
                        first = prev;
                        middle = root;
                    } else {
                        last = root;
                    }
                }
                prev = root;
                root = root.right;

            } else break;
        }

        if (first != null && last != null) {
            res.add(first.val);
            res.add(last.val);
        } else if (first != null && middle != null) {
            res.add(first.val);
            res.add(middle.val);
        }

        return res;

    }
}

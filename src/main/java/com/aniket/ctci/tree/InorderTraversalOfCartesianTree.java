package com.aniket.ctci.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class InorderTraversalOfCartesianTree {

    /**
     * Given an inorder traversal of a cartesian tree, construct the tree.
     *
     *  Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
     *  Note: You may assume that duplicates do not exist in the tree.
     * Example :
     *
     * Input : [1 2 3]
     *
     * Return :
     *           3
     *          /
     *         2
     *        /
     *       1
     */

    public static void main(String[] args) {
        TreeNode root = new InorderTraversalOfCartesianTree().buildTree(new ArrayList<>(Arrays.asList(1, 2, 4,  3)));
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public TreeNode buildTree(ArrayList<Integer> list) {
        return buildTree(list, 0, list.size() - 1);
    }

    private TreeNode buildTree(ArrayList<Integer> list, int start, int end) {
        if(start > end) return null;

        int maxIndex = findMax(list, start, end);
        TreeNode root = new TreeNode(list.get(maxIndex));
        root.left = buildTree(list, start, maxIndex - 1);
        root.right = buildTree(list, maxIndex + 1, end);
        return root;

    }

    private int findMax(ArrayList<Integer> list, int start, int end) {
        Integer max = null;
        int maxIndex = -1;

        for (int i = start; i <= end; i++) {
            if(max == null || max < list.get(i)) {
                max = list.get(i);
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
